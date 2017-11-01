package com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
* @author BieHongLi 
* @version ����ʱ�䣺2017��3��6�� ����1:54:00 
* �ļ����ص�2�ַ�ʽ��
*     ��ʽ1��ͨ��response�����������д���ֽ������ݣ��������ص���Ӧͷ
*     ��ʽ2��struts�ķ�ʽ
*/
public class DownAction extends ActionSupport{

	
    private static final long serialVersionUID = 1L;
    
    //1:�õ�uploadĿ¼·��
	private String usr=(String) ActionContext.getContext().getSession().get("username");
    private String path="C:\\Users\\10297\\workspacee\\ReadingNotes\\work\\"+usr;
    
    //��һ������ʾ����Ҫ���ص��ļ����б�
    public String list() throws Exception { 
        //2:Ŀ¼����
        File file=new File(path);
        if (!file.exists()){
        	file.mkdirs();
        }
        //3:�õ�����Ҫ���ص��ļ����ļ���
        String[] fileNames=file.list();
        //4:����
        ActionContext ac=ActionContext.getContext();
        //5:�õ�����request��Map(�ڶ��ַ�ʽ)
        @SuppressWarnings("unchecked")
		Map<String,Object> request=(Map<String,Object>)ac.get("request");
        
        request.put("fileNames", fileNames);
        return "list";
    }
    
    //*************2���ļ�����************************/
    //2.1����ȡҪ���ص��ļ����ļ���,�����ַ�����ǰ̨ҳ���ύ������get��ʽ�ύ��
    private String fileName;
    
    public void setFileName(String fileName) {
        //������Ĳ��������⣨get�ύ��
        try {
            fileName=new String(fileName.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }
        //�Ѵ���õ��ļ�������ֵ
        this.fileName = fileName;
    }
    
    //2.2�������ύ��ҵ�񷽷�����struts.xml�����÷���stream��
    public String down() throws Exception {
        return "download";
    }
    
    //2.3���������ķ���
    public InputStream getAttrInputStream() throws FileNotFoundException{
    	System.out.println("Start downloading...");
    	System.out.println(fileName);
//        return ServletActionContext.getServletContext()
//        		.getResourceAsStream("C:\\Users\\10297\\workspacee\\ReadingNotes\\work\\"+fileName);
    	return new FileInputStream(path+"\\"+fileName);
    }
    
    //2.4:������ʾ�������������������ʾ���ļ�����
    public String getDownFileName(){
        try{
            //import java.net.URLEncoder;
            fileName = URLEncoder.encode(fileName,"UTF-8");
        }catch(Exception e){
            throw new RuntimeException();
        }
        
        return fileName;
        
    }
}

package com;

public class Node {
	private int ID;
	private int PID;
	private String nodeName;
	private boolean nodeType;
	
	public int getID(){
		return ID;
	}
	
	public void setID(int ID){
		this.ID=ID;
	}
	
	public int getPID(){
		return PID;
	}
	
	public void setPID(int PID){
		this.PID=PID;
	}
 
	public String getNodeName(){
		return nodeName;
	}
	
	public void setNodeName(String nodeName){
		this.nodeName=nodeName;
	}
	
	public boolean getNodeType(){
		return nodeType;
	}
	
	public void setNodeType(boolean nodeType){
		this.nodeType=nodeType;
	}
	
}

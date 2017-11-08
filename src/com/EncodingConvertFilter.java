package com;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingConvertFilter implements Filter {
	@Override
    public void destroy() {
                                                           
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse rsp,
            FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) rsp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        fc.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {
                                                           
    }
}
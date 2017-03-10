package com.xan.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter1 implements Filter{
	private int illegalLength;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		String comment = req.getParameter("comments");
		if(comment.length()>illegalLength){
			out.println("评论字数已超过正常范围！");
		}else{
			chain.doFilter(req,resp);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		illegalLength = Integer.parseInt(filterConfig.getInitParameter("illegalLength"));
		System.out.println("Filter2:....");
	}


}

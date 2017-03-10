package com.xan.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context01Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡȫ�ֵ������Ķ���
		ServletContext context = getServletContext();
		Object count = context.getAttribute("count");
		if(count == null){
			context.setAttribute("count", context.getInitParameter("count"));
		}else{
			context.setAttribute("count", Integer.parseInt(count.toString())+1);
		}
		out.print("�������Ϊ��"+context.getAttribute("count"));
	}
}

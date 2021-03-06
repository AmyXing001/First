package com.xan.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		//获取session对象
		HttpSession session = request.getSession();
		//输出sessionID
		System.out.println(session.getId());
		//获取绑定的计数器
		Integer count = (Integer) session.getAttribute("count");
		if(count ==null){
			count =1;
		}else{
			count++;
		}
		session.setAttribute("count", count);
		out.println("这是第"+count+"次访问");
		out.close();
	}
}

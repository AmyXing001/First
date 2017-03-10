package com.xan.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();	
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		HttpSession session = request.getSession();
		String yzm = (String)session.getAttribute("yzm");
		//session.setMaxInactiveInterval(10);//设定session超时时间为10秒
		System.out.println(session.getId());
		//判断动作是否为登录
		if(action.equals("login")){
			String name = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String vcode = request.getParameter("vcode");
			if(name.equals("111") && pwd.equals("123456") && vcode.equalsIgnoreCase(yzm)){
				session.setAttribute("uname", name);
				response.sendRedirect("index.jsp");
				//response.sendRedirect(response.encodeRedirectURL("index.jsp"));//cookie禁止时继续使用session
			}else{
				request.setAttribute("msg", "用户名和密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);		
			}			
		}else if(action.equals("logout")){
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		out.close();
	}
}

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
		//session.setMaxInactiveInterval(10);//�趨session��ʱʱ��Ϊ10��
		System.out.println(session.getId());
		//�ж϶����Ƿ�Ϊ��¼
		if(action.equals("login")){
			String name = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String vcode = request.getParameter("vcode");
			if(name.equals("111") && pwd.equals("123456") && vcode.equalsIgnoreCase(yzm)){
				session.setAttribute("uname", name);
				response.sendRedirect("index.jsp");
				//response.sendRedirect(response.encodeRedirectURL("index.jsp"));//cookie��ֹʱ����ʹ��session
			}else{
				request.setAttribute("msg", "�û������������");
				request.getRequestDispatcher("login.jsp").forward(request, response);		
			}			
		}else if(action.equals("logout")){
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		out.close();
	}
}

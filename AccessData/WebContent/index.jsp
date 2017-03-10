<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//session验证,未登录不能进入index页面
	Object uname = session.getAttribute("uname");
	if(uname == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆成功页面</title>
</head>
<body>
	<h3>首页</h3>
	当前共有<%=application.getAttribute("count").toString() %>人在线<br>
	欢迎你：<%=uname.toString() %><br>
	
	<a href="logout.do">退出</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.s1{
		cursor:pointer;//鼠标变成手的形状
	}
</style>
</head>
<%
	String name = (String)request.getAttribute("msg");
 %>
<body>
	<%=name %>
	<form action="login.do" method="post">
		<fieldset style=" width:500px">
			<legend>用户登陆</legend>
			用户名：<input type="text" name="uname"/><br/><br/>
			密&nbsp;&nbsp;码：<input type="password" name="pwd"/><br/>
			验证码：<input type="text" name="vcode">
			<img src="code" onclick="this.src='code?'+Math.random();" class="s1" title="点击更换"><br>
			<input type="submit" value="登录"/>
		</fieldset>
	</form>
</body>
</html>
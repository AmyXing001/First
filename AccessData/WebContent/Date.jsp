<%@ page  import="java.util.Date,java.text.SimpleDateFormat" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>获取时间</title>
</head>
<body>
	<div style=" text-align:center;  margin:auto;width: 400px;height: 100px;border: 1px solid red;padding: 40px;">
	<%
		Date date = new Date();
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	当前系统时间：<%=SDF.format(date) %>
	</div>
</body>
</html>
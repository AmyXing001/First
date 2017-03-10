<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>评论</title>
</head>
<body>
	<form action="comment" method="post">
		<fieldset style="width: 400px;">
			<legend>评论区</legend>
			请输入评论：<textarea name="comments" style="vertical-align: middle;width: 140px;height:55px;"></textarea>
			<br>
			<input type="submit" value="发表评论" />
		</fieldset>
	</form>
</body>
</html>
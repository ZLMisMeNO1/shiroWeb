<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
${shiroLoginFailure }
<form action="" method="post">
	<input type="text" value="admin" name="username">
	<input type="text" value="123" name="password" >
	<input type="text" value="true" name="remember">
	<input type="submit" value="login" />
</form>

</body>
</html>
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
<title>index</title>
</head>
<body>
Welcome , ${username}
<form action="login">
	<button id="loginout">注销</button>
</form>


</body>
<script type="text/javascript" src="Plugins/jquery-1.10.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginout").click(function(){
			$.ajax({
				url: "login"
			});
		});
	})
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
 <%@include file="../common/BasePath.jsp" %>

 <link  href="Plugins/easyui/easyui.css" rel="stylesheet">
 <style type="text/css">
 html,body {
 	width:100%;height:100%;
 }
 </style>
<script type="text/javascript" src="http://apps.bdimg.com/libs/moment/2.8.3/moment-with-locales.min.js"></script>
<script type="text/javascript" src="js/permission/setting.js"></script>
</head>
<body>
<input type="hidden" value="${roleId }" id="currentRoleId"/>
	 <table id="roleList" ></table> 
</body>
</html>
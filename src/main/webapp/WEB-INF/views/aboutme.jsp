<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关于我</title>
 <%@include file="./common/BasePath.jsp" %>

 <link  href="Plugins/easyui/easyui.css" rel="stylesheet">
 <style type="text/css">
 html,body {
 	width:100%;height:100%;
 }
 </style>
<script type="text/javascript" src="js/aboutme.js"></script>
</head>
<body>
<hr />
<h5  align="center">我拥有的角色</h5>
<div style="height:300px;">
<table id="roleList" style="height:300px;"></table>
</div>

<hr />
<h5  align="center">我拥有的权限</h5>
<div style="height:300px">
<table id="permissionList" style="height:300px"></table>
</div>
</body>
</html>
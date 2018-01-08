<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
 <%@include file="../common/BasePath.jsp" %>
 <link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap-grid.css" rel="stylesheet">
 <link  href="Plugins/easyui/easyui.css" rel="stylesheet">
 <style type="text/css">
 html,body {
 	width:100%;height:100%;
 }
 </style>
<script type="text/javascript" src="js/role/setting.js"></script>
</head>
<body>
<!-- <div class="container" style="width:100%;height:700px;">
	<table id="roleList" style="width:100%;height:700px;"></table>
</div> -->
<shiro:hasAnyRoles name="administrator,roleadmin">
	<div class="col-md-2 column pull-left">
		 <button type="button" class="btn btn-block btn-default btn-info" id="createUser">创建新角色</button>
	</div>
</shiro:hasAnyRoles>
<div  style="width:100%;height:90%;">
	<table id="roleList" style="width:100%;height:100%;"></table>
</div>
</body>
</html>
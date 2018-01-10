<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
 <%@include file="../common/BasePath.jsp" %>

 <link  href="Plugins/easyui/easyui.css" rel="stylesheet">
 <style type="text/css">
 html,body {
 	width:100%;height:100%;
 }
 </style>
<script type="text/javascript" src="http://apps.bdimg.com/libs/moment/2.8.3/moment-with-locales.min.js"></script>
<script type="text/javascript" src="js/user/usermanage.js"></script>
</head>
<body>
<div class="col-md-12 column pull-left">
	 <button type="button" class="btn  btn-info btn-block " id="createUser">创建新用户</button>
</div>
	<table id="roleList" ></table>
</body>
</html>
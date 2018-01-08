<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />
<!-- 通用的css 引用 -->

<!-- font-awesome -->
<link rel="stylesheet" href="http://apps.bdimg.com/libs/fontawesome/4.4.0/css/font-awesome.min.css" />

<!-- jquery 引用 -->
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>


<!-- bootstrap 3.3.4 -->
<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
 <link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap-grid.css" rel="stylesheet">

<script type="text/javascript" src="Plugins/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="Plugins/easyui/js/easyui-lang-zh_CN.js"></script>

<!-- layer -->
<script type="text/javascript" src="http://apps.bdimg.com/libs/layer/2.1/layer.js"></script>

<!-- 通用js引用 -->
<script type="text/javascript" src="js/common/utils.js"></script>

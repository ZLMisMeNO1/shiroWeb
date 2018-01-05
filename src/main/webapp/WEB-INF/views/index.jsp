<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<%@include file="common/BasePath.jsp" %>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">首页</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<shiro:hasRole name="administrator">
							<li>
								 <a href="javascript:;" data-url="role/roleSetting" class="menu">角色管理</a>
							</li>
						</shiro:hasRole>
						<li>
							 <a href="#">Link</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><shiro:principal></shiro:principal><strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<shiro:hasRole name="administrator">
									 <a href="javascript:;" data-url="role/roleSetting" class="menu">角色管理</a>
									</shiro:hasRole>
								</li>
								<li>
									 <shiro:hasRole name="administrator">
									 <a href="javascript:;" data-url="user/permissionSetting" class="menu">菜单管理</a>
									</shiro:hasRole>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">关于我</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="./logout">注销</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
			<iframe id="main" src="" style="width:100%;height:800px;border:none"> </iframe>
		</div>
		<div class="col-md-12 column">
			<!-- <iframe id="main" src="" style="width:100%;height:800px;border:none"> </iframe> -->
		</div>
	</div>
</div>

</body>
</html>
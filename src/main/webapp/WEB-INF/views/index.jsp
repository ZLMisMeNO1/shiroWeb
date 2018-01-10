<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@include file="common/BasePath.jsp" %>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse" role="navigation">
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<c:forEach items="${menuList}" var="menu">
							<li>
								 <a href="javascript:;" data-url="${menu.permission}" class="menu">${menu.descMsg}</a>
							</li>
						</c:forEach>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><shiro:principal></shiro:principal><strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<%-- <li>
									<shiro:hasRole name="administrator">
									 <a href="javascript:;" data-url="role/roleSetting" class="menu">角色管理</a>
									</shiro:hasRole>
								</li>
								<li>
									 <shiro:hasRole name="administrator">
									 <a href="javascript:;" data-url="user/permissionSetting" class="menu">菜单管理</a>
									</shiro:hasRole>
								</li> --%>
								<!-- <li class="divider">
								</li> -->
								<li>
									 <a href="javascript:;" class="btn menu" data-url="user/about">关于我</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="javascript:;" class="btn logout" >退出</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
			<iframe id="main" src="welcome" style="width:100%;height:800px;border:none"> </iframe>
		</div>
		<div class="col-md-12 column">
			<!-- <iframe id="main" src="" style="width:100%;height:800px;border:none"> </iframe> -->
		</div>
	</div>
</div>

</body>
</html>
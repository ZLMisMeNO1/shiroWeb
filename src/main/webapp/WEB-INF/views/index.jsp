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
			<div class="tabbable">
				<ul class="nav ">
					<li class="active">
						 <a href="#main" >首页</a>
					</li>
					<shiro:hasRole name="administrator">
						<li>
							 <a href="javascript:;" data-url="role/roleSetting" class="menu">角色管理</a>
						</li>
					</shiro:hasRole>
					<li class="dropdown pull-right">
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
								<li>
									 <a href="#">关于我</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">Separated link</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="./logout">注销</a>
								</li>
							</ul>
						</li>
				</ul>
				<div class="tab-content">
					<div class="" >
						<iframe id="main" src="" style="width:100%;height:800px;border:none"> </iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>
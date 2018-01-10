<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
 <%@include file="./common/BasePath.jsp"%>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center text-success">
				shiro 用户后台管理系统
			</h3>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-6 column">
			<div class="jumbotron well">
				<h1>
					Hello, shiro!
				</h1>
				<p>
					这是shiro + springMVC + hibernate + redis 的一个小案例，具体可访问我的GitHub↓。	
				</p>
				<p>
					 <a class="btn btn-primary btn-large" href="https://github.com/ZLMisMeNO1/shiroWeb" target="_blank">点击访问ShiroWeb GitHub</a>
				</p>
			</div>
		</div>
		<div class="col-md-6 column">
			<form role="form" action="" method="post">
				<div class="form-group">
					 <label for="username">Username</label><input type="text" name="username" class="form-control" id="username" />
				</div>
				<div class="form-group">
					 <label for="password">Password</label><input type="password" class="form-control" name="password" id="password" />
				</div>
				<div class="checkbox">
					 <label><input type="checkbox" name="remember" />Remember Me</label>
				</div> 
				<div class="form-group">
					<label style="color:red;">${shiroLoginFailure }</label>
				</div>
				<button type="submit" class="btn btn-default">Sign In</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
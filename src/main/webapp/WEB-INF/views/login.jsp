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
${shiroLoginFailure }
<!-- <form action="" method="post">
	<input type="text" value="admin" name="username">
	<input type="text" value="123" name="password" >
	<input type="text" value="true" name="remember">
	<input type="submit" value="login" />
</form> -->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
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
				<button type="submit" class="btn btn-default">Sign In</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
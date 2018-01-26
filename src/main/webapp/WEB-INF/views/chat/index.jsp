<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>聊天室</title>
	<%@include file="../common/BasePath.jsp" %>
	<link  href="css/chat/barrager.css" rel="stylesheet">
	<script src="Plugins/jquery/jquery-1.10.1.js"></script>
	<script src="js/chat/jquery.barrager.js"></script>
	<script src="js/chat/chat.js"></script>
</head>
 <style type="text/css">
 html,body {
 	width:100%;height:100%;
 }
 </style>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-2 column">
					<div class="panel-group" id="panel-359014">
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title" data-toggle="collapse" data-parent="#panel-359014" href="#panel-element-393377">绝地求生</a>
							</div>
							<div id="panel-element-393377" class="panel-collapse collapse">
								<div class="panel-body">
									开挂狗
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-359014" href="#panel-element-215898">英雄联盟</a>
							</div>
							<div id="panel-element-215898" class="panel-collapse collapse">
								<div class="panel-body">
									挂机狗
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-9 column">
					<div class="text-center" id="mainA" style="border:1px solid black;height:650px;">
						假装此处有视频
					</div>
					<input type="text" class="form-control input-lg" placeholder="输入你要吐槽的内容..."  id="text">
					<button class="btn btn-lg btn-info" id="btn">发送</button>
					<div id="message" class="hidden"></div>
				</div>
			</div>
		</div>
	</div>
</div>
	
	
</body>

</html>
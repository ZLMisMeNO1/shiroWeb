
$(function(){
		$("#createBtn").click(function(){
			var username = $("#username").val();
			var password = $("#password").val();
			executeAjax("usermanage/create",{
				data : {
					'username' : username,
					'password' : password
				}
			},function(data){
				console.log(data);
				if(data.success ) {
					parent.layer.closeAll();
				}
			})
		}) ;
})

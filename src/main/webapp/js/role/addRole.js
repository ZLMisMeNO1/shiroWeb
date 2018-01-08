
$(function(){
		$("#createBtn").click(function(){
			var roleName = $("#roleName").val();
			var msg = $("#msg").val();
			executeAjax("role/create",{
				data : {
					'roleName' : roleName,
					'desc' : msg
				}
			},function(data){
				console.log(data);
				if(data.success ) {
					parent.layer.closeAll();
				}
			},function(e){
				layer.alert(e.responseJSON.message, {icon: 2,title:'错误'});
			})
		}) ;
})

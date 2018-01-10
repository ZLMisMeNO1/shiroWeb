	$(function(){
		$('ul li a.menu').on('click',function(){
			var url = $(this).data('url');
			$("#main").attr("src",url);
			/* document.getElementById("main").src = url; */
			$(this).addClass('active').siblings().removeClass('active');
		})
		$('ul li a.logout').on('click',function(){
			
			layer.confirm('退出系统?', {icon: 3, title:'提示'}, function(index){
				executeAjax("logout",{},function(result){
					window.location.href = '';
				});
			  layer.close(index);
			});
			
			
		})
	})
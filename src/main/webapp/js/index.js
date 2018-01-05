	$(function(){
		$('ul li a.menu').on('click',function(){
			var url = $(this).data('url');
			console.log(url)
			$("#main").attr("src",url);
			/* document.getElementById("main").src = url; */
			$(this).addClass('active').siblings().removeClass('active');
		})
	})
$(function(){
	var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://10.10.28.193:8080/shiroWeb/chat/test");
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        var item={
// 			   img:'', //图片 
 			   info:event.data, //文字 
 			   href:'javascript:;', //链接 
 			   close:false, //显示关闭按钮 
 			   speed:6, //延迟,单位秒,默认6 
 			   bottom:70, //距离底部高度,单位px,默认随机 
 			   color:'#fff', //颜色,默认白色 
 			   old_ie_color:'#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
 			 }
 			$('#mainA').barrager(item);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    $('#btn').click(function(){
    	send() ;
    });
    function send() {
    	var $msg = $('#text');
        var message = $msg.val();
        websocket.send(message);
        $msg.val("");
    }
    document.onkeydown = function(e){ 
        var ev = document.all ? window.event : e;
        if(ev.keyCode==13) {
        	send() ;

         }
    }
});

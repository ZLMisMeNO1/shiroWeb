//jquery.danmu.js (//github.com/chiruom/danmu/) - Licensed under the MIT license
var websocket;
$(function(){
	var con = $("body")
	var curWwwPath = window.document.location.href;
	if ( curWwwPath.includes('http') ) {
		curWwwPath = curWwwPath.replace('http','ws')
	}
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket(curWwwPath);
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
    	heartCheck.start();
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
    	heartCheck.reset();
        var msg = '<div class="list-group-item" >' + event.data +'</div>';
        if(event.data == 'fsdafadsfdsa') {
        	return ;
        }
        $('#danmuArea').barrage({msg:event.data})
//        $('#danmuArea').append(msg); 
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
var heartCheck = {
	    timeout: 60000,//60ms
	    timeoutObj: null,
	    reset: function(){
	        clearTimeout(this.timeoutObj);
	        this.start();
	    },
	    start: function(){
	        this.timeoutObj = setTimeout(function(){
	        	websocket.send("fsdafadsfdsa");
	        }, this.timeout)
	    }
	}

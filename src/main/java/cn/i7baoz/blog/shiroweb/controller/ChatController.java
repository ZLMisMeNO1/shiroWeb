/** 
 * Project Name:shiroWeb 
 * File Name:ChatController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2018年1月26日上午9:59:07 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.controller;  

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.i7baoz.blog.shiroweb.annotation.UrlPermissionComponent;
import cn.i7baoz.blog.shiroweb.socket.server.SocketServer;

/** 
 * ClassName:ChatController 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月26日 上午9:59:07 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
@RequestMapping("chat")
public class ChatController {

	@UrlPermissionComponent(url="chat/chatIndex",desc="弹幕",isView=true,isMenu=true)
	@RequestMapping("/{topic}")
	public String chatIndex(@PathVariable String topic) {
		return "chat/index";
	}
	
}
 
/** 
 * Project Name:shiroWeb 
 * File Name:SocketServer.java 
 * Package Name:cn.i7baoz.blog.shiroweb.socket.server 
 * Date:2018年1月26日上午10:13:55 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.socket.server;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.context.ContextLoader;

import cn.i7baoz.blog.shiroweb.dto.UserWebsocketDto;


/** 
 * ClassName:SocketServer 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月26日 上午10:13:55 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class SocketServer {
	
//	@Autowired
	@SuppressWarnings("unchecked")
	private static KafkaTemplate<String, String> kafkaTemplate =
		(KafkaTemplate<String, String>) ContextLoader.getCurrentWebApplicationContext().getBean("kafkaTemplate");
	
	private static List<UserWebsocketDto> dtoList = new ArrayList<UserWebsocketDto>();
	
	public static void addSocket (UserWebsocketDto dto) {
		System.out.println(dto);
		if ( dtoList.contains(dto) ) {
			dtoList.remove(dto);
		}
		dtoList.add(dto);
		System.out.println(dtoList.size());
	}
	
	public static void addMessage(String channel,String message) {
		kafkaTemplate.send(channel, message);
	}
	
	//send message to all user
	//群发
	public static void sendMessageToAllUser(String message) {
		//群发消息
        for(UserWebsocketDto dto : dtoList){
        	dto.getClent().sendMessage(message);
        }
	}
}
 
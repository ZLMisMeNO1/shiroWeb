/** 
 * Project Name:shiroWeb 
 * File Name:SocketServer.java 
 * Package Name:cn.i7baoz.blog.shiroweb.socket.server 
 * Date:2018年1月26日上午10:13:55 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.socket.server;  

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.context.ContextLoader;


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
	
	private static Map<Object,Session> userSessionMap = new HashMap<Object,Session>(200);

	public static void addMessage(String channel,String message) {
		kafkaTemplate.send(channel, message);
	}
	public static Map<Object,Session> getWebSocketSet() {
		return userSessionMap;
	}

	public static void addWebSession(Object user,Session session) {
		userSessionMap.put(user,session);
	}
	
	public static void removeSession(Object user) {
		userSessionMap.remove(user);
	}
	
	//send message to all user
	//群发
	public static void sendMessageToAllUser(String message) {
		//群发消息
        for(Session session: userSessionMap.values()){
            try {
            	session.getBasicRemote().sendText(message);;
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
	}
}
 
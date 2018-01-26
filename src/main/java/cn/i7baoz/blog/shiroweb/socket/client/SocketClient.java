/** 
 * Project Name:shiroWeb 
 * File Name:SocketClient.java 
 * Package Name:cn.i7baoz.blog.shiroweb.socket.client 
 * Date:2018年1月26日上午10:14:19 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.socket.client;  

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import cn.i7baoz.blog.shiroweb.socket.server.SocketServer;

/** 
 * ClassName:SocketClient 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月26日 上午10:14:19 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@ServerEndpoint("/chat/{channel}")
public class SocketClient {


	/**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @throws IOException 
     */
    @OnOpen
    public void onOpen(Session session,
    		@PathParam(value = "channel") String channel) throws IOException{
    	Object user = SecurityUtils.getSubject().getPrincipal();
        SocketServer.addWebSession(user, session);
        System.out.println("channel:" + channel);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
    	Object user = SecurityUtils.getSubject().getPrincipal();
    	SocketServer.removeSession(user);
    }
    
   
    
    /**
     * 客户端主动向服务端发送消息
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(
    		@PathParam(value = "channel") String channel,String message, Session session) {
    	System.out.println("channel:" + channel);
    	//收到消息后，有两种处理方式，
    	//1.可以执行下面代码，直接将消息群发
    	SocketServer.addMessage(channel,message);
        
        //2.将用户的消息添加至消息队列（kafka）
        
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }

}
 
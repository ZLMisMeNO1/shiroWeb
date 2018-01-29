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

import cn.i7baoz.blog.shiroweb.dto.UserWebsocketDto;
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
public class SocketClient{

	private Session session;

	/**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @throws IOException 
     */
    @OnOpen
    public void onOpen(Session session,
    		@PathParam(value = "channel") String channel) throws IOException{
    	this.session = session;
    	UserWebsocketDto dto = new UserWebsocketDto();
    	dto.setClent(this);
    	dto.setTopic(channel);
    	dto.setUser(session.getUserPrincipal().getName());
    	SocketServer.addSocket(dto);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
//    	Object user = SecurityUtils.getSubject().getPrincipal();
//    	SocketServer.removeSession(user);
    }
    
   
    
    /**
     * 客户端主动向服务端发送消息
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void reveiveMessage(
    		@PathParam(value = "channel") String channel,String message, Session session) {
    	if ( null == message || message.isEmpty() ) {
    		return ;
    	}
//    	System.out.println("channel:" + channel);
    	//收到消息后，有两种处理方式，
    	//1.可以执行下面代码，直接将消息群发
    	
//    	for(Session s: session.getOpenSessions()){
//          try {
////          	session.getBasicRemote().sendText(message);
//        	  RemoteEndpoint.Async a = session.getAsyncRemote();
//        	  System.out.println(a.getSendTimeout());
//        	  a.sendText(message);
//          } catch (Exception e) {
//              e.printStackTrace();
//              continue;
//          }
//      }
        //2.将用户的消息添加至消息队列（kafka）
    	SocketServer.addMessage(channel,message);
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
    
    public void sendMessage(String message)  {  
        this.session.getAsyncRemote().sendText(message);  
    }


}
 
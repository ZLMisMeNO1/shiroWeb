/** 
 * Project Name:shiroWeb 
 * File Name:ConsumerListener.java 
 * Package Name:cn.i7baoz.blog.shiroweb.kafka.consumer 
 * Date:2018年1月26日下午3:56:39 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.kafka.consumer;  

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import cn.i7baoz.blog.shiroweb.socket.server.SocketServer;

/** 
 * ClassName:ConsumerListener 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月26日 下午3:56:39 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public final class ConsumerListener implements MessageListener<String,String>{

	@Override
    public void onMessage(ConsumerRecord<String, String> data) {
       System.out.println("消息： " + data);
       SocketServer.sendMessageToAllUser(data.value());
    }
}
 
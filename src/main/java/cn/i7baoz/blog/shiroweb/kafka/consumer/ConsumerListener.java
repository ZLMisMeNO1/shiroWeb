/** 
 * Project Name:shiroWeb 
 * File Name:ConsumerListener.java 
 * Package Name:cn.i7baoz.blog.shiroweb.kafka.consumer 
 * Date:2018年1月26日下午3:56:39 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.kafka.consumer;  

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import cn.i7baoz.blog.shiroweb.pojo.UserOptionLogBean;
import cn.i7baoz.blog.shiroweb.service.LogService;


/** 
 * ClassName:ConsumerListener 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月26日 下午3:56:39 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public final class ConsumerListener implements MessageListener<String,UserOptionLogBean>{

	@Autowired
	LogService logService;
	
	@Override
    public void onMessage(ConsumerRecord<String, UserOptionLogBean> data) {
       System.out.println("消息： " + data);
       System.out.println( data.value());
       logService.save(data.value());
    }
}
 
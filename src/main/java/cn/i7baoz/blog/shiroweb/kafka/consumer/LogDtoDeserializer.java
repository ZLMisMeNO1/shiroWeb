/** 
 * Project Name:shiroWeb 
 * File Name:LogDtoDeserializer.java 
 * Package Name:cn.i7baoz.blog.shiroweb.kafka.consumer 
 * Date:2018年2月1日上午11:11:21 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.kafka.consumer;  

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import cn.i7baoz.blog.shiroweb.pojo.UserOptionLogBean;
import cn.i7baoz.blog.shiroweb.util.BeanUtil;

/** 
 * ClassName:LogDtoDeserializer 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月1日 上午11:11:21 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class LogDtoDeserializer implements Deserializer<UserOptionLogBean>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public UserOptionLogBean deserialize(String topic, byte[] data) {
		
		return (UserOptionLogBean) BeanUtil.Bytes2Object(data);
	}

	@Override
	public void close() {
	}

}
 
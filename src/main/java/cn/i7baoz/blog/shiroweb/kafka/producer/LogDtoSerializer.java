/** 
 * Project Name:shiroWeb 
 * File Name:LogDtoSerializer.java 
 * Package Name:cn.i7baoz.blog.shiroweb.kafka.producer 
 * Date:2018年2月1日上午9:59:41 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.kafka.producer;  

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import cn.i7baoz.blog.shiroweb.pojo.UserOptionLogBean;
import cn.i7baoz.blog.shiroweb.util.BeanUtil;

/** 
 * ClassName:LogDtoSerializer 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月1日 上午9:59:41 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class LogDtoSerializer implements Serializer<UserOptionLogBean>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, UserOptionLogBean data) {
		return BeanUtil.Object2Bytes(data);
	}

	@Override
	public void close() {
	}


}
 
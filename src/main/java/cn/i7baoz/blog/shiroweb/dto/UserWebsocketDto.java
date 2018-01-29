/** 
 * Project Name:shiroWeb 
 * File Name:UserWebsocketDto.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dto 
 * Date:2018年1月29日下午1:01:07 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dto;  

import cn.i7baoz.blog.shiroweb.socket.client.SocketClient;

/** 
 * ClassName:UserWebsocketDto 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月29日 下午1:01:07 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class UserWebsocketDto {

	private String user;
	
	private String topic;
	
	private SocketClient clent;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public SocketClient getClent() {
		return clent;
	}

	public void setClent(SocketClient clent) {
		this.clent = clent;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserWebsocketDto other = (UserWebsocketDto) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserWebsocketDto [user=" + user + ", topic=" + topic
				+ ", clent=" + clent + "]";
	}
	
	
}
 
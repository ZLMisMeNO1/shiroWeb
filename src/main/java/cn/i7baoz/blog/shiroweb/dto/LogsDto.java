/** 
 * Project Name:shiroWeb 
 * File Name:LogsDto.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dto 
 * Date:2018年1月31日下午4:56:19 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dto;  

import java.sql.Timestamp;

import com.alibaba.fastjson.JSONObject;

import cn.i7baoz.blog.shiroweb.enums.LogTopicEnum;
import cn.i7baoz.blog.shiroweb.enums.OptionEnmu;

/** 
 * ClassName:LogsDto 日志传输
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月31日 下午4:56:19 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class LogsDto {

	//谁
	private String currentUser;
	
	//对谁进行了操作 ？  用户、角色...
	private LogTopicEnum toGoal;
	
	//进行了什么操作
	private OptionEnmu option;
	
	//什么时间
	private Timestamp currentTime = new Timestamp(System.currentTimeMillis());

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public LogTopicEnum getToGoal() {
		return toGoal;
	}

	public void setToGoal(LogTopicEnum toGoal) {
		this.toGoal = toGoal;
	}

	public OptionEnmu getOption() {
		return option;
	}

	public void setOption(OptionEnmu option) {
		this.option = option;
	}

	public Timestamp getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Timestamp currentTime) {
		this.currentTime = currentTime;
	}
	
	private LogsDto(String currentUser, LogTopicEnum toGoal, OptionEnmu option) {
		super();
		this.currentUser = currentUser;
		this.toGoal = toGoal;
		this.option = option;
	}


}
 
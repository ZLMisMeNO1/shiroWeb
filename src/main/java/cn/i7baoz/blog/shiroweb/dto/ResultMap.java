/** 
 * Project Name:shiroWeb 
 * File Name:ResponseResult.java 
 * Package Name:cn.i7baoz.blog.shiroweb.util 
 * Date:2018年1月4日上午11:49:06 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dto;  

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;

import cn.i7baoz.blog.shiroweb.enums.CurrentStatusEnum;
import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;

/** 
 * ClassName:ResponseResult 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月4日 上午11:49:06 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class ResultMap<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	
	private String message;
	
	private Boolean success;

	private T data;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ResultMap() {
		
	}
	public ResultMap(CurrentStatusEnum currentStatus) {
		this.status = currentStatus.getStatusCode();
		this.message = currentStatus.getMessage();
		this.success = false;
	}
	public ResultMap(SystemMessageEnum systemMessages) {
		this.status = 500;
		this.message = systemMessages.getMessage();
		this.success = false;
	}
	public ResultMap(AuthenticationException error) {
		this.status = 500;
		this.message = error.getMessage();
		this.success = false;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
}
 
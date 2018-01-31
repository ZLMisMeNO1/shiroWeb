/** 
 * Project Name:shiroWeb 
 * File Name:CurrentStatus.java 
 * Package Name:cn.i7baoz.blog.shiroweb.status 
 * Date:2017年12月28日上午9:30:28 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.enums;  
/** 
 * ClassName:CurrentStatus 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午9:30:28 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public enum CurrentStatusEnum {

	NORMAL(0,"正常"),
	
	LOCKED(-1,"锁定"),
	
	DELETED(-2,"已删除");
	
	private Integer statusCode;
	
	private String message;
	
	CurrentStatusEnum (Integer statusCode,String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
 
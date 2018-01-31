/** 
 * Project Name:shiroWeb 
 * File Name:OptionEnmu.java 
 * Package Name:cn.i7baoz.blog.shiroweb.enums 
 * Date:2018年1月31日下午4:45:04 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.enums;  
/** 
 * ClassName:OptionEnmu 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月31日 下午4:45:04 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public enum OptionEnmu {
	LOGIN("登录系统"),
	CREATE("添加"),
	UPDATE("修改"),
	DELETE("删除");
	
	private String message;

	OptionEnmu(String message) {
		
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
 
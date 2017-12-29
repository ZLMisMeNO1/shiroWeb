/** 
 * Project Name:shiroWeb 
 * File Name:SameUsernameException.java 
 * Package Name:cn.i7baoz.blog.shiroweb 
 * Date:2017年12月28日下午2:39:33 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.exception;  
/** 
 * ClassName:SameUsernameException 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 下午2:39:33 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class TraditionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message ;
	
	public TraditionException () {
		this.message = "出错了~！";
	}

	public TraditionException(String msg) {
		this.message = msg;
	}
	@Override
	public String getMessage() {
		
		return this.message;
	}
	
	
}
 
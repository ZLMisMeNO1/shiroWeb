/** 
 * Project Name:shiroWeb 
 * File Name:UserException.java 
 * Package Name:cn.i7baoz.blog.shiroweb.exception 
 * Date:2018年1月3日上午10:12:49 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.exception;  

import org.apache.shiro.ShiroException;

import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;

/** 
 * ClassName:UserException 用户方面的异常
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月3日 上午10:12:49 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class TraditionException extends ShiroException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SystemMessageEnum systemMessages;
	
	public TraditionException() {
		super();
		this.systemMessages = SystemMessageEnum.UNKOWN_ERROR;
	}
	public TraditionException(SystemMessageEnum systemMessages) {
		super();
		this.systemMessages = systemMessages;
	}
	

    /**
     * Constructs a new AuthenticationException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public TraditionException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new AuthenticationException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public TraditionException(String message, Throwable cause) {
        super(message, cause);
    }
	
	@Override
	public String getMessage() {
		return this.systemMessages.getMessage();
	}
	
	public SystemMessageEnum getSystemMessages() {
		return systemMessages;
	}
}
 
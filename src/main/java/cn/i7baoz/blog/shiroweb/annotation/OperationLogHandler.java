/** 
 * Project Name:shiroWeb 
 * File Name:UserRealmExceptionHandler.java 
 * Package Name:cn.i7baoz.blog.shiroweb.exceptionHandler 
 * Date:2018年1月4日上午9:16:25 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.annotation;  


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.i7baoz.blog.shiroweb.annotation.OperationLog;


/** 
 * ClassName:UserRealmExceptionHandler 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月4日 上午9:16:25 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Component
@Aspect
public class OperationLogHandler {

	private static final Logger log = Logger.getLogger(OperationLogHandler.class);
	
	@After(value="@annotation(login)")
	public void afterThrowing(JoinPoint jp, OperationLog login) {
		log.info(login.userId());
		System.out.println(login.userId());
		log.info(jp.getTarget());
	}
}
 
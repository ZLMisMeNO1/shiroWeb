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
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	
	@Before(value="@annotation(login)")
	public void afterThrowing(JoinPoint jp, OperationLog login) {
		//这里可以做一些 url访问次数统计
		log.info(login.loginTime());
	}
}
 
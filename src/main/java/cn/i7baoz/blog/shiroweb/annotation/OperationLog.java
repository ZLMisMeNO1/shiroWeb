/** 
 * Project Name:shiroWeb 
 * File Name:ExceptionHandler.java 
 * Package Name:cn.i7baoz.blog.shiroweb.annotation 
 * Date:2018年1月4日上午10:22:54 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.annotation;  

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/** 
 * ClassName:ExceptionHandler 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月4日 上午10:22:54 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
@Documented
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface OperationLog {

	String userId() default "";
	
	long loginTime() default 0;
	
}
 
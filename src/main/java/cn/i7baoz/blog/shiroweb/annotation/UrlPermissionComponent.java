/** 
 * Project Name:shiroWeb 
 * File Name:UrlPermissionComent.java 
 * Package Name:cn.i7baoz.blog.shiroweb.annotation 
 * Date:2018年1月9日上午9:23:51 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.annotation;  

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/** 
 * ClassName:UrlPermissionComent 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月9日 上午9:23:51 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface UrlPermissionComponent {

	//跟随spring的脚步，每个注解都有value值
	String value()  default "";
	
	//访问的全URL
	String url();
	
	//描述
	String desc();
	
	//是否为视图
	boolean isView();
	
	//是否为菜单
	boolean isMenu() default false;
	
	int sortNumber() default 0;
	
	String belong() default "/";
	
	
}
 
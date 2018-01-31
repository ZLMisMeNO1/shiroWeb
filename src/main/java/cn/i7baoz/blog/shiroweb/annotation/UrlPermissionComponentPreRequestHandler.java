/** 
 * Project Name:shiroWeb 
 * File Name:UrlPermissionComponentPreRequestHandler.java 
 * Package Name:cn.i7baoz.blog.shiroweb.annotation 
 * Date:2018年1月9日下午1:53:35 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.annotation;  

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;

/** 
 * ClassName:UrlPermissionComponentPreRequestHandler 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月9日 下午1:53:35 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Component
@Aspect
public class UrlPermissionComponentPreRequestHandler {

	private static final Logger log = Logger.getLogger(UrlPermissionComponentPreRequestHandler.class);
	
	//在用户访问之前，判断用户是否具有url访问的权限
	@Before(value="@annotation(urlPermissionComponent)")
	public void beforeConnection(JoinPoint jp, UrlPermissionComponent urlPermissionComponent) {
		//获取当前用户
		Subject currentUser = SecurityUtils.getSubject();
		//获取当前访问的url
		String url = urlPermissionComponent.url();
		
		String desc = urlPermissionComponent.desc();
		//判断用户是否具有访问该url的权限
		if ( !currentUser.isPermitted(url )) {
			//没有权限抛出异常并打印只控制台 ，后期可以做一个日志记录
			log.info("user["+currentUser.getPrincipal()+"] try to connect [" +url+ "] at [" +System.currentTimeMillis()+ "]");
			throw new AuthenticationException("["+desc+"]"+SystemMessageEnum.USER_HAS_NO_PERMISSION.getMessage());
		} 
	}
}
 
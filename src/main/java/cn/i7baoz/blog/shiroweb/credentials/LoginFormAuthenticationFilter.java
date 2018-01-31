/** 
 * Project Name:shiroWeb 
 * File Name:LoginFormAuthenticationFilter.java 
 * Package Name:cn.i7baoz.blog.shiroweb.credentials 
 * Date:2018年1月3日下午5:25:35 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.credentials;  

import javax.servlet.ServletRequest;

import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;

import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;

/** 
 * ClassName:LoginFormAuthenticationFilter 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月3日 下午5:25:35 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException ae) {
//		检测到异常后，将异常信息发送到request中 使用 ${shiroLoginFailure}接收
		if ( ae instanceof IncorrectCredentialsException ) {
			//密码不正确
			request.setAttribute(getFailureKeyAttribute(), SystemMessageEnum.USERNAME_OR_PASSWORD_IS_WRONG.getMessage());
		} else {
			//检测到其他异常
			request.setAttribute(getFailureKeyAttribute(), ae.getMessage());
		}
	}
}
 
/** 
 * Project Name:shiroWeb 
 * File Name:LoginController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2017年12月29日下午2:43:16 
 * 
 */

package cn.i7baoz.blog.shiroweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.i7baoz.blog.shiroweb.annotation.OperationLog;

/**
 * ClassName:LoginController Function: TODO ADD FUNCTION. Date: 2017年12月29日
 * 下午2:43:16
 * 
 * @author baoqi.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
@Controller
public class LoginController {

	// 登录页面
	private static String LOGIN_PAGE = "login";
	//注销页面
	private static String LOGOUT_PAGE = "login";

	// 无权限页面
	private static String UNAUTHORIZED_PAGE = "unauthorized";

	// 主页面
	private static String INDEX_PAGE = "index";
	/**
	 * 
	 * login:用户登录，任何权限
	 * 
	 * @author baoqi.zhang
	 * @param username
	 * @param password
	 * @return
	 * @since JDK 1.7
	 */
	@OperationLog
	@RequestMapping("login")
	public String login(HttpServletRequest request) throws AuthenticationException {
		return LOGIN_PAGE;
	}

	@RequestMapping("logout")
	public String loginout() throws AuthenticationException  {
		// 注销用户
		SecurityUtils.getSubject().logout();
		// 转到注销页面
		return LOGOUT_PAGE;
	}

	@RequestMapping("unauthorized")
	public String unauthorized() throws AuthenticationException  {
		// 注销用户
		SecurityUtils.getSubject().getSession().stop();
		// 转到登录页面
		return UNAUTHORIZED_PAGE;
	}
	
	@RequestMapping("index") 
	public String index()  throws AuthenticationException {
		Subject  currentUser = SecurityUtils.getSubject();
		currentUser.getSession().setAttribute("username", currentUser.getPrincipal());
		return INDEX_PAGE;
	}
}

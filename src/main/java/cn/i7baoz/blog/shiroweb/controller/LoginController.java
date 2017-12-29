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
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("login")
	// @ResponseBody
	public String login(HttpServletRequest request) throws Exception {
//		SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
//		
//		//上一个请求页面
//		String successUrl = LOGIN_PAGE;
//		
//		if (savedRequest != null
//				&& savedRequest.getMethod().equalsIgnoreCase(
//						AccessControlFilter.GET_METHOD)) {
//			successUrl = savedRequest.getRequestUrl();
//		}
//		System.out.println(successUrl);
//		//如果当前用户登录成功
//		if ( SecurityUtils.getSubject().isAuthenticated() ) {
//			if ( LOGIN_APGE.equals(successUrl) ) {
//				System.out.println("tiaozhuan");
//				//如果上一个页面是登录页面，也就是注销后再登录的情况
//				return INDEX_PAGE;
//			} 
//		}
		
//		System.out.println(successUrl);
		return LOGIN_PAGE;
	}

	@RequestMapping("logout")
	public String loginout() {
		// 注销用户
//		SecurityUtils.getSubject().getSession().stop();
		// 转到注销页面
		return LOGOUT_PAGE;
	}

	@RequestMapping("unauthorized")
	public String unauthorized() {
		// 注销用户
		SecurityUtils.getSubject().getSession().stop();
		// 转到登录页面
		System.out.println(UNAUTHORIZED_PAGE);
		return UNAUTHORIZED_PAGE;
	}
	
	@RequestMapping("index") 
	public String index() {
		Subject  currentUser = SecurityUtils.getSubject();
		currentUser.getSession().setAttribute("username", currentUser.getPrincipal());
		return INDEX_PAGE;
	}
}

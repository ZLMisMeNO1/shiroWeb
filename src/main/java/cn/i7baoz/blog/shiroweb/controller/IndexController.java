/** 
 * Project Name:shiroWeb 
 * File Name:IndexController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2018年1月10日上午10:47:14 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.controller;  

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.i7baoz.blog.shiroweb.annotation.UrlPermissionComponent;
import cn.i7baoz.blog.shiroweb.service.PermissionService;

/** 
 * ClassName:IndexController 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月10日 上午10:47:14 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
public class IndexController extends BaseController{

	@Autowired
	PermissionService permissionService;
	
	//主页
	@RequestMapping("/index") 
	public ModelAndView index()  throws AuthenticationException {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("username",SecurityUtils.getSubject().getPrincipal());
		modelAndView.addObject("menuList",permissionService.listMenu());
		return modelAndView;
	}
	
	@UrlPermissionComponent(url="welcome",desc="欢迎页",isView=true,isMenu=true,sortNumber=0)
	@RequestMapping("/welcome") 
	public ModelAndView welcome()  throws AuthenticationException {
		ModelAndView modelAndView = new ModelAndView("welcome");
		return modelAndView;
	}
}
 
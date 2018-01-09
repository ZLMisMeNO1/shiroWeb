/** 
 * Project Name:shiroWeb 
 * File Name:UserController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2017年12月28日下午2:25:15 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.controller;  

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.i7baoz.blog.shiroweb.annotation.UrlPermissionComponent;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.service.UserService;
import cn.i7baoz.blog.shiroweb.util.SystemMessages;

/** 
 * ClassName:UserController 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 下午2:25:15 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * listAllUsers:显示所有用户，必须拥有管理员权限
	 * 
	 * @author baoqi.zhang 
	 * @return 
	 * @since JDK 1.7
	 */
	@UrlPermissionComponent(url="user/listUser",desc="查看所有用户",isView=false)
	@RequestMapping("listUser")
	@ResponseBody
	public List<UserBean> listAllUsers() throws AuthenticationException{
		return userService.listAllUsers();
	}
	
	@RequestMapping("create")
	@ResponseBody
	@UrlPermissionComponent(url="user/create",desc="创建用户",isView=false)
	public UserBean createUser (String username,String password) throws AuthenticationException{
		
		if ( username.trim().isEmpty() || password.trim().isEmpty() ) {
			throw new AuthenticationException(SystemMessages.USERNAM_OR_PASSWORD_IS_NULL.getMessage());
		}
		return userService.createUser(username,password);
	}
	//管理员可以查看任何人的权限
	@RequestMapping("findPermissionsByUsername")
	@ResponseBody
	@UrlPermissionComponent(url="user/findPermissionsByUsername",desc="查看用户权限",isView=false)
	public List<PermissionBean> findPermissionsByUsername(String username) throws AuthenticationException{
		Subject subject = SecurityUtils.getSubject();
		if ( subject.hasRole("administrator") ) {
			if( null == username || username.isEmpty() ) {
				username = (String) SecurityUtils.getSubject().getPrincipal();
			}
			return userService.findPermissionsByUsername(username);
		}
		username = (String) SecurityUtils.getSubject().getPrincipal();
		return userService.findPermissionsByUsername(username);
	}
	
	@RequestMapping("aboutme")
	@UrlPermissionComponent(url="user/aboutme",desc="关于我",isView=false)
	public String aboutme() {
		return "aboutme";
	}
	
}
 
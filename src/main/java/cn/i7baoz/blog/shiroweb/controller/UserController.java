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

import cn.i7baoz.blog.shiroweb.dto.ResultMap;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.service.UserService;

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
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	
	
	//查看我的权限
	@RequestMapping("listMyPermissions")
	@ResponseBody
	public ResultMap<List<PermissionBean>> listMyPermissions() throws AuthenticationException{
		ResultMap<List<PermissionBean>> resultMap = new  ResultMap<List<PermissionBean>>();
		Subject subject = SecurityUtils.getSubject();
		String username = (String)subject.getPrincipal();
		resultMap.setData(userService.findPermissionsByUsername(username));
		resultMap.setSuccess(true);
		return resultMap;
	}
	
	//查看我的角色
	@RequestMapping("listMyRoles")
	@ResponseBody
	public  ResultMap<List<RoleBean>>  listMyRoles() throws AuthenticationException{
		Subject subject = SecurityUtils.getSubject();
		String username = (String)subject.getPrincipal();
		ResultMap<List<RoleBean>> resultMap = new  ResultMap<List<RoleBean>>();
		resultMap.setData(userService.findRoleByUsername(username));
		resultMap.setSuccess(true);
		return resultMap;
	}
	@RequestMapping("about")
	public String aboutme() {
		return "aboutme";
	}
	
}
 
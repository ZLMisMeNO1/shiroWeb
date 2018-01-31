/** 
 * Project Name:shiroWeb 
 * File Name:UserManageController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2018年1月10日上午9:00:26 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.controller;  

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.i7baoz.blog.shiroweb.annotation.UrlPermissionComponent;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.service.RoleService;
import cn.i7baoz.blog.shiroweb.service.UserService;
import cn.i7baoz.blog.shiroweb.dto.ResultMap;
import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;

/** 
 * ClassName:UserManageController 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月10日 上午9:00:26 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
@RequestMapping("usermanage")
public class UserManageController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("main")
	@UrlPermissionComponent(desc = "用户管理", isView = true, url = "usermanage/main",isMenu=true,sortNumber=2)
	public ModelAndView usermanage(){
		ModelAndView m = new ModelAndView("user/usermanage");
		return m;
	}
	@RequestMapping("addUser")
	@UrlPermissionComponent(desc = "创建新用户页面", isView = true, url = "usermanage/addUser",belong="usermanage/main")
	public ModelAndView addUser(){
		ModelAndView m = new ModelAndView("user/addUser");
		return m;
	}
	@RequestMapping("userRoleSetting")
	@UrlPermissionComponent(desc = "用户角色管理", isView = true, url = "usermanage/userRoleSetting",belong="usermanage/main")
	public ModelAndView userRoleSetting(String userId){
		ModelAndView m = new ModelAndView("user/userRoleSetting");
		m.addObject("userId",userId);
		return m;
	}
	/**
	 * 
	 * listAllUsers:显示所有用户，必须拥有管理员权限
	 * 
	 * @author baoqi.zhang 
	 * @return 
	 * @since JDK 1.7
	 */
	@UrlPermissionComponent(url="usermanage/listUser",desc="查看所有用户",isView=false,belong="usermanage/main")
	@RequestMapping("listUser")
	@ResponseBody
	public ResultMap<List<UserBean>> listAllUsers() throws AuthenticationException{
		ResultMap<List<UserBean>> resultMap = new ResultMap<List<UserBean>>();
		resultMap.setData(userService.listAllUsers());
		resultMap.setSuccess(true);
		return resultMap;
	}
	@Autowired
	private RoleService roleService;
	
	@UrlPermissionComponent(url="usermanage/listAllRoles",desc="查看所有角色信息",isView=false,belong="usermanage/main")
	@RequestMapping("listAllRoles")
	@ResponseBody
	public ResultMap<List<RoleBean>> listAllRoles() {
		ResultMap<List<RoleBean>> resultMap = new ResultMap<List<RoleBean>>();
		resultMap.setData(roleService.listAllRoles());
		resultMap.setSuccess(true);
		return resultMap;
	}
	
	@RequestMapping("create")
	@ResponseBody
	@UrlPermissionComponent(url="usermanage/create",desc="创建用户",isView=false,belong="usermanage/main")
	public ResultMap<UserBean> createUser (String username,String password) throws AuthenticationException{
		
		if ( username.trim().isEmpty() || password.trim().isEmpty() ) {
			throw new AuthenticationException(SystemMessageEnum.USERNAM_OR_PASSWORD_IS_NULL.getMessage());
		}
		ResultMap<UserBean> resultMap = new ResultMap<UserBean>();
		resultMap.setSuccess(true);
		resultMap.setData(userService.createUser(username,password));
		return resultMap;
	}
	
	
	@RequestMapping("findRoles")
	@ResponseBody
	@UrlPermissionComponent(url="usermanage/findRoles",desc="根据角色id获取已经拥有的角色",isView=false,belong="usermanage/main")
	public ResultMap<List<String>> findRoles(String userId) {
		ResultMap<List<String>> resultMap = new ResultMap<List<String>>();
		resultMap.setSuccess(true);
		resultMap.setData(userService.findRolesByUserId(userId));
		return resultMap;
	}
	
	@RequestMapping("correlationRoles")
	@ResponseBody
	@UrlPermissionComponent(url="usermanage/correlationRoles",desc="添加用户-角色接口",isView=false,belong="usermanage/main")
	public void correlationRoles(String userId, String[] roleIds) {
		userService.correlationRoles(userId, roleIds);
	}
	
	@RequestMapping("uncorrelationRoles")
	@ResponseBody
	@UrlPermissionComponent(url="usermanage/uncorrelationRoles",desc="移除用户-角色接口",isView=false,belong="usermanage/main")
	public void uncorrelationRoles(String userId, String[] roleIds) {
		userService.uncorrelationRoles(userId, roleIds);
	}
}
 
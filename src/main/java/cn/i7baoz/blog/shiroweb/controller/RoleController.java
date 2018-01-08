/** 
 * Project Name:shiroWeb 
 * File Name:RoleController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2017年12月28日下午2:44:34 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.controller;  

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.service.RoleService;
import cn.i7baoz.blog.shiroweb.service.UserService;
import cn.i7baoz.blog.shiroweb.util.ResultMap;

/** 
 * ClassName:RoleController 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 下午2:44:34 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	//角色设置视图
	@RequestMapping("roleSetting")
	@RequiresRoles("administrator")
	public String roleSetting() {
		return "role/roleSetting";
	}
	@RequestMapping("addRoleView")
	@RequiresRoles("administrator")
	public String addRoleView() {
		return "role/addRole";
	}
	//管理员可以查看任何人的角色
	@RequestMapping("findRoleByUsername")
	@ResponseBody
	public List<RoleBean> findRoleByUsername(String username) throws AuthenticationException{
		Subject subject = SecurityUtils.getSubject();
		if ( subject.hasRole("administrator") ) {
			if( null == username || username.isEmpty() ) {
				username = (String) SecurityUtils.getSubject().getPrincipal();
			}
			return userService.findRoleByUsername(username);
		}
		username = (String) SecurityUtils.getSubject().getPrincipal();
		return userService.findRoleByUsername(username);
	}

	@RequestMapping("listAllRoles")
	@RequiresRoles(value="administrator")
	@ResponseBody
	public List<RoleBean> listAllRoles() {
		
		return roleService.listAllRoles();
	}
	
	//创建角色
	@RequestMapping("create")
	@ResponseBody
	@RequiresRoles(value={"administrator","roleadmin"},logical=Logical.OR)
	public ResultMap<RoleBean> create(
			@RequestParam(required=true)String roleName
			,String desc) throws AuthenticationException{
		ResultMap<RoleBean> resultMap = new ResultMap<RoleBean>();
		
		Subject subject = SecurityUtils.getSubject();
    	RoleBean bean = new RoleBean();
    	bean.setRoleName(roleName);
    	bean.setDescMsg(desc);
    	bean.setCreateUsername(String.valueOf(subject.getPrincipal()));
    	roleService.createRole(bean);
    	
    	resultMap.setSuccess(true);
    	resultMap.setData(bean);
    	return resultMap;
	}
}
 
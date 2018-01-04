/** 
 * Project Name:shiroWeb 
 * File Name:RoleController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2017年12月28日下午2:44:34 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.controller;  

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.service.RoleService;
import cn.i7baoz.blog.shiroweb.util.SystemMessages;

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
	
	@RequestMapping("create")
	@ResponseBody
	@RequiresRoles(value="admin,roleadmin")

	public RoleBean create(
			@RequestParam(required=true)String roleName
			,String desc) throws AuthenticationException{
		
		Subject subject = SecurityUtils.getSubject();
    	RoleBean bean = new RoleBean();
    	bean.setRoleName(roleName);
    	bean.setDescMsg(desc);
    	bean.setCreateUsername(String.valueOf(subject.getPrincipal()));
    	roleService.createRole(bean);
    	return bean;
	}
	@RequestMapping("test")
	@ResponseBody
	public void test ()  throws AuthenticationException  {
		throw new AuthenticationException(SystemMessages.RETRY_TOO_MANY_TIMES.getMessage());
	}
}
 
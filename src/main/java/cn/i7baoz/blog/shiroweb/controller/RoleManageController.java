/** 
 * Project Name:shiroWeb 
 * File Name:RoleController.java 
 * Package Name:cn.i7baoz.blog.shiroweb.controller 
 * Date:2017年12月28日下午2:44:34 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.controller;  

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.i7baoz.blog.shiroweb.annotation.UrlPermissionComponent;
import cn.i7baoz.blog.shiroweb.dto.UrlPermissionTreeDto;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.service.PermissionService;
import cn.i7baoz.blog.shiroweb.service.RoleService;
import cn.i7baoz.blog.shiroweb.service.UserService;
import cn.i7baoz.blog.shiroweb.util.ResultMap;

/** 
 * ClassName:RoleManageController 角色管理
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 下午2:44:34 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Controller
@RequestMapping("role")
public class RoleManageController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	//角色设置视图
	@UrlPermissionComponent(url="role/roleSetting",desc="角色管理",isView=true,isMenu=true,sortNumber=1)
	@RequestMapping("roleSetting")
	public String roleSetting() {
		return "role/roleSetting";
	}
	@UrlPermissionComponent(url="role/addRoleView",desc="添加角色",isView=true,belong="role/roleSetting")
	@RequestMapping("addRoleView")
	public String addRoleView() {
		return "role/addRole";
	}
	//管理员可以查看任何人的角色
	@UrlPermissionComponent(url="role/findRoleByUsername",desc="根据用户名查看角色信息",isView=false,belong="role/roleSetting")
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
	
	@UrlPermissionComponent(url="role/listAllRoles",desc="查看所有角色信息",isView=false,belong="role/roleSetting")
	@RequestMapping("listAllRoles")
	@ResponseBody
	public ResultMap<List<RoleBean>> listAllRoles() {
		ResultMap<List<RoleBean>> resultMap = new ResultMap<List<RoleBean>>();
		resultMap.setData(roleService.listAllRoles());
		resultMap.setSuccess(true);
		return resultMap;
	}
	
	//创建角色
	@RequestMapping("create")
	@ResponseBody
	@UrlPermissionComponent(url="role/create",desc="创建角色",isView=false,belong="role/roleSetting")
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
	
	@RequestMapping("findPermissionByRoleId")
	@ResponseBody
	@UrlPermissionComponent(url="role/findPermissionByRoleId",desc="根据角色id获取已经拥有的权限",isView=false,belong="role/roleSetting")
	public ResultMap<List<String>> findPermissionByRoleId(String roleId) {
		ResultMap<List<String>> resultMap = new ResultMap<List<String>>();
		resultMap.setSuccess(true);
		resultMap.setData(roleService.findPermissionByRoleId(roleId));
		return resultMap;
	}
	
	
	
	@RequestMapping("correlationPermissions")
	@ResponseBody
	@UrlPermissionComponent(url="role/correlationPermissions",desc="添加角色-权限接口",isView=false,belong="role/roleSetting")
	public void correlationPermissions(String roleId, String[] permissionIds) {
		roleService.correlationPermissions(roleId, permissionIds);
	}
	
	@RequestMapping("uncorrelationPermissions")
	@ResponseBody
	@UrlPermissionComponent(url="role/uncorrelationPermissions",desc="移除角色-权限接口",isView=false,belong="role/roleSetting")
	public void uncorrelationPermissions(String roleId, String[] permissionIds) {
		roleService.uncorrelationPermissions(roleId, permissionIds);
	}
	
	@Autowired
	PermissionService permissionService;
	
	@RequestMapping("setting")
	@UrlPermissionComponent(isView=true,desc="角色设置权限",url="permission/setting",belong="role/roleSetting")
	public ModelAndView premissionManage(String roleId) {
		ModelAndView m = new ModelAndView("role/permissionManage");
		m.addObject("roleId", roleId);
		return m;
	}
	
	@RequestMapping("listAllPremissionInfo")
	@ResponseBody
	@UrlPermissionComponent(isView=false,desc="获取所有权限url",url="permission/listAllPremissionInfo",belong="role/roleSetting")
	public ResultMap<List<PermissionBean>> listAllPremissionInfo() {
		
		ResultMap<List<PermissionBean>> resultMap = new ResultMap<List<PermissionBean>>();
		resultMap.setData(permissionService.listAllPermission());
		resultMap.setSuccess(true);
		return resultMap;

	}
	@RequestMapping("listPremissionInfoTree")
	@ResponseBody
	@UrlPermissionComponent(isView=false,desc="获取所有权限url树",url="permission/listPremissionInfoTree",belong="role/roleSetting")
	public ResultMap<List<UrlPermissionTreeDto>> getUrlPermissionTree(
			@RequestParam(defaultValue="/")String rootPermission) {
		ResultMap<List<UrlPermissionTreeDto>> tree = new ResultMap<List<UrlPermissionTreeDto>>();
		tree.setSuccess(true);
		List<UrlPermissionTreeDto> list = new ArrayList<UrlPermissionTreeDto>();
		list.add(permissionService.getUrlPermissionTree(rootPermission));
		tree.setData(list);
		return tree;
	}
}
 
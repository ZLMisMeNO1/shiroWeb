/** 
 * Project Name:shiroWeb 
 * File Name:RoleService.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service 
 * Date:2017年12月28日上午11:04:05 
 * 
 */

package cn.i7baoz.blog.shiroweb.service;

import java.util.List;

import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.RolePermsBean;

/**
 * ClassName:RoleService Function: TODO ADD FUNCTION. Date: 2017年12月28日
 * 上午11:04:05
 * 
 * @author baoqi.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public interface RoleService {
	
	//创建角色
	public RoleBean createRole(RoleBean role);

	//列出所有角色
	public List<RoleBean> listAllRoles();
	
	//删除角色
	public void deleteRole(String roleId);

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public RolePermsBean correlationPermissions(String roleId, String... permissionIds);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public RolePermsBean uncorrelationPermissions(String roleId, String... permissionIds);
	
	public List<String> findPermissionByRoleId(String roleId) ;
}

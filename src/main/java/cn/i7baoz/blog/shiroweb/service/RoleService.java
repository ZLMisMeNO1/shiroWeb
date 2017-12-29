/** 
 * Project Name:shiroWeb 
 * File Name:RoleService.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service 
 * Date:2017年12月28日上午11:04:05 
 * 
 */

package cn.i7baoz.blog.shiroweb.service;

import cn.i7baoz.blog.shiroweb.pojo.RoleBean;

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
	
	public RoleBean createRole(RoleBean role);

	public void deleteRole(String roleId);

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(String roleId, String... permissionIds);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(String roleId, String... permissionIds);
}

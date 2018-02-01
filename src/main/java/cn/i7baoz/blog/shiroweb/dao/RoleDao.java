/** 
 * Project Name:shiroWeb 
 * File Name:RoleDao.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao 
 * Date:2017年12月28日上午10:20:14 
 * 
 */

package cn.i7baoz.blog.shiroweb.dao;

import java.util.List;

import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.RolePermsBean;

/**
 * ClassName:RoleDao Function: TODO ADD FUNCTION. Date: 2017年12月28日 上午10:20:14
 * 
 * @author baoqi.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public interface RoleDao {

	//添加角色
	public RoleBean createRole(RoleBean role);

	public List<RoleBean> listAllRoles();
	
	//删除角色
	public void deleteRole(String roleId);

	//角色添加权限
	public RolePermsBean correlationPermissions(String roleId, String... permissionIds);

	//角色删除权限
	public RolePermsBean uncorrelationPermissions(String roleId, String... permissionIds);
	
	//根据角色名查看具有哪些权限
	List<String> findPermissionByRoleId(String roleId);
}

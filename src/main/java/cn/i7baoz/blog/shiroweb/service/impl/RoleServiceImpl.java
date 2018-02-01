/** 
 * Project Name:shiroWeb 
 * File Name:RoleServiceImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service.impl 
 * Date:2017年12月28日上午11:05:36 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.i7baoz.blog.shiroweb.dao.RoleDao;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.RolePermsBean;
import cn.i7baoz.blog.shiroweb.service.RoleService;

/** 
 * ClassName:RoleServiceImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午11:05:36 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public RoleBean createRole(RoleBean role) {

		return roleDao.createRole(role);
	}

	@Override
	public void deleteRole(String roleId) {
		roleDao.deleteRole(roleId);
	}

	@Override
	public RolePermsBean correlationPermissions(String roleId, String... permissionIds) {
		return roleDao.correlationPermissions(roleId, permissionIds);
	}

	@Override
	public RolePermsBean uncorrelationPermissions(String roleId, String... permissionIds) {
		return roleDao.uncorrelationPermissions(roleId, permissionIds);
		
	}

	@Override
	public List<RoleBean> listAllRoles() {
		
		return roleDao.listAllRoles();
	}

	@Override
	public List<String> findPermissionByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return roleDao.findPermissionByRoleId(roleId);
	}

}
 
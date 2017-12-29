/** 
 * Project Name:shiroWeb 
 * File Name:PermissionServiceImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service.impl 
 * Date:2017年12月28日上午11:13:03 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service.impl;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.i7baoz.blog.shiroweb.dao.PermissionDao;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.service.PermissionService;

/** 
 * ClassName:PermissionServiceImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午11:13:03 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionDao permissionDao;
	
	@Override
	public PermissionBean createPermission(PermissionBean permission) {

		return permissionDao.createPermission(permission);
	}

	@Override
	public void deletePermission(String permissionId) {
		permissionDao.deletePermission(permissionId);
	}

}
 
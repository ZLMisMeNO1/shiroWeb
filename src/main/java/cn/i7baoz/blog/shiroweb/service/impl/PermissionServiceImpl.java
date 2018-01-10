/** 
 * Project Name:shiroWeb 
 * File Name:PermissionServiceImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service.impl 
 * Date:2017年12月28日上午11:13:03 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.i7baoz.blog.shiroweb.dao.PermissionDao;
import cn.i7baoz.blog.shiroweb.dto.UrlPermissionTreeDto;
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

	@Override
	public List<PermissionBean> listAllPermission() {
		// TODO Auto-generated method stub
		return permissionDao.listAllPermission();
	}

	@Override
	public List<PermissionBean> listMenu() {
		
		return permissionDao.listMenu();
	}

	@Override
	public PermissionBean saveOrUpdate(PermissionBean permission) {
		
		return permissionDao.updateOrSave(permission);
	}

	@Override
	public UrlPermissionTreeDto getUrlPermissionTree(String rootPermission) {
		PermissionBean cureentPermission = permissionDao.getPermissionBeanByPermission(rootPermission);
		if( null == cureentPermission) {
			return null;
		}
		UrlPermissionTreeDto dto = new UrlPermissionTreeDto(cureentPermission);
		List<PermissionBean> child = permissionDao.getPermissionBeanByParentPermission(dto.getPermission());
		if ( null != child && child.size() > 0 ) {
			for ( PermissionBean bean : child)
				dto.getChildren().add(getUrlPermissionTree(bean.getPermission()));
		}
		return dto;
	}
}
 
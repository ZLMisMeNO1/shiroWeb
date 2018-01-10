/** 
 * Project Name:shiroWeb 
 * File Name:PermissionDao.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao 
 * Date:2017年12月28日上午10:29:25 
 * 
 */

package cn.i7baoz.blog.shiroweb.dao;


import java.util.List;

import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;

/**
 * ClassName:PermissionDao Function: TODO ADD FUNCTION. Date: 2017年12月28日
 * 上午10:29:25
 * 
 * @author baoqi.zhang
 * @version
 * @since JDK 1.7
 * @see
 */

public interface PermissionDao {
	
	public PermissionBean createPermission(PermissionBean permission);

	public void deletePermission(String permissionId);

	public List<PermissionBean> listAllPermission();
	
	public List<PermissionBean> listMenu();
	
	public PermissionBean updateOrSave(PermissionBean permission);
	
	public PermissionBean getPermissionBeanByPermission(String permission);
	
	public List<PermissionBean> getPermissionBeanByParentPermission(String parentPermission);
}

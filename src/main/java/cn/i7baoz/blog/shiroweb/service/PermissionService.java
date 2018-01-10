/** 
 * Project Name:shiroWeb 
 * File Name:PermissionService.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service 
 * Date:2017年12月28日上午11:10:39 
 * 
 */

package cn.i7baoz.blog.shiroweb.service;

import java.util.List;

import cn.i7baoz.blog.shiroweb.dto.UrlPermissionTreeDto;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;

/**
 * ClassName:PermissionService Function: TODO ADD FUNCTION. Date: 2017年12月28日
 * 上午11:10:39
 * 
 * @author baoqi.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public interface PermissionService {
	
	public PermissionBean createPermission(PermissionBean permission);

	public PermissionBean saveOrUpdate(PermissionBean permission);
	
	public void deletePermission(String permissionId);
	
	List<PermissionBean> listAllPermission();
	
	public List<PermissionBean> listMenu();
	
	public UrlPermissionTreeDto getUrlPermissionTree(String rootPermission);
}

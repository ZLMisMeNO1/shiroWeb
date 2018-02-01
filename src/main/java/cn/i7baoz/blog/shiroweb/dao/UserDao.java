/** 
 * Project Name:shiroWeb 
 * File Name:UserDao.java 
 * Package Name:cn.i7baoz.blog.shiroweb.user 
 * Date:2017年12月28日上午9:28:21 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao;  

import java.util.List;

import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.pojo.UserRolesBean;

/** 
 * ClassName:UserDao 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午9:28:21 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface UserDao {

	//创建用户
	public UserBean createUser(UserBean user);
	//更新用户
    public void updateUser(UserBean user);
    //删除用户
    public void deleteUser(String userId);

    //添加角色
    public UserRolesBean correlationRoles(String userId, String... roleIds);
    
    //删除角色
    public UserRolesBean uncorrelationRoles(String userId, String... roleIds);

    //根据id获取用户
    UserBean findOne(String userId);

    //根据用户名获取用户
    UserBean findByUsername(String username);

    //获取角色
    List<String> findRoles(String username);

    //获取角色
    List<RoleBean> findRoleByUsername(String username);
    
    //获取权限
    List<String> findPermissions(String username);
    //获取权限
    List<PermissionBean> findPermissionsByUsername(String username);
    
    List<UserBean> listAllUsers();
    
	public List<String> findRolesByUserId(String userId);
}
 
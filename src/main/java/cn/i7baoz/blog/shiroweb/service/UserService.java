/** 
 * Project Name:shiroWeb 
 * File Name:UserService.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service 
 * Date:2017年12月28日上午10:55:00 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service;  

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;

import cn.i7baoz.blog.shiroweb.pojo.UserBean;

/** 
 * ClassName:UserService 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午10:55:00 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public UserBean createUser(String username,String password) throws AuthenticationException;

    public UserBean login(String username,String password) throws AuthenticationException;
    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(String userId, String newPassword) throws AuthenticationException;

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(String userId, String... roleIds) throws AuthenticationException;


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(String userId, String... roleIds) throws AuthenticationException;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public UserBean findByUsername(String username) throws AuthenticationException;

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public List<String> findRoles(String username) throws AuthenticationException;

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public List<String> findPermissions(String username) throws AuthenticationException;
    
    
    public List<UserBean> listAllUsers() throws AuthenticationException;
}
 
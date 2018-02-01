/** 
 * Project Name:shiroWeb 
 * File Name:UserServiceImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service.impl 
 * Date:2017年12月28日上午10:59:07 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service.impl;  

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.i7baoz.blog.shiroweb.dao.UserDao;
import cn.i7baoz.blog.shiroweb.enums.CurrentStatusEnum;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.pojo.UserRolesBean;
import cn.i7baoz.blog.shiroweb.service.UserService;
import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;
import cn.i7baoz.blog.shiroweb.util.PasswordHelper;

/** 
 * ClassName:UserServiceImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午10:59:07 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	private PasswordHelper passwordHelper;
	
	@Override
	public UserBean createUser(String username,String password) throws AuthenticationException {
		
		UserBean oldUser = userDao.findByUsername(username);
		
		if ( null != oldUser ) {
			throw new AuthenticationException(SystemMessageEnum.SAME_USERNAME_EXCEPTION.getMessage());
		}
		
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		user.setCurrentStatus(CurrentStatusEnum.NORMAL.getStatusCode());
		//用户密码加密
		new PasswordHelper().encryptPassword(user);
		UserBean newUser = userDao.createUser(user);
		return newUser;
	}

	@Override
	public void changePassword(String userId, String newPassword) throws AuthenticationException{
		UserBean user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUser(user);
	}

	@Override
	public UserRolesBean correlationRoles(String userId, String... roleIds) throws AuthenticationException{
		return userDao.correlationRoles(userId, roleIds);
	}

	@Override
	public UserRolesBean uncorrelationRoles(String userId, String... roleIds) throws AuthenticationException{
		return userDao.uncorrelationRoles(userId, roleIds);
	}

	@Override
	public UserBean findByUsername(String username) throws AuthenticationException{

		return userDao.findByUsername(username);
	}

	@Override
	public List<String> findRoles(String username) throws AuthenticationException{

		return userDao.findRoles(username);
	}
	@Override
	public List<String> findRolesByUserId(String userId) throws AuthenticationException {
		return userDao.findRolesByUserId(userId);
	}
	@Override
	public List<String> findPermissions(String username) throws AuthenticationException{

		return userDao.findPermissions(username);
	}

	@Override
	public List<UserBean> listAllUsers() throws AuthenticationException{
		List<UserBean>  list = userDao.listAllUsers();
		for (UserBean bean : list ) {
			bean.setPassword(null);
			bean.setSalt(null);
		}
		return userDao.listAllUsers();
	}

	@Override
	public List<PermissionBean> findPermissionsByUsername(String username) {
		
		return userDao.findPermissionsByUsername(username);
	}

	@Override
	public List<RoleBean> findRoleByUsername(String username) {
		
		return userDao.findRoleByUsername(username);
	}

	

}
 
/** 
 * Project Name:shiroWeb 
 * File Name:UserServiceImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service.impl 
 * Date:2017年12月28日上午10:59:07 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service.impl;  

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.i7baoz.blog.shiroweb.dao.UserDao;
import cn.i7baoz.blog.shiroweb.exception.ExceptionMsg;
import cn.i7baoz.blog.shiroweb.exception.TraditionException;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.service.UserService;
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
//@Component  
//@Transactional 
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	private PasswordHelper passwordHelper;
	
	@Override
	public UserBean createUser(String username,String password) throws Exception {
		
		UserBean oldUser = userDao.findByUsername(username);
		
		if ( null != oldUser ) {
			throw new TraditionException(ExceptionMsg.SAME_USERNAME_EXCEPTION);
		}
		
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		//用户密码加密
		new PasswordHelper().encryptPassword(user);
		
		return userDao.createUser(user);
	}

	@Override
	public UserBean login(String username, String password) throws Exception {
		
		UserBean oldUser = userDao.findByUsername(username);
		
		if ( null == oldUser ) {
			throw new TraditionException(ExceptionMsg.USER_IS_NOT_EXIST);
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		Subject subject = SecurityUtils.getSubject();
		System.out.println("开始登录");
		
        try {  
            subject.login(token);  
            System.out.println("登录成功");
        } catch (UnknownAccountException e) {  
        	 System.out.println("登录失败");
            throw new TraditionException(ExceptionMsg.USER_IS_NOT_EXIST);
           
        } catch (IncorrectCredentialsException e) { 
        	 System.out.println("登录失败");
            throw new TraditionException(ExceptionMsg.USERNAME_OR_PASSWORD_IS_WRONG);
        } catch (AuthenticationException e) {  
            //其他错误，比如锁定，如果想单独处理请单独catch处理  
            System.out.println("登录失败");
            e.printStackTrace();
        } 
		return null;
	}
	@Override
	public void changePassword(String userId, String newPassword) {
		UserBean user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUser(user);
	}

	@Override
	public void correlationRoles(String userId, String... roleIds) {
		userDao.correlationRoles(userId, roleIds);
	}

	@Override
	public void uncorrelationRoles(String userId, String... roleIds) {
		userDao.uncorrelationRoles(userId, roleIds);
	}

	@Override
	public UserBean findByUsername(String username) {

		return userDao.findByUsername(username);
	}

	@Override
	public List<String> findRoles(String username) {

		return userDao.findRoles(username);
	}

	@Override
	public List<String> findPermissions(String username) {

		return userDao.findPermissions(username);
	}

	@Override
	public List<UserBean> listAllUsers() {
		
		return userDao.listAllUsers();
	}

	

}
 
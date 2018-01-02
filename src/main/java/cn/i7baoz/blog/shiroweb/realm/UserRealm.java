/** 
 * Project Name:shiroWeb 
 * File Name:UserRealm.java 
 * Package Name:cn.i7baoz.blog.shiroweb.realm 
 * Date:2017年12月28日上午11:33:24 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.realm;  

import java.util.HashSet;

import javax.annotation.Resource;


//import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.i7baoz.blog.shiroweb.exception.TraditionException;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.service.UserService;

/** 
 * ClassName:UserRealm 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午11:33:24 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
//@Component
//@Repository
public class UserRealm extends AuthorizingRealm{
	
//	private static Logger log = Logger.getLogger(UserRealm.class);
	
	@Resource
	private UserService userService ;//= new UserServiceImpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        try {
        	 authorizationInfo.setRoles(new HashSet<String>(userService.findRoles(username)));
             authorizationInfo.setStringPermissions(new HashSet<String>(userService.findPermissions(username)));
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
       
        
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        UserBean user = null;
		try {
			user = userService.findByUsername(username);
		} catch (TraditionException e) {
			
			e.printStackTrace();
		}
        
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

//        if(Boolean.TRUE.equals(user.getLocked())) {
//            throw new LockedAccountException(); //帐号锁定
//        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
 
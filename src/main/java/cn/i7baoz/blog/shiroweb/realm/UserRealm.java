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

import cn.i7baoz.blog.shiroweb.enums.CurrentStatusEnum;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.service.UserService;
import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;

/** 
 * ClassName:UserRealm 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午11:33:24 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class UserRealm extends AuthorizingRealm{
	
	
	@Resource
	private UserService userService ;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        try {
        	 authorizationInfo.setRoles(new HashSet<String>(userService.findRoles(username)));
             authorizationInfo.setStringPermissions(new HashSet<String>(userService.findPermissions(username)));
        } catch (AuthenticationException e) {
        	throw e;
        }
       
        return authorizationInfo;
    }

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        UserBean user = null;
		try {
			user = userService.findByUsername(username);
		} catch (AuthenticationException e) {
			throw new AuthenticationException(SystemMessageEnum.UNKOWN_ERROR.getMessage());
		}
        
        if(user == null) {
            throw new UnknownAccountException(SystemMessageEnum.USER_IS_NOT_EXIST.getMessage());//没找到帐号
        }

        if(CurrentStatusEnum.LOCKED.getStatusCode().equals(user.getCurrentStatus())) {
            throw new AuthenticationException(SystemMessageEnum.USER_IS_LOCKED.getMessage()); //帐号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
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
 
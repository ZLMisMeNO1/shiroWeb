/** 
 * Project Name:shiroWeb 
 * File Name:RetryLimitHashedCredentialsMatcher.java 
 * Package Name:cn.i7baoz.blog.shiroweb.credentials 
 * Date:2017年12月28日上午11:38:57 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.credentials;  

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/** 
 * ClassName:RetryLimitHashedCredentialsMatcher 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午11:38:57 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class RetryLimitHashedCredentialsMatcher  extends HashedCredentialsMatcher {
	private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
    	System.out.println("RetryLimitHashedCredentialsMatcher");
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        System.out.println("reerd:" + username);
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if(retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            //clear retry count
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
 
/** 
 * Project Name:shiroWeb 
 * File Name:RetryLimitHashedCredentialsMatcher.java 
 * Package Name:cn.i7baoz.blog.shiroweb.credentials 
 * Date:2017年12月28日上午11:38:57 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.credentials;  


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.cache.CacheManager;

import cn.i7baoz.blog.shiroweb.jedis.JedisClient;
import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;
import redis.clients.jedis.Jedis;

/** 
 * ClassName:RetryLimitHashedCredentialsMatcher 重试密码次数
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午11:38:57 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class RetryLimitHashedCredentialsMatcher  extends HashedCredentialsMatcher {

	private Jedis jedis ;
	
    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
    	jedis = JedisClient.getRedisClient();
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        String username = (String)token.getPrincipal();
        
        String jedisKey = "retryCount_" + username;
        //retry count + 1
        Long retryCount = jedis.incr(jedisKey);
//        System.out.println(" current username : " + username + ",retry times is : " + retryCount);
//        logger.info(" current username : " + username + ",retry times is : " + retryCount);
        if(retryCount > 5) {
            //if retry count > 5 throw
        	//一分钟后可以重新登录
        	jedis.expire(jedisKey,60);
            throw new ExcessiveAttemptsException(SystemMessageEnum.RETRY_TOO_MANY_TIMES.getMessage());
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if ( matches) {
            //clear retry count
        	jedis.del(jedisKey);
        }
        return matches;
    }
}
 
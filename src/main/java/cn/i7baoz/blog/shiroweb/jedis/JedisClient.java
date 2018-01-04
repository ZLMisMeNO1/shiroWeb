/** 
 * Project Name:shiroWeb 
 * File Name:JedisClient.java 
 * Package Name:cn.i7baoz.blog.shiroweb.jedis 
 * Date:2018年1月3日上午10:26:22 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.jedis;  

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/** 
 * ClassName:JedisClient 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月3日 上午10:26:22 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class JedisClient {

	private static JedisPool pool = null;
	
	private static String host;
	
	private static Integer port;
	
	private static Jedis jedis = null;
	
	private static final Logger logger = Logger.getLogger(JedisClient.class);
	/**
    * 构建redis连接池
    * 
    * @param ip
    * @param port
    * @return JedisPool
    */
	private static JedisPool getPool() {
		Properties prop = new Properties();
		try {
			InputStream in = JedisClient.class.getClassLoader().getResourceAsStream("redis.properties");
			prop.load(in);
			host = prop.getProperty("host","localhost");
			port = Integer.parseInt(prop.getProperty("port","6379"));
		
		} catch (Exception e) {
			logger.error("获取redis配置文件失败,请检查reids.properties文件是否存在!");
			e.printStackTrace();
		} 
	  
		if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
            //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
            config.setMaxActive(500); 
            //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(5);
            //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWait(1000 * 100);
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, host, port);
        }
		return pool;
	}
   
   	public static Jedis getRedisClient () {
   		if ( null == jedis ) {
   			pool = getPool();
   			jedis = pool.getResource();
   		}
   		return jedis;
   	}
	/**
     * 返还到连接池
     * 
     * @param pool 
     * @param redis
     */
//   private static void returnResource(JedisPool pool, Jedis redis) {
//        if (redis != null) {
//            pool.returnResource(redis);
//        }
//    }
}
 
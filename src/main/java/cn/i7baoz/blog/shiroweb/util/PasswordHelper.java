/** 
 * Project Name:shiroWeb 
 * File Name:PasswordHelper.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service 
 * Date:2017年12月28日上午10:45:00 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.util;  

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import cn.i7baoz.blog.shiroweb.pojo.UserBean;

/** 
 * ClassName:PasswordHelper 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午10:45:00 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class PasswordHelper {

	//随机数
	private RandomNumberGenerator randomNumberGenereator = new SecureRandomNumberGenerator();
	
	//加密方式
	private String algorithmName = "md5";
	
	//生成密码时迭代次数
	private int hashIterations = 2;

	public void setRandomNumberGenereator(
			RandomNumberGenerator randomNumberGenereator) {
		this.randomNumberGenereator = randomNumberGenereator;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public void encryptPassword(UserBean user) {
		user.setSalt(randomNumberGenereator.nextBytes().toHex());
		
		String newPassword = new SimpleHash(
				algorithmName,
				user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				hashIterations
				).toHex();
		user.setPassword(newPassword);
	}
}
 
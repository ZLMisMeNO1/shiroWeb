/** 
 * Project Name:shiroWeb 
 * File Name:UserOptionLogDao.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao 
 * Date:2018年2月1日上午11:16:54 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao;  

import java.util.List;

import cn.i7baoz.blog.shiroweb.pojo.UserOptionLogBean;

/** 
 * ClassName:UserOptionLogDao 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月1日 上午11:16:54 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface UserOptionLogDao {

	UserOptionLogBean save( UserOptionLogBean log );
	
	List<UserOptionLogBean> listLogs();
	
	List<UserOptionLogBean> listLogs(String username);
}
 
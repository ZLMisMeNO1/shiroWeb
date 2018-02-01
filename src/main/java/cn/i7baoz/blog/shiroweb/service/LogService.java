/** 
 * Project Name:shiroWeb 
 * File Name:LogService.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service 
 * Date:2018年2月1日上午11:28:35 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service;  

import java.util.List;

import cn.i7baoz.blog.shiroweb.pojo.UserOptionLogBean;

/** 
 * ClassName:LogService 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月1日 上午11:28:35 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface LogService {

	UserOptionLogBean save( UserOptionLogBean log );
	
	List<UserOptionLogBean> listLogs();
	
	List<UserOptionLogBean> listLogs(String username);
}
 
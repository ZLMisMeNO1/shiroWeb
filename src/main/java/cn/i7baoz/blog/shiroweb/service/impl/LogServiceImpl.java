/** 
 * Project Name:shiroWeb 
 * File Name:LogServiceImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.service.impl 
 * Date:2018年2月1日上午11:28:51 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.service.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.i7baoz.blog.shiroweb.dao.UserOptionLogDao;
import cn.i7baoz.blog.shiroweb.pojo.UserOptionLogBean;
import cn.i7baoz.blog.shiroweb.service.LogService;

/** 
 * ClassName:LogServiceImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月1日 上午11:28:51 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	UserOptionLogDao userOptionLogDao;
	
	@Override
	public UserOptionLogBean save(UserOptionLogBean log) {

		return userOptionLogDao.save(log);
	}

	@Override
	public List<UserOptionLogBean> listLogs() {

		return userOptionLogDao.listLogs();
	}

	@Override
	public List<UserOptionLogBean> listLogs(String username) {

		return userOptionLogDao.listLogs(username);
	}

}
 
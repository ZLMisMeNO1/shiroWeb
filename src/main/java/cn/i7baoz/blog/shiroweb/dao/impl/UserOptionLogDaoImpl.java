/** 
 * Project Name:shiroWeb 
 * File Name:UserOptionLogDaoImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao.impl 
 * Date:2018年2月1日上午11:17:43 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao.impl;  

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.i7baoz.blog.shiroweb.dao.UserOptionLogDao;
import cn.i7baoz.blog.shiroweb.pojo.UserOptionLogBean;

/** 
 * ClassName:UserOptionLogDaoImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月1日 上午11:17:43 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Repository
public class UserOptionLogDaoImpl implements UserOptionLogDao {

	@Resource(name="commonSessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public UserOptionLogBean save(UserOptionLogBean log) {
		sessionFactory.getCurrentSession().save(log);
		return log;
	}


	@Override
	public List<UserOptionLogBean> listLogs() {
		
		return listLogs(null);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserOptionLogBean> listLogs(String username) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from UserOptionLogBean where 1 = 1 ");
		if ( null != username && !username.isEmpty() ) {
			sb.append(" and currentUser = :username "); 
		}
		Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());
		if ( null != username && !username.isEmpty() ) {
			query.setString("username", username);
		}
		return query.list();
	}

}
 
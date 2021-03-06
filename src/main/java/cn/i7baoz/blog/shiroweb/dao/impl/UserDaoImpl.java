/** 
 * Project Name:shiroWeb 
 * File Name:UserDaoImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao.impl 
 * Date:2017年12月28日上午9:32:02 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao.impl;  

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import cn.i7baoz.blog.shiroweb.dao.UserDao;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.UserBean;
import cn.i7baoz.blog.shiroweb.pojo.UserRolesBean;

/** 
 * ClassName:UserDaoImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午9:32:02 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Repository
public class UserDaoImpl implements UserDao{

	@Resource(name="commonSessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public UserBean createUser(UserBean user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public void updateUser(UserBean user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(String userId) {
		sessionFactory.getCurrentSession().delete(UserBean.class.getName(), userId);
	}

	@Override
	public UserRolesBean correlationRoles(String userId, String... roleIds) {
		UserRolesBean bean = null;
		for ( String roleId : roleIds ) {
			bean = getUserRolesBean(userId,roleId);
			if ( null == bean ) {
				bean = new UserRolesBean();
				bean.setCreateTime(new Timestamp(System.currentTimeMillis()));
				bean.setRoleId(roleId);
				bean.setUserId(userId);
				sessionFactory.getCurrentSession().save(bean);
			}
		}
		return bean;
	}

	@Override
	public UserRolesBean uncorrelationRoles(String userId, String... roleIds) {
		
		UserRolesBean bean = null;
		for ( String roleId : roleIds ) {
			bean = getUserRolesBean(userId,roleId);
			if ( null != bean ) {
				sessionFactory.getCurrentSession().delete(bean);
			}
		}
		return bean;
	}

	@SuppressWarnings("unchecked")
	private UserRolesBean getUserRolesBean (String userId,String roleId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserRolesBean.class);
		criteria.add(Restrictions.eq("userId", userId)).add(Restrictions.eq("roleId", roleId));
		List<UserRolesBean> list = criteria.list();
		if ( null == list || list.size() == 0 ) {
			return null;
		}
		return list.get(0);
	}
	
	@Override
	public UserBean findOne(String userId) {
		
		return (UserBean) sessionFactory.getCurrentSession().get(UserBean.class, userId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserBean findByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(UserBean.class);
		c.add(Restrictions.eq("username", username));
		List<UserBean> list = c.list();
		if ( null == list || list.size() == 0 ) {
			return null;
		}
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findRoles(String username) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select r.roleName from UserBean u,RoleBean r,UserRolesBean ur  ");
		sb.append(" where u.username = :username ");
		sb.append(" and u.userId = ur.userId ");
		sb.append(" and ur.roleId = r.roleId ");
		Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());
		query.setString("username", username);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleBean> findRoleByUsername(String username) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select r from UserBean u,RoleBean r,UserRolesBean ur  ");
		sb.append(" where u.username = :username ");
		sb.append(" and u.userId = ur.userId ");
		sb.append(" and ur.roleId = r.roleId ");
		Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());
		query.setString("username", username);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findPermissions(String username) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.permission from UserBean u,RoleBean r,UserRolesBean ur,PermissionBean p,RolePermsBean rp  ");
		sb.append(" where u.username = :username ");
		sb.append(" and u.userId = ur.userId ");
		sb.append(" and ur.roleId = r.roleId ");
		sb.append(" and ur.roleId = rp.roleId ");
		sb.append(" and rp.permsId = p.permsId ");
		Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());
		query.setString("username", username);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBean> listAllUsers() {
		return sessionFactory.getCurrentSession().createCriteria(UserBean.class).list();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<PermissionBean> findPermissionsByUsername(String username) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" select p from UserBean u,RoleBean r,UserRolesBean ur,PermissionBean p,RolePermsBean rp  ");
		sb.append(" where u.username = :username ");
		sb.append(" and u.userId = ur.userId ");
		sb.append(" and ur.roleId = r.roleId ");
		sb.append(" and ur.roleId = rp.roleId ");
		sb.append(" and rp.permsId = p.permsId ");
		Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());
		query.setString("username", username);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findRolesByUserId(String userId) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserRolesBean.class);
		criteria.add(Restrictions.eq("userId", userId));
		
		List<String> roles = new ArrayList<String>();
		List<UserRolesBean> list = criteria.list();
		if ( null != list ) {
			for ( UserRolesBean bean : list ) {
				roles.add(bean.getRoleId());
			}
		}
		
		return roles;
	}
}
 
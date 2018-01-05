/** 
 * Project Name:shiroWeb 
 * File Name:RoleDaoImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao.impl 
 * Date:2017年12月28日上午10:22:12 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao.impl;  

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.i7baoz.blog.shiroweb.dao.RoleDao;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.RolePermsBean;

/** 
 * ClassName:RoleDaoImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午10:22:12 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Repository
public class RoleDaoImpl implements RoleDao {

	@Resource(name="commonSessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public RoleBean createRole(RoleBean role) {
		sessionFactory.getCurrentSession().save(role);
		return role;
	}

	@Override
	public void deleteRole(String roleId) {
		Session session = sessionFactory.getCurrentSession();
		//删除角色
		session.delete(RoleBean.class.getName(), roleId);
		
		//删除角色关联权限
		String hql = "delete from RolePermsBean where roleId = :roleId ";
		Query query = session.createQuery(hql);
		query.setString("roleId", roleId);
		query.executeUpdate();
	}

	@Override
	public void correlationPermissions(String roleId, String... permissionIds) {
		RolePermsBean bean;
		for ( String permissionId : permissionIds ) {
			bean = getUserRolesBean(roleId,permissionId);
			if ( null == bean ) {
				sessionFactory.getCurrentSession().save(bean);
			}
		}
	}

	@Override
	public void uncorrelationPermissions(String roleId, String... permissionIds) {
		
		RolePermsBean bean;
		for ( String permissionId : permissionIds ) {
			bean = getUserRolesBean(roleId,permissionId);
			if ( null == bean ) {
				sessionFactory.getCurrentSession().delete(bean);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private RolePermsBean getUserRolesBean (String roleId,String permsId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RolePermsBean.class);
		criteria.add(Restrictions.eq("permsId", permsId)).add(Restrictions.eq("roleId", roleId));
		List<RolePermsBean> list = criteria.list();
		if ( null == list || list.size() == 0 ) {
			return null;
		}
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleBean> listAllRoles() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RoleBean.class);
		return criteria.list();
	}
}
 
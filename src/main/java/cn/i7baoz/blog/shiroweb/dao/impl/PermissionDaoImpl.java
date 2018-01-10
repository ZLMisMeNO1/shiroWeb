/** 
 * Project Name:shiroWeb 
 * File Name:PermissionDaoImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao.impl 
 * Date:2017年12月28日上午10:29:59 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao.impl;  

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.i7baoz.blog.shiroweb.dao.PermissionDao;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;

/** 
 * ClassName:PermissionDaoImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午10:29:59 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {

	@Resource(name="commonSessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public PermissionBean createPermission(PermissionBean permission) {
		PermissionBean oldBean = exist(permission);
		if ( null ==  oldBean) {
			sessionFactory.getCurrentSession().save(permission);
			return permission;
		}
		return oldBean;
	}
	@Override
	public PermissionBean updateOrSave(PermissionBean permission) {
		PermissionBean oldBean = exist(permission);
		if ( null ==  oldBean) {
			sessionFactory.getCurrentSession().save(permission);
			return permission;
		}
		oldBean.setBelong(permission.getBelong());
		oldBean.setCreateTime(permission.getCreateTime());
		oldBean.setCurrentStatus(permission.getCurrentStatus());
		oldBean.setDescMsg(permission.getDescMsg());
		oldBean.setIsMenu(permission.getIsMenu());
		oldBean.setPermission(permission.getPermission());
		oldBean.setPermissionType(permission.getPermissionType());
		oldBean.setSortNumber(permission.getSortNumber());
		sessionFactory.getCurrentSession().saveOrUpdate(oldBean);
		return oldBean;
	}
	@SuppressWarnings("unchecked")
	private PermissionBean exist(PermissionBean permission) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(PermissionBean.class);
		c.add(Restrictions.eq("permission", permission.getPermission()));
		List<PermissionBean> list = c.list();
		if ( null == list || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	@Override
	public void deletePermission(String permissionId) {
		Session session = sessionFactory.getCurrentSession();
		//删除角色
		session.delete(PermissionBean.class.getName(), permissionId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PermissionBean> listAllPermission() {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(PermissionBean.class);
		return c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PermissionBean> listMenu() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(PermissionBean.class);
		c.add(Restrictions.eq("isMenu", true));
		c.addOrder(Order.asc("sortNumber"));
		return c.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public PermissionBean getPermissionBeanByPermission(String permission) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(PermissionBean.class);
		c.add(Restrictions.eq("permission", permission));
		List<PermissionBean> list = c.list();
		if(null == list || list.size() == 0 ) {
			return null;
		}
		return list.get(0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PermissionBean> getPermissionBeanByParentPermission(
			String parentPermission) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(PermissionBean.class);
		c.add(Restrictions.eq("belong", parentPermission));
		return c.list();
	}

	

}
 
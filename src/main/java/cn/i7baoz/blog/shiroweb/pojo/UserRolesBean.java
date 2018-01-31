/** 
 * Project Name:shiroWeb 
 * File Name:UserRoles.java 
 * Package Name:cn.i7baoz.blog.shiroweb.pojo 
 * Date:2017年12月28日上午9:02:06 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.pojo;  

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 
 * ClassName:UserRoles 用户角色关系
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午9:02:06 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Table(name="t_user_roles")
@Entity
public class UserRolesBean extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 255)
	private String id;
	
	//用户id
	private String userId;
	
	//角色id
	private String roleId;
	
	//描述
	private String descMsg;
	
	//创建时间
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	
	//排序号
	@OrderBy
	private Integer sortNumber = 0 ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getDescMsg() {
		return descMsg;
	}
	public void setDescMsg(String descMsg) {
		this.descMsg = descMsg;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getSortNumber() {
		return sortNumber;
	}
	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRolesBean other = (UserRolesBean) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}
 
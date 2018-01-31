/** 
 * Project Name:shiroWeb 
 * File Name:UserRoles.java 
 * Package Name:cn.i7baoz.blog.shiroweb.pojo 
 * Date:2017年12月27日下午4:34:21 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.pojo;  

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 
 * ClassName:UserRoles 角色表
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月27日 下午4:34:21 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Entity
@Table(name="t_role")
public class RoleBean extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 255)
	private String roleId;
	
	//角色名称
	@Column(nullable=false)
	private String roleName;
	
	//创建时间
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	
	//创建人
	private String createUsername;
	
	private Integer currentStatus;

	private String descMsg;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public Integer getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}

	
	public String getDescMsg() {
		return descMsg;
	}

	public void setDescMsg(String descMsg) {
		this.descMsg = descMsg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		RoleBean other = (RoleBean) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
}
 
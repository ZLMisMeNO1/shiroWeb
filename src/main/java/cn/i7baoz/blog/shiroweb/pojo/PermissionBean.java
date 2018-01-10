/** 
 * Project Name:shiroWeb 
 * File Name:PermsBean.java 
 * Package Name:cn.i7baoz.blog.shiroweb.pojo 
 * Date:2017年12月27日下午4:41:40 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.pojo;  

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 
 * ClassName:PermsBean 权限实体
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月27日 下午4:41:40 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Table(name="t_permission")
@Entity
public class PermissionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 255)
	private String permsId;
	
	@Column(nullable=false,unique=true)
	private String permission;
	
	//创建时间
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());

	//当前状态
	private Integer currentStatus;
	
	//描述
	private String descMsg;

	//权限类型  0：视图类型  1：接口类型
	private Integer permissionType = 0;
	
	//所属页面
	private String belong = "/";
	//是否为菜单 
	private Boolean isMenu = false;
	
	private Integer sortNumber = 0;
	
	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public String getPermsId() {
		return permsId;
	}

	public void setPermsId(String permsId) {
		this.permsId = permsId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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


	public Boolean getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Boolean isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	@Override
	public String toString() {
		return "PermissionBean [permsId=" + permsId + ", permission="
				+ permission + ", createTime=" + createTime
				+ ", currentStatus=" + currentStatus + ", descMsg=" + descMsg
				+ ", permissionType=" + permissionType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((permission == null) ? 0 : permission.hashCode());
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
		PermissionBean other = (PermissionBean) obj;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
			return false;
		return true;
	}
	
}
 
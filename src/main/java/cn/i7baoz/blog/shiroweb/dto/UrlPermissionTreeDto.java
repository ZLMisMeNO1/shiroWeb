/** 
 * Project Name:shiroWeb 
 * File Name:UrlPermissionTreeDto.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dto 
 * Date:2018年1月10日下午1:36:39 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dto;  

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;

/** 
 * ClassName:UrlPermissionTreeDto 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月10日 下午1:36:39 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class UrlPermissionTreeDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String permsId;
	
	private String permission;
	
	//创建时间
	private Timestamp createTime ;

	//当前状态
	private Integer currentStatus;
	
	//描述
	private String descMsg;

	//权限类型  0：视图类型  1：接口类型
	private Integer permissionType ;
	
	//所属页面
	private String belong ;
	//是否为菜单 
	private Boolean isMenu ;
	
	private Integer sortNumber ;
	
	List<UrlPermissionTreeDto> children = new ArrayList<UrlPermissionTreeDto>();

	
	public UrlPermissionTreeDto() {
		super();
	}
	public UrlPermissionTreeDto(PermissionBean bean) {
		this.createTime = bean.getCreateTime();
		this.currentStatus = bean.getCurrentStatus();
		this.descMsg = bean.getDescMsg();
		this.belong = bean.getBelong();
		this.isMenu = bean.getIsMenu();
		this.permission = bean.getPermission();
		this.permissionType = bean.getPermissionType();
		this.permsId = bean.getPermsId();
		this.sortNumber = bean.getSortNumber();
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

	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
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
	public List<UrlPermissionTreeDto> getChildren() {
		return children;
	}

	public void setChildren(List<UrlPermissionTreeDto> children) {
		this.children = children;
	}
	
	

}
 
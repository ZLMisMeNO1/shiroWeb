/** 
 * Project Name:shiroWeb 
 * File Name:UserBean.java 
 * Package Name:cn.i7baoz.blog.shiroweb.pojo 
 * Date:2017年12月27日下午4:31:25 
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
 * ClassName:UserBean Function: TODO ADD FUNCTION. Date: 2017年12月27日 下午4:31:25
 * 
 * @author baoqi.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
@Table(name = "t_user")
@Entity
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 255)
	private String userId;

	// 用户名
	@Column(nullable = false, unique = true)
	private String username;

	// 密码
	@Column(nullable = false)
	private String password;

	// 密码盐
	private String salt;

	// 用户状态
	private Integer currentStatus;

	// 创建时间
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());

	public UserBean() {
		super();
	}

	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Integer getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UserBean other = (UserBean) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}

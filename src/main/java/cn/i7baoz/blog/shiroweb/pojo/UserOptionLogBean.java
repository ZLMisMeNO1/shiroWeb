package cn.i7baoz.blog.shiroweb.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import cn.i7baoz.blog.shiroweb.enums.LogTopicEnum;
import cn.i7baoz.blog.shiroweb.enums.OptionEnmu;
import cn.i7baoz.blog.shiroweb.util.Pojo2JSONStringUtil;
/**
 * 
 * @ClassName: UserOptionLogBean 操作日志
 * @Description:  
 * @author baoqi.zhang
 * @date 2018年1月31日 下午10:24:15 
 * 注意：本内容仅限于osbullshit内部技术人员使用，禁止外泄以及用于其他的商业目的
 */
@Table(name="t_opt_logs")
@Entity
public class UserOptionLogBean extends BaseBean{


	/**   
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 255)
	private String optId;
	
	//当前用户
	private String currentUser;
	
	//操作的对象
	private String optObject;
	
	//具体操作
	private String option;
	
	//操作时间
	private Timestamp optTime = new Timestamp(System.currentTimeMillis());
	
	//操作结果
	private String optResult;

	public String getOptId() {
		return optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public String getOptObject() {
		return optObject;
	}

	public void setOptObject(String optObject) {
		this.optObject = optObject;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Timestamp getOptTime() {
		return optTime;
	}

	public void setOptTime(Timestamp optTime) {
		this.optTime = optTime;
	}

	public String getOptResult() {
		return optResult;
	}

	public void setOptResult(String optResult) {
		this.optResult = optResult;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UserOptionLogBean(String currentUser, String optObject,
			String option, String optResult) {
		super();
		this.currentUser = currentUser;
		this.optObject = optObject;
		this.option = option;
		this.optResult = optResult;
	}

	public static UserOptionLogBean toLog(String currentUser,LogTopicEnum optObject
			,OptionEnmu option,BaseBean result) {
		
		return new UserOptionLogBean(currentUser,
				optObject.name(),
				option.name(),
				Pojo2JSONStringUtil.toJSONString(result));
	}
	
	public static String toLogString(String currentUser,LogTopicEnum optObject
			,OptionEnmu option,BaseBean result) {
		
		return Pojo2JSONStringUtil.toJSONString(
				toLog(currentUser, optObject, option, result)
				);
	}
}

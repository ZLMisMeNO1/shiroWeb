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
import cn.i7baoz.blog.shiroweb.util.BeanUtil;
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
	private String optionName;
	
	//操作时间
	private Timestamp optTime = new Timestamp(System.currentTimeMillis());
	
	//操作结果
	private String optResult;
	
	private String ip;

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

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String option) {
		this.optionName = option;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public UserOptionLogBean(String currentUser, String optObject,
			String optionName, String optResult,String ip) {
		super();
		this.currentUser = currentUser;
		this.optObject = optObject;
		this.optionName = optionName;
		this.optResult = optResult;
		this.ip = ip;
	}

	public UserOptionLogBean( String currentUser,
			String optObject, String optionName, Timestamp optTime, String optResult,String ip) {
		super();
		this.currentUser = currentUser;
		this.optObject = optObject;
		this.optionName = optionName;
		this.optTime = optTime;
		this.optResult = optResult;
		this.ip = ip;
	}

	public static UserOptionLogBean toLog(String currentUser,LogTopicEnum optObject
			,OptionEnmu option,BaseBean result,String ip) {
		
		return new UserOptionLogBean(currentUser,
				optObject.name(),
				option.name(),
				BeanUtil.toJSONString(result),ip);
	}
	
	
}

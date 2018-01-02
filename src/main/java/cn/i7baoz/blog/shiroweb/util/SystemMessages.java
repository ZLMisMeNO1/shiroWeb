/** 
 * Project Name:shiroWeb 
 * File Name:AllMsg.java 
 * Package Name:cn.i7baoz.blog.shiroweb.util 
 * Date:2018年1月2日下午4:02:22 
 * 
 */

package cn.i7baoz.blog.shiroweb.util;

/**
 * ClassName:AllMsg Function: TODO ADD FUNCTION. Date: 2018年1月2日 下午4:02:22
 * 
 * @author baoqi.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public enum SystemMessages {

	SAME_USERNAME_EXCEPTION("用户名已存在，请重新输入！")

	, USERNAM_OR_PASSWORD_IS_NULL("用户名或密码不能为空")

	, USER_IS_NOT_EXIST("用户不存在！") 

	, USERNAME_OR_PASSWORD_IS_WRONG("用户名或密码错误！")

	, ROLE_NAME_IS_EMPTY("角色名称不能为空") 
	
	, UNKOWN_ERROR("未知错误！");
	private String name;
	
	private SystemMessages(String abc) {
		this.name = abc;
	}

	public String getName() {
		return name;
	}

	
	
}

package cn.i7baoz.blog.shiroweb.util;

import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;
import cn.i7baoz.blog.shiroweb.exception.TraditionException;
import cn.i7baoz.blog.shiroweb.pojo.BaseBean;

import com.alibaba.fastjson.JSON;

public class Pojo2JSONStringUtil {

	public static String toJSONString(BaseBean  pojo) {
		String jsonStr = null;
		try {
			jsonStr = String.valueOf(JSON.toJSON(pojo));
		} catch (Exception e) {
			throw new TraditionException(SystemMessageEnum.POJO_TO_JSON_STRING_WRONG);
		}
		return jsonStr;
	}
}

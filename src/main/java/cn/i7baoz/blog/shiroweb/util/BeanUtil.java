package cn.i7baoz.blog.shiroweb.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import cn.i7baoz.blog.shiroweb.enums.SystemMessageEnum;
import cn.i7baoz.blog.shiroweb.exception.TraditionException;
import com.alibaba.fastjson.JSON;

public class BeanUtil {

	public static String toJSONString(Serializable  pojo) {
		String jsonStr = null;
		try {
			jsonStr = String.valueOf(JSON.toJSON(pojo));
		} catch (Exception e) {
			throw new TraditionException(SystemMessageEnum.POJO_TO_JSON_STRING_WRONG);
		}
		return jsonStr;
	}
	
	public static byte[] Object2Bytes (Object object) {
		byte[] b = null;
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(object);
			b = bo.toByteArray();
		} catch ( Exception e ) {
			throw new TraditionException(SystemMessageEnum.POJO_TO_JSON_STRING_WRONG);
		} finally {
			if ( null != bo ) {
				try {
					bo.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
			if ( null != oo ) {
				try {
					oo.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
		
		return b;
	}
	
	public static Object Bytes2Object(byte[] bs) {
		Object obj = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			bi = new ByteArrayInputStream(bs);
			oi = new ObjectInputStream(bi);
			obj = oi.readObject();
		} catch ( Exception e ) {
			throw new TraditionException(SystemMessageEnum.POJO_TO_JSON_STRING_WRONG);
		} finally {
			if ( null != bi ) {
				try {
					bi.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
			if ( null != oi ) {
				try {
					oi.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
		
		return obj;
	}
}

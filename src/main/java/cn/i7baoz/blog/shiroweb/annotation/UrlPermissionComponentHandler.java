/** 
 * Project Name:shiroWeb 
 * File Name:UrlPermissionComentHandler.java 
 * Package Name:cn.i7baoz.blog.shiroweb.annotation 
 * Date:2018年1月9日上午9:24:15 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.annotation;  

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import cn.i7baoz.blog.shiroweb.enums.CurrentStatusEnum;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.service.PermissionService;

/** 
 * ClassName:UrlPermissionComentHandler 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年1月9日 上午9:24:15 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class UrlPermissionComponentHandler extends RequestMappingHandlerMapping 
		implements ApplicationListener<ContextRefreshedEvent>{

	
	@Autowired
	PermissionService permissionService;
	
	private static List<PermissionBean> permissionBeanList = new ArrayList<PermissionBean>();
	
	@Override
	public Map<RequestMappingInfo, HandlerMethod> getHandlerMethods() {
		 Map<RequestMappingInfo, HandlerMethod> urlMethodMapping = super.getHandlerMethods();
		 
		 PermissionBean bean;
		 for(Map.Entry<RequestMappingInfo,HandlerMethod> entry : urlMethodMapping.entrySet()){

	            HandlerMethod handlerMethod = entry.getValue();
	            Method method = handlerMethod.getMethod();

	            if(!method.isAnnotationPresent(UrlPermissionComponent.class)){
	                continue;
	            }

	            UrlPermissionComponent urlPermissionComponent = method.getAnnotation(UrlPermissionComponent.class);
	            bean = new PermissionBean();
	            bean.setCurrentStatus(CurrentStatusEnum.NORMAL.getStatusCode());
	            bean.setCreateTime(new Timestamp(System.currentTimeMillis()));
	            bean.setPermission(urlPermissionComponent.url());
	            bean.setDescMsg(urlPermissionComponent.desc());
	            bean.setPermissionType(urlPermissionComponent.isView() ? 0 : 1);
	            bean.setIsMenu(urlPermissionComponent.isMenu());
	            bean.setBelong(urlPermissionComponent.belong());
	            bean.setSortNumber(urlPermissionComponent.sortNumber());
	            if (!permissionBeanList.contains(bean))
	            	permissionBeanList.add(bean);
	        }
		return urlMethodMapping;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		PermissionBean root = new PermissionBean();
		root.setBelong("");
		root.setCurrentStatus(CurrentStatusEnum.NORMAL.getStatusCode());
		root.setDescMsg("根目录");
		root.setIsMenu(false);
		root.setPermission("/");
		root.setPermissionType(0);
		root.setSortNumber(0);
		permissionBeanList.add(root);
		for ( PermissionBean bean : permissionBeanList) {
			permissionService.saveOrUpdate(bean);
		}
	}

}
 
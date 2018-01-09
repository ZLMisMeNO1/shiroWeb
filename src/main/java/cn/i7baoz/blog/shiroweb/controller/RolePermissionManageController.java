package cn.i7baoz.blog.shiroweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.i7baoz.blog.shiroweb.annotation.UrlPermissionComponent;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;
import cn.i7baoz.blog.shiroweb.service.PermissionService;

@Controller
@RequestMapping("permission")
public class RolePermissionManageController {

	@Autowired
	PermissionService permissionService;
	
	@RequestMapping("setting")
	@UrlPermissionComponent(isView=true,desc="角色设置权限",url="permission/setting")
	public ModelAndView premissionManage(String roleId) {
		ModelAndView m = new ModelAndView("permission/permissionManage");
		m.addObject("roleId", roleId);
		return m;
	}
	
	@RequestMapping("listAllPremissionInfo")
	@ResponseBody
	@UrlPermissionComponent(isView=false,desc="获取所有权限url",url="permission/listAllPremissionInfo")
	public List<PermissionBean> listAllPremissionInfo() {
		return permissionService.listAllPermission();
	}
}


$(function(){
	listMyRoles();
	listMyPerms();
})
function listMyRoles(){
	
	executeAjax("role/findRoleByUsername",{},function(data){
		var settings = {
				data : data,
				scrollbarSize : 5,
				singleSelect : false,
				columns : [ [ {
					field : 'roleId',
					title : 'roleId',
					width : 100,
					hidden : true
				}, {
					field : 'roleName',
					title : '角色名称',
					width : 100
				}, {
					field : 'createTime',
					title : '创建时间',
					width : 100,
					hidden : true
				}, {
					field : 'createUsername',
					title : '创建人',
					width : 100
				}, {
					field : 'descMsg',
					title : '备注信息',
					width : 100
				}, {
					field : 'currentStatus',
					title : '当前状态',
					width : 100
				} ] ]
			};
		initDataGrid("#roleList", settings);
	})
};
function listMyPerms(){
	executeAjax("user/findPermissionsByUsername",{
		data : {
		}
	},function(data){
		var settings = {
				data : data,
				scrollbarSize : 5,
				singleSelect : false,
				columns : [ [ {
					field : 'roleId',
					title : 'roleId',
					width : 100,
					hidden : true
				}, {
					field : 'permission',
					title : '权限名称',
					width : 100
				}, {
					field : 'createTime',
					title : '创建时间',
					width : 100,
					hidden : true
				}, {
					field : 'createUsername',
					title : '创建人',
					width : 100,
					hidden : true
				}, {
					field : 'descMsg',
					title : '描述',
					width : 100
				}, {
					field : 'currentStatus',
					title : '当前状态',
					width : 100
				} ] ]
			};
		initDataGrid("#permissionList", settings);
	})
};
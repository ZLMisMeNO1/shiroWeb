
$(function(){
		listAllRoles();
})
function listAllRoles() {
	executeAjax("role/listAllRoles",{},function(data){
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
					width : 100
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
//		$("#roleList").datagrid('loadData',data)
	})
}
function initDataGrid(id, set) {
	/* 初始化datagrid */
	var optionSet = {
		striped : true,
		fitColumns : true,
		rownumbers : true,
		// singleSelect: true,
		loadMsg : '加载中...',
		pagination : false,
		remoteSort : false,
		scrollbarSize : 6,
		fit : true
	}
	var option = $.extend({}, optionSet, set);
	$(id).datagrid(option);
}
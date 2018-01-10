
$(function(){
	listMyRoles();
	listMyPerms();
})
function listMyRoles(){
	
	executeAjax("user/listMyRoles",{},function(result){
		console.log(result)
		var settings = {
				scrollbarSize : 5,
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
					width : 100,
					formatter : function(value,row,index){
						if ( value == 0 ) {
							return '<button class="btn btn-info btn-sm" >正常</button> ';
						} else if ( value == 1 ) {
							return '<button class="btn btn-success btn-sm" >锁定 </button>';
						}
					}
				} ] ]
			};
		if(result.success) {
			settings.data = result.data;
		}
		initDataGrid("#roleList", settings);
	})
};
function listMyPerms(){
	executeAjax("user/listMyPermissions",{},function(result){
		console.log(result)
		var settings = {
				scrollbarSize : 5,
				columns : [ [ {
					field : 'roleId',
					title : 'roleId',
					width : 100,
					hidden : true
				}, {
					field : 'descMsg',
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
					field : 'permission',
					title : 'URL',
					width : 100
				}, {
					field : 'currentStatus',
					title : '当前状态',
					width : 100,
					formatter : function(value,row,index){
						if ( value == 0 ) {
							return '<button class="btn btn-info btn-sm" >正常</button> ';
						} else if ( value == 1 ) {
							return '<button class="btn btn-success btn-sm" >锁定 </button>';
						}
					}
				} ] ]
			};
		if(result.success) {
			settings.data = result.data;
		}
		initDataGrid("#permissionList", settings);
	})
};
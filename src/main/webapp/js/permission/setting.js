var currentRoleId ;
var havePermissionArrays = [];
$(function(){
	currentRoleId = $('#currentRoleId').val();
	//获取角色已拥有的权限
	listPermissionByRoleId(currentRoleId);
	listAllPermission();
});
function listPermissionByRoleId(currentRoleId) {
	
	executeAjax("role/findPermissionByRoleId",{
		data : {
			'roleId' : currentRoleId
		},
		async : false
	},function(data){
		console.log(data);
		havePermissionArrays = data;
	})
}
function listAllPermission() {
	executeAjax("permission/listAllPremissionInfo",{},function(data){
		var settings = {
				data : data,
				width : 800,
				height : 800,
//				scrollbarSize : 5,
				fitColumns : true,
				singleSelect : false,
				columns : [ [ {
					field : 'permsId',
					title : 'permsId',
					width : 100,
					hidden : true
				}, {
					field : 'descMsg',
					title : '权限名称',
					width : 100
				}, {
					field : 'createTime',
					title : '创建时间',
					width : 80,
					formatter : function(value,row,index) {
						return moment(value).format('YYYY-MM-DD HH:mm:ss')
					}
				}, {
					field : 'permission',
					title : 'url',
					width : 50
					
				}, {
					field : 'permissionType',
					title : '类型',
					width : 30,
					formatter : function(value,row,index){
						if(value == 0) {
							return '视图';
						}
						if (value == 1) {
							return '接口';
						}
					}
				}, {
					field : 'currentStatus',
					title : '状态',
					width : 50,
					formatter : function(value,row,index){
						if ( value == 0 ) {
							return '<button class="btn btn-info btn-sm" >正常</button> ';
						} else if ( value == 1 ) {
							return '<button class="btn btn-success btn-sm" >锁定 </button>';
						}
					}
				} ,{
					field : 'dsfa',
					title : '操作',
					width : 50,
					formatter : function(value,row,index){
						if ( havePermissionArrays.includes(row.permsId)) {
							return '<a class="btn btn-danger btn-sm premissionRemove" data-perm="'+row.permsId+'" >移除</a> '
						} else {
							return '<a class="btn btn-info btn-sm premissionAdd"  data-perm="'+row.permsId+'" >添加</a> '
						}
						
					}
				}] ],
				onLoadSuccess : function(data){
					//移除权限
					$("a.premissionRemove").on('click',function(){
						var permsId = $(this).data('perm');
						var that = $(this);
						executeAjax("role/uncorrelationPermissions",{data:{'roleId':currentRoleId,'permissionIds':[permsId]}},function(){
							that.removeClass('btn-danger').addClass('btn-info').html('添加');
						});
						
					});
					$("a.premissionAdd").on('click',function(){
						var permsId = $(this).data('perm');
						console.log(permsId,currentRoleId);
						var that = $(this);
						executeAjax("role/correlationPermissions",{data:{'roleId':currentRoleId,'permissionIds':[permsId]}},function(){
							that.removeClass('btn-info').addClass('btn-danger').html('移除');
						});
					});
				}
			};
		initDataGrid("#roleList", settings);
	})
}
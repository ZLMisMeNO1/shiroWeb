var currentUserId ;
var havePermissionArrays = [];
$(function(){
	currentUserId = $('#currentUserId').val();
	//获取角色已拥有的权限
	listRolesByUserId(currentUserId);
	listAllRoles();
});
function listRolesByUserId(currentUserId) {
	
	executeAjax("usermanage/findRoles",{
		data : {
			'userId' : currentUserId
		},
		async : false
	},function(result){
//		console.log(result);
		if(result.success) {
			havePermissionArrays = result.data;
		}
		console.log(havePermissionArrays);
		
	})
}
function listAllRoles() {
	executeAjax("usermanage/listAllRoles",{},function(result){
		var settings = {
				width : 800,
				height : 800,
//				scrollbarSize : 5,
				fitColumns : true,
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
					width : 80,
					formatter : function(value,row,index) {
						return moment(value).format('YYYY-MM-DD HH:mm:ss')
					}
				}, {
					field : 'createUsername',
					title : '创建人',
					width : 50
					
				}, {
					field : 'descMsg',
					title : '描述',
					width : 30
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
						console.log(row.roleId)
						console.log(havePermissionArrays.includes(row.roleId))
						if ( havePermissionArrays.includes(row.roleId)) {
							return '<a class="btn btn-danger btn-sm premissionRemove" data-roleid="'+row.roleId+'" >移除</a> '
						} else {
							return '<a class="btn btn-info btn-sm premissionAdd"  data-roleid="'+row.roleId+'" >添加</a> '
						}
						
					}
				}] ],
				onLoadSuccess : function(data){
					console.log(data)
					//移除权限
					$("a.premissionRemove").on('click',function(){
						var roleid = $(this).data('roleid');
						var that = $(this);
						executeAjax("usermanage/uncorrelationRoles",{data:{'userId':currentUserId,'roleIds':[roleid]}},function(){
							that.removeClass('btn-danger').addClass('btn-info').html('添加');
						});
						
					});
					$("a.premissionAdd").on('click',function(){
						var roleid = $(this).data('roleid');
//						console.log(permsId,currentRoleId);
						var that = $(this);
						executeAjax("usermanage/correlationRoles",{data:{'userId':currentUserId,'roleIds':[roleid]}},function(){
							that.removeClass('btn-info').addClass('btn-danger').html('移除');
						});
					});
				}
			};
		if(result.success) {
			settings.data = result.data;
		}
		initDataGrid("#roleList", settings);
	})
}

$(function(){
	listAllUser();
	
	$("#createUser").click(function(){
		layer.open({
			title : '添加新角色',
			content : "usermanage/addUser",
			type : 2,
			area : ['300px','250px'],
			shade : 0.2,
			end :function(){
				listAllUser();
			}
		})
	});
		
})
function listAllUser() {
	executeAjax("usermanage/listUser",{},function(result){
		var settings = {
				width : 800,
				height : 800,
//				scrollbarSize : 5,
				fitColumns : true,
				columns : [ [ {
					field : 'userId',
					title : 'userId',
					width : 100,
					hidden : true
				}, {
					field : 'username',
					title : '用户名称',
					width : 100
				}, {
					field : 'createTime',
					title : '创建时间',
					width : 100,
					formatter : function(value,row,index) {
						return moment(value).format('YYYY-MM-DD HH:mm:ss')
					}
				},
//				{
//					field : 'createUsername',
//					title : '创建人',
//					width : 50
//					
//				},
//				{
//					field : 'descMsg',
//					title : '备注信息',
//					width : 100
//				}, 
				{
					field : 'currentStatus',
					title : '当前状态',
					width : 50,
					formatter : function(value,row,index){
						if ( value == 0 ) {
							return '正常  <a class="btn btn-danger btn-sm" >停用<a> ';
						} 
						if ( value == 1 ) {
							return '锁定  <a class="btn btn-success btn-sm" >恢复<a> ';
						}
						
					}
				} ,{
					field : 'dsfa',
					title : '操作',
					width : 50,
					formatter : function(value,row,index){
						return '<a class="btn btn-success btn-sm premissionSetting" data-username="'+row.username+'" data-userid="'+row.userId+'" ">角色配置</a> '
					}
				}] ],
				onLoadSuccess : function(data){
//					console.log(data)
					$("a.premissionSetting").on('click',function(){
						var userid = $(this).data('userid');
						var username = $(this).data('username');
						layer.open({
							title : '['+username+']角色配置',
							type:2,
							area:['700px','700px'],
							content: 'usermanage/userRoleSetting?userId='+userid
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

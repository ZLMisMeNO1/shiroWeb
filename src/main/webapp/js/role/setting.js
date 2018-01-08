
$(function(){
		listAllRoles();
		
		$("#createUser").click(function(){
			layer.open({
				title : '添加新角色',
				content : "role/addRoleView",
				type : 2,
				area : ['300px','250px'],
				shade : 0.2
			})
		});
})
function listAllRoles() {
	executeAjax("role/listAllRoles",{},function(data){
		var settings = {
				data : data,
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
					width : 100,
					formatter : function(value,row,index) {
						return moment(value).format('YYYY-MM-DD HH:mm:ss')
					}
				}, {
					field : 'createUsername',
					title : '创建人',
					width : 50
					
				}, {
					field : 'descMsg',
					title : '备注信息',
					width : 100
				}, {
					field : 'currentStatus',
					title : '当前状态',
					width : 50
				} ,{
					field : 'dsfa',
					title : '操作',
					width : 50,
					formatter : function(value,row,index){
						console.log(value,index,row)
						if (row.currentStatus ) {
							return '<a class="btn btn-success btn-sm" >停用<a> '
						} else {
							return '<a class="btn btn-success btn-sm" >恢复<a> '
						}
						
					}
				}] ]
			};
		initDataGrid("#roleList", settings);
	})
}


/**
 * 执行一定规则下的ajax
 * 
 * @param url
 * @param method
 * @param func
 */
function executeAjax(url, setting, done, fail, always) {
	setting.url = url;
	setting.traditional = true;
	$.ajax(setting).done(function(result) {
		if (undefined != done) {
			done(result);
		}
	}).fail(function(e, textStatus) {
//		if (undefined != fail) {
//			fail(jqXHR, textStatus);
//		}
//		console.log(e,textStatus)
		if(e.responseJSON) {
			layer.alert(e.responseJSON.message, {icon: 2,title:'错误'});
		} else {
			layer.alert('未知错误',{icon: 2,title:'错误'});
		}
	}).always(function() {
		if (undefined != always) {
			always();
		}
	})

}
function initDataGrid(id, set) {
	/* 初始化datagrid */
	var optionSet = {
		striped : true,
		fitColumns : true,
		rownumbers : true,
		singleSelect: true,
		loadMsg : '加载中...',
		pagination : false,
		remoteSort : false,
//		scrollbarSize : 6,
		fit : true
	}
	var option = $.extend({}, optionSet, set);
	$(id).datagrid(option);
}
function initTreeGrid(id, set) {
	/* 初始化datagrid */
	var optionSet = {
		striped : true,
		fitColumns : true,
		rownumbers : true,
		singleSelect: true,
		loadMsg : '加载中...',
		pagination : false,
		remoteSort : false,
//		scrollbarSize : 6,
		fit : true
	}
	var option = $.extend({}, optionSet, set);
	$(id).treegrid(option);
}

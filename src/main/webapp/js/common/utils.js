
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
	}).fail(function(jqXHR, textStatus) {
		if (undefined != fail) {
			fail(jqXHR, textStatus);
		}
	}).always(function() {
		if (undefined != always) {
			always();
		}
	})

}


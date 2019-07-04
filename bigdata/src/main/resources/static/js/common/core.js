
function ajaxJson(url, data, callback, type) {
    var type = type || "post";//不传，默认get
    if (data == null || data == undefined) {
        data = {};
    }
    $.ajax({
        type: type,
        url: url,
        async: true,
        data: data,
        dataType: "json",   
        success: function (result) {         
            if (callback != null) {
                callback(result);
            } else {
                $.messageBox(result.message, "提示");
            }
        },
        complete: function () {

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $.messageBox($.getHttpError(XMLHttpRequest.status), "错误");
        }
    });

}

function ajaxPostJson(url, data, callback) {
    ajaxJson(url, data, callback, "post");
}



(function($) {
		var r20 = /%20/g,
			rbracket = /\[\]$/;

	/**
	 * Ajax加载html页面
	 * @param {Object} url 要加载的html页面的路径
	 * @param {Function<html,obj>} callback 回调函数，加载页面成功的回调函数。参数html：返回加载页面的html代码。
	 * @param {Object} complete 加载完成的回调函数
	 */
	$.fn.getAjaxHTML = function(url, callback, complete) {
		var $This = $(this);
		if($This.length <= 0) return;
		$.ajax({
			type: "get",
			async: true,
			url: url,
			data: {},
			dataType: "html",
			beforeSend: function() {
				// $This.progress();
			},
			success: function(result) {
				if(callback) callback(result, $This);
			},
			complete: function() {
				// $.unProgress();
				if(complete) complete($This);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				$.messageBox($.getHttpError(XMLHttpRequest.status), "错误提示");
			}
		});
	};
	
	
	
	

	})(jQuery)

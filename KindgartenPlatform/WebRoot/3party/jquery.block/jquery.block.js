(function(){
	$.block = function(){
		$.blockUI({
			message:  '<h4><img src="../images/108.gif"></img>请等待...</h4>',
		})
	};
	$.unblock = function(){
		$.unblockUI();
	};
})();
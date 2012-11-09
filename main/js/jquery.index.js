$(function($){
	$(function(){
	var
	$mid = $('#other_mid');
	$mid.find('li>a>span').bind('mouseover focusin',function(){
		$("#other_mid>ul>li").removeClass('selected');
		$("#other_mid>ul>li>div").hide();
		$(this).parent().parent().addClass('selected');
		$(this).parent().parent().find('div').show();
	});
	$("#other_mid li>a:first").click();
	});
})(jQuery);
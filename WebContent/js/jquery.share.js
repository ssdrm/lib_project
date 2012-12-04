$(function($){
	$(function(){
	var
	$bar = $('#navibar');/*메뉴*/

	/* 메뉴  */

	$bar.find('li').bind('mouseover focusin',function(){
		$("#navibar>ul>li").removeClass('selected');
		$("#navibar>ul>li>a>span").removeClass('selected');
		/*$("#navibar>ul>li>div").hide();*/
		$(this).addClass('selected');
		$(this).parent().parent().addClass('selected');
		$(this).parent().parent().find('div').show();
		$(this).addClass('selected').siblings().removeClass('selected');
	});
	$bar.find('li').bind('mouseout focusout',function(){
		$(this).removeClass('selected');
	});
	});
})(jQuery);
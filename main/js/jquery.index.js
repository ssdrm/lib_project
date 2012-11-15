$(function($){
	$(function(){
	var
	$mid = $('#other_mid'),/*공지사항*/
	$bar = $('#navibar'),/*메뉴*/
	$thema = $('#other_right');/*테마*/
	/*공지사항*/
	/* 초기 화면 */
	$("#other_mid>ul>li>div").hide();
	$mid.find('li:first>a>span').addClass('selected');
	$mid.find('li:first').addClass('selected');
	$mid.find('li:first div').show();
	/* 초기 화면 끝*/
	$mid.find('li>a>span').bind('mouseover focusin',function(){
		$("#other_mid>ul>li").removeClass('selected');
		$("#other_mid>ul>li>a>span").removeClass('selected');
		$("#other_mid>ul>li>div").hide();
		$(this).addClass('selected');
		$(this).parent().parent().addClass('selected');
		$(this).parent().parent().find('div').show();
	});
	/*공지사항 끝*/
	

	
	/* 테마 */
	/* 초기 화면 */
	$("#other_right>ul>li>div").hide();
	$thema.find('li:first>a>span').addClass('selected');
	$thema.find('li:first').addClass('selected');
	$thema.find('li:first div').show();
	/* 초기 화면 끝 */
	$thema.find('li>a>span').bind('mouseover focusin',function(){
		$("#other_right>ul>li").removeClass('selected');
		$("#other_right>ul>li>a>span").removeClass('selected');
		$("#other_right>ul>li>div").hide();
		$(this).addClass('selected');
		$(this).parent().parent().addClass('selected');
		$(this).parent().parent().find('div').show();
	});
	/* 테마끝 */
	
	
	
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
	/* 메뉴 끝 */
	$("#other_mid li>a:first").click();
	});
})(jQuery);
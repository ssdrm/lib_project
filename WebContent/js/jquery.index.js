$(function($){
	$(function(){
	var
	$mid = $('#other_mid'),/*공지사항*/
	//$bar = $('#navibar'),/*메뉴*/
	$thema = $('#other_right'),/*테마*/
	$banner = $('#other_left');/*배너*/

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
	
	/* 배너 시작*/

	$("#other_left>ul>li>div").hide();
	$banner.find('li:first>img').addClass('selected');
	$banner.find('li:first').addClass('selected');
	$banner.find('li:first>div').show();

	$banner.find('span>img').bind('mouseover focusin',function(){
		$("#other_left>ul>li").removeClass('selected');
		$("#other_left>ul>li>span>img").removeClass('selected');
		$("#other_left>ul>li>div").hide();
		$(this).addClass('selected');
		$(this).parent().parent().addClass('selected');
		$(this).parent().parent().find('div').show();
	});


	
	/* 메뉴  */
/*
	$bar.find('li').bind('mouseover focusin',function(){
		$("#navibar>ul>li").removeClass('selected');
		$("#navibar>ul>li>a>span").removeClass('selected');
		//$("#navibar>ul>li>div").hide();
		$(this).addClass('selected');
		$(this).parent().parent().addClass('selected');
		$(this).parent().parent().find('div').show();
		$(this).addClass('selected').siblings().removeClass('selected');
	});
	$bar.find('li').bind('mouseout focusout',function(){
		$(this).removeClass('selected');
	});
	// 메뉴 끝 */
	$("#other_mid li>a:first").click();
	
	});
})(jQuery);
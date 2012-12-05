/* buttons.js - 버튼 스크립트, 2012 © yamoo9.com
---------------------------------------------------------------- */
$(function() {

		$(".comment_hide").hide();
		$("tr.sample").hide();

		$(".coms").click(function() {
			$("tr.comment_hide").slideToggle()("slow");

		});
		$("tr.comment_in").hide();

		$(".butt1").click(function() {//서평 추가 버튼 누르면 
			$("tr.comment_hide").hide("slow");//서평 추가 목록 보기 사라지고 
			$("tr.comment_in").show()("slow");

		});
		$(".butt3").click(function() {
			$("tr.comment_in").hide("slow");

		});

		$('.add').click(function() {
			$("tr.comment_hide").hide("slow");//서평 추가 목록 보기 사라지고 
			$("tr.comment_in").show()("slow");

		});
	});(jQuery);
(function($){//자바스크립트 자가 실행 함수.
	$(function(){//jQuery Read()문.
		
		//대상참조
			//유저네비
		var
		$usernav = $('#usernav'),//usernav변수에 #usernav에서 찾은 jQuery객체를 참조.
		$usercur = $usernav.find('.focus'),//usercur변수에 $usernav에서 찾은 .focus객체를 참조.
		$usermove = $('<li class = "usermove"/>'),//usermove변수에 동적으로 생성한 <li class="usermove>를 참조.
		
			//관리자네비
		$adminnav = $('#adminnav'),//adminnav변수에 #adminnav에서 찾은 jQuery객체를 참조.
		$admincur = $adminnav.find('.focus'),//admincur변수에 $adminnav에서 찾은 .focus객체를 참조.
		$adminmove = $('<li class = "adminmove"/>');//adminmove변수에 동적으로 생성한 <li class="adminmove>를 참조.
		
		//옵션
		options = {
			gab : 20,//폭(높이)
			speed : 400,//애니메이션 이동 스피드
			easing : 'easeInOutElastic',//애니메이션 이동 방법
			reset : 2000//다시 돌아오는 시간
		};
		
		
		//css 및 조작
			//유저
		$usermove.css('position','relative');//usermove참조객체에 css()메서드를 사용하여 상대위치로 지정.
		
		$usernav.css('position','relative').find('a').css({//usernav내부에서 <a>를 찾아 스타일링
			position : 'relative',//상대위치로 지정.
			zIndex : 1//z축의 높이를 1로 지정 1이 아니면 0이므로 가려진다.
		});
		
		$usermove.css({//usermove참조 객체에 .css()메소드를 사용하여 스타일링
			position : 'absolute',//절대위치로 지정
			top : $usercur.position().top - (options.gab/2),//상단 위치를 usercur요소top위치로 설정. 상단위치값에 gab을 2로 나눈 값을 뺌
			left : $usercur.position().left,//왼쪽 위치를 usercur요소 left위치로 설정.
			width : $usercur.outerWidth(),//가로폭을 usercur요소 가로폭만큼 설정.
			height : $usercur.outerHeight() + options.gab,//세로폭을 usercur요소 세로폭만큼 설정. 높이 값에 gab을 더함.
			backgroundColor : '#eee' //배경색 설정.
		}).appendTo($usernav.find('ul')); //usernav에 ul을 찾아 맨뒤에 추가.
		
			//관리자
		$adminmove.css('position','relative');//adminmove참조객체에 css()메서드를 사용하여 상대위치로 지정.
		
		$adminnav.css('position','relative').find('a').css({//usernav내부에서 <a>를 찾아 스타일링
			position : 'relative',//상대위치로 지정.
			zIndex : 1//z축의 높이를 1로 지정 1이 아니면 0이므로 가려진다.
		});
		
		$adminmove.css({//adminmove참조 객체에 .css()메소드를 사용하여 스타일링
			position : 'absolute',//절대위치로 지정
			top : $admincur.position().top - (options.gab/2),//상단 위치를 admincur요소top위치로 설정.
			left : $admincur.position().left,//왼쪽 위치를 admincur요소 left위치로 설정.
			width : $admincur.outerWidth(),//가로폭을 admincur요소 가로폭만큼 설정.
			height : $admincur.outerHeight() + options.gab,//세로폭을 admincur요소 세로폭만큼 설정.
			backgroundColor : '#eee' //배경색 설정.
		}).appendTo($adminnav.find('ul')); //adminnav에 ul을 찾아 맨뒤에 추가.
		
		//이벤트 감지, 구현.
			//유저
		$usernav.find('li')//usernav에서 li를 찾음.
		.bind('mouseover focusin', function(){//마우스 오버, 포커스 인 상태 감지 연결(bind)
			$usermove.animate({//usermove에 애니메이션을 설정
				left : $(this).position().left,//usermove 왼쪽 위치를 마우스 포인터를 올려놓은 li의 왼쪽위치로 옮김
				width : $(this).outerWidth()//usermove 의 가로 폭을 마우스 포인터를 올려놓은 li의 가로 폭으로 바꿈
			},{
				duration : 400,//애니메이션의 지속 시간을 400ms(0.4초)로 설정
				easing : options.easing,//애니메이션 이징 곡선을 탄력 움직임으로 설정
				queue : false//애니메이션 큐 설정 값을 false
			});
		})
		.bind('mouseout focusout', function(){//마우스 아웃, 포커스 아웃 상태 감지 연결(bind)
			setTimeout(function(){//setTimeout()을 설정. (지정한 시간후에 뭔가를 할수있다.)
				$usermove.animate({//지정한 시간이 지나면 usermove에 애니메이션을 설정.
					left : $usercur.position().left,//usermove의 왼쪽 위치를 usercur왼쪽 위치로 이동.
					width : $usercur.outerWidth()//usermove의 가로 폭을 usercur의 가로폭으로 변경.
				}, options.speed);//setTimeout()의 시간을 설정, 밀리초단위
			}, options.reset);//애니메이션 duration(옵션객체(setTimeout의))시간을 설정.
		});
			//관리자
		$adminnav.find('li')//usernav에서 li를 찾음.
		.bind('mouseover focusin', function(){//마우스 오버, 포커스 인 상태 감지 연결(bind)
			$adminmove.animate({//usermove에 애니메이션을 설정
				left : $(this).position().left,//usermove 왼쪽 위치를 마우스 포인터를 올려놓은 li의 왼쪽위치로 옮김
				width : $(this).outerWidth()//usermove 의 가로 폭을 마우스 포인터를 올려놓은 li의 가로 폭으로 바꿈
			},{
				duration : 400,//애니메이션의 지속 시간을 400ms(0.4초)로 설정
				easing : options.easing,//애니메이션 이징 곡선을 탄력 움직임으로 설정
				queue : false//애니메이션 큐 설정 값을 false
			});
		})
		.bind('mouseout focusout', function(){//마우스 아웃, 포커스 아웃 상태 감지 연결(bind)
			setTimeout(function(){//setTimeout()을 설정. (지정한 시간후에 뭔가를 할수있다.)
				$adminmove.animate({//지정한 시간이 지나면 adminmove에 애니메이션을 설정.
					left : $admincur.position().left,//adminmove의 왼쪽 위치를 admincur왼쪽 위치로 이동.
					width : $admincur.outerWidth()//adminmove의 가로 폭을 admincur의 가로폭으로 변경.
				}, options.speed);//setTimeout()의 시간을 설정, 밀리초단위
			}, options.reset);//애니메이션 duration(옵션객체(setTimeout의))시간을 설정.
		});
		
	});
})(jQuery);
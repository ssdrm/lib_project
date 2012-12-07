<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>도서예약 안내</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="css/set.css" rel="stylesheet" type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>

<body>
	<div id="wrap">
	
	<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "reserve_intro.jsp"/>
	</jsp:include>
		
	<div id="box">	
		<DIV class="guidemsg">
			<P class="guidetit">
				<IMG
					alt="대출을 희망하는 도서가 모두 ‘대출중’인 경우, 해당 자료를 예약하여 자료가 반납되는 즉시 우선적으로 대출할 수 있도록 하는 서비스입니다."
					src="img/guidmsg3.gif">
			</P>
			<P class="guideimg" align="right">
				<IMG alt="도서예약 안내(그림)" src="img/guidmsg3_img.gif"></a>
			</P>
		</DIV>
		<H4 class="h4_type2" align="right">
			<a href="borrows.jsp"><IMG alt="대출현황 조회/연장 바로가기"
				src="img/btn_service3.gif"></a>
		</H4>
		<H4 class="h4_type2">
			<IMG alt="이용범위" src="img/service_tit4.gif">
		</H4>
		<OL class="guidetext">
			<LI>예약하고자 하는 도서의 상태가 대출중인 경우</LI>
			<LI>예약대기자 수가 2명 이하일 때 예약가능</LI>
			<LI>예약가능 수량 - 2권</LI>
		</OL>
		<H4 class="h4_type2">
			<IMG alt="이용방법" src="img/service_tit1.gif">
		</H4>
		<P>
			<IMG alt="이용방법" src="img/flow_book.gif">
		</P>
		<H4 class="h4_type2">
			<IMG alt="유의사항" src="img/service_tit2.gif">
		</H4>
		<OL class="guidetext">
			<LI>예약된 도서는 예약되는 시점부터 기존대출자는 연장불가</LI>
			<LI>대출가능한 동일 도서(복본)가 있는 경우는 도서 예약을 하실 수 없습니다.</LI>
		</OL>
	</div>
</div>
</div>
</body>

</html>
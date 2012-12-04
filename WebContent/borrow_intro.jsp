<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">

<title>대출현황 조회/연장 안내페이지</title>

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/set.css" rel="stylesheet" type="text/css"> 
<meta http-equiv="content-type" content="text/html charset=utf-8">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>

<body>
	<div id="wrap">
	
	<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
	</jsp:include>
		<div id="box">
		<H4 class="h4_type2">&nbsp;</H4>
		<H4 class="h4_type2">
			<H4 class="h4_type2" align="left">
				<IMG alt="이용안내" src="img/service_tit5.gif">
			</H4>
			<H4 class="h4_type2" align="right">
				<A href="borrows.jsp"><IMG alt="대출현황 조회/연장 바로가기"
					src="img/btn_service2.gif"></A>
			</H4>
		</H4>
		<OL class="guidetext">
			<LI class="nonum"><font face="HY견고딕">대출된 자료는 1회로 한하여 그
					기간을 연장할 수 있으며, 연장기간은 최초 대출기간의 1/2로 합니다.</font></LI>
			<LI class="nonum"><font face="HY견고딕">대출연장은 반납기한 전에 하여야
					하며, 연체 시 대출연장은 불가능합니다.</font></LI>
		</OL>
	</div>
</div>
</body>

</html>

﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>자료구입신청/조회 안내페이지</title>
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
			<jsp:param name="Aurl" value = "data_intro.jsp"/>
		</jsp:include>
		
	<div id="box">	
        <p>&nbsp;</p>
        <p align="right">
            <a href="data_application.jsp"><IMG alt="자료구입신청/조회 바로가기"
                src="img/btn_service1.gif"></a>
        </p>
        <p align="left">
            <IMG alt="이용방법" src="img/service_tit1.gif">
        </p>
        <OL class="guidetext">
            <li>신청자료의 서지사항(서명, 저자, 출판사)을 정확히 입력한 후, ‘신청’을 클릭하시면 희망자료 신청이
                완료됩니다.</li>
                <LI>희망도서 신청 제한
                <UL class="guidetext_2depth">
                    <LI>① 신청대상 : 모든 교내 이용자</LI>
                    <LI>② 신청 제한 자료 </LI>- 대학도서관에 적합하지 않은 도서(구입이 불가능한 자료 참조) <BR>
                 </UL>       
        </OL>
        <H4 class="h4_type2">
            <IMG alt="유의사항" src="img/service_tit2.gif">
        </H4>
        <OL class="guidetext">
            <LI class="nonum">이미 소장중이거나 주문중인 경우 신청이 취소될 수 있습니다.<BR>
            <SPAN class="ft_bule">※ 구입이 불가능한 자료 </SPAN><BR>① 기소장자료(소장복본) :
                도서관에 이미 있는 자료를 신청하거나 없을 거라 예측하고 신청한 경우 <BR>② 주문중 자료(처리중복본) : 이미
                신청된 자료이거나 주문 또는 처리중인 도서 <BR>③ 서지사항 부정확 : 구입에 필요한 기본적인 정보를 기입하지
                않았거나 잘못된 정보를 기입하였을 경우<BR>④ 만화책 : 학술적인 용도로 구입하는 경우 이외의 만화책 <BR>⑤
                아동도서 및 초중고생 자료 : 학 적인 목적이 확인되지 않는 유아/초등/중등 수준의 자료 <BR>⑥ 무협소설 및
                판타지 소설
            </LI>
        </OL>
        <p>&nbsp;</p>
    </div>
</div>
</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>자연캠퍼스</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/intro.css" rel="stylesheet" type="text/css">
<meta http-equiv="content-type" content="text/html; charset=utf-8"></head>
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">
<div id="wrap">

	<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "come2.jsp"/>
	</jsp:include>
<div id="box">		
<p align="center"><A href="come1.jsp"><IMG alt="찾아오시는 길" src="img/tab6_1.gif"></A><A href="come2.jsp"><IMG alt="캠퍼스 소개" src="img/tab6_2.gif"></A></p>
<p align="center"><font color="#0070C0"><b>자연캠퍼스</b></font></p>
<p align="center"><IMG alt="자연캠퍼스" src="img/Ycampus.gif"></p>
</div>
</div>
</body>

</html>
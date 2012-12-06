
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html>
<html lang="ko">
<meta charset="utf-8">
<title>개인연락사항</title>
<head>


<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">  
<link href="css/submitted.css"rel="stylesheet"type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>
<div id="wrap">
	<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "submitted_data.jsp"/>
	</jsp:include>
	<table class="box">
		<tr>
		<th>
			도서명
		</th>
		<th>
		저자
		</th>
		<th>
		출판사
		</th>
		<th>
		신청사유
		</th>
		<th id="butt">
		Option
				</th>
	</tr>
	<tr>
	
		<td>
			알고리즘 
		</td>
	<td>
	이충기
	</td>
	<td>
	충기형아출판사
	</td>
	<td>
	어쩌구 저쩌구~~어쩌구 저쩌구~~어쩌구 저쩌구~~어쩌구 저쩌구~~어쩌구 저쩌구~~어쩌구 저쩌구~~어쩌구 저쩌구~~어쩌구 저쩌구~~어쩌구 저쩌구~~
	</td>
	
	<td id="butt">
	
	<a href="">삭제</a>
	
	</td>
	
	
</tr>


	</table>

	</div>
<body>

</body>

</html>
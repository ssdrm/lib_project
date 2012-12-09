<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>대출</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/search_resul.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/comment.js"></script>
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>

<body>
	<div id="wrap">
			<div class="title">대출조회 </div>
			<div class="title2"><a href="LibPServlet">메인으로가기</a><br><a href="borrow_in.jsp">대출하기 </a><br><a href="borrow_out.jsp">반납하기 </a></div>
	<div id="rebox">
	<form action="LibPServlet" method="post">
			<input type="text" class="typetext" id="searchbar" name="searchbar">
				<input type="image" id="s"	src="img/btn_msearch.gif" value="">
				<input type="hidden" name="op" value="Sbor">
	</form>

		</div>
		<table style="float:left;">
			<tr>
				<th>번호</th>
				<th>아이디 </th>

				<th>도서명</th>
				<th>대출일자 </th>
				<th>반납일자 </th>

				<th>연장횟수 </th>

			</tr>
			<c:forEach var="borr" items="${bookborrow.list }">
			<tr>
				<td><c:out value="${borr.bw_number }"/></td>

				<td><c:out value="${borr.id }"/></td>
				<td><c:out value="${borr.b_name }"/></td>
				<td><c:out value="${borr.borrowdate }"/></td>
				<td><c:out value="${borr.returndate }"/></td>
				<td><c:out value="${borr.extendate }"/></td>

			</tr>
			</c:forEach>
	
</table>
</div>
</body>
</html>
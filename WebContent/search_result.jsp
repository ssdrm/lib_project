<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>검색결과</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/search_resul.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
<script src="js/comment.js"></script>


</head>

<body>

	<div id="wrap">

	<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "search_result.jsp"/>
	</jsp:include>

		<div class="title">검색결과</div>
		<div id="rebox">
			<form id="searchForm" action="LibPServlet" method="POST">
			<input type="text" class="typetext" id="searchbar" name="searchbar">
			<input type="hidden" name="op" value="serch">
			<input type="image" alt="검색" src="img/btn_msearch.gif" value="">
			</form>


		</div>



		<table>
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>소장위치</th>
				<th>isbn</th>
				<th>도서상태</th>
				<th>예약</th>
			</tr>
			<c:forEach var = "books" items="${Serbook.list }">
				<tr>
					<td><c:out value = "${books.b_number }"/></td>
					<td class="img"><img src="bookkimages/${books.isbn }.jpg"></td>
					<td><c:out value = "${books.b_name }"/></td>
					<td><c:out value = "${books.writer }"/></td>
					<td><c:out value = "${books.maker }"/></td>
					<td><c:out value = "${books.location }"/></td>
					<td><c:out value = "${books.isbn }"/></td>
					<td>fff</td>
					<td style="width: 100px;"><input type="button" value="예약하기"
						id="reser"><br> <input type="button" value="서평보기 "
						class="coms"></td>
				</tr>
				<tr class="comment_hide">
				<th>남긴이</th>
				<th>내 용</th>
				<th> 추가</th>
			</tr>
			<tr class="comment_hide">
				<td>ㅇㅇ </td>
				<td>서평이러쿵 저러쿵 저쿵ㄹ</td>
				<td><input type="button" value="서평 추가 " class="add"></td>
			</tr>
			<tr class="comment_in">
				<td class="comment">서평 추가</td>
				<td class="sub_size"><input type="text" class="text"><input
					type="button" value="+" class="butt"> <input type="button"
					value="-" class="butt3"></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
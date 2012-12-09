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
			<input id="s" type="image" alt="검색" src="img/btn_msearch.gif" value="">
			</form>


		</div>



		<table>
			<tr>
				<th style="width:30px;">번호</th>
				<th style="width:120px;">이미지</th>
				<th style="width:150px;">도서명</th>
				<th style="width:130px;">저자</th>
				<th>출판사</th>
				<th>소장위치</th>
				<th>isbn</th>
				<th>도서상태</th>
				<th>서평 </th>
			</tr>
			<c:forEach var = "books" items="${Serbook.list }">
				<tr>
					<td style="text-align:center;"><c:out value = "${books.b_number }"/></td>
					<td class="img"><img src="bookkimages/${books.isbn }.jpg"></td>
					<td><c:out value = "${books.b_name }"/></td>
					<td><c:out value = "${books.writer }"/></td>
					<td><c:out value = "${books.maker }"/></td>
					<td><c:out value = "${books.location }"/></td>
					<td><c:out value = "${books.isbn }"/></td>
					<td>
					<c:set var = "count" value="0"/>
					<c:forEach var = "br" items="${bookborrow.list }">
					<c:choose>
					<c:when test="${books.b_number == br.b_number }">
					<c:set var = "count" value="1"/>
					</c:when>
					<c:otherwise>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					<c:choose>
					<c:when test="${count==1 }">
					대출중
					</c:when>
					<c:otherwise>
					대출가능
					</c:otherwise>
					</c:choose>
					</td>
					<td><a href="LibPServlet?op=commen&b_number=${books.b_number }">
					서평보기
					</a></td>
				</tr>
				<tr class="comment_hide">
				<th>남긴이</th>
				<th>내 용</th>
				<th> 추가</th>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
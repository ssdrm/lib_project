<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>대출 </title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/search_resul.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/comment.js"></script>
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>

<body>
	<div id="wrap">
			<div class="title">대출하기</div>
			
			<div class="title2"><a href="LibPServlet">메인으로가기</a><br><a href="borrow_manage.jsp">대출조회 </a><br><a href="borrow_out.jsp">반납하기 </a></div>
	<div id="rebox">
			<form action="LibPServlet" method="post">
			<input type="text" class="typetext" id="searchbar" name="searchbar">
				<input type="image" id="s"	src="img/btn_msearch.gif" value="">
				<input type="hidden" name="op" value="SIbor">
	</form>


		</div>

		
		<table>
			<tr>
				<th class="sub_title">번호</th>
				<th>도서명</th>
				<th>ISBN</th>
				<th style="width: 140px;"  >대출 </th>
			</tr>
			<c:forEach var="bo" items="${bookborrow.list }">
			<tr>
				<td class="sub_title2"><c:out value="${ bo.b_number}"/></td>
				<td class="sub_title2"><c:out value="${ bo.b_name}"/></td>
				<td class="sub_title2"><c:out value="${ bo.isbn}"/></td>
				<td class="sub_title2"><form action="LibPServlet" method="post">ID : <input type="text" size="10" name="id" >
					<input type="hidden" name="b_number" value="${bo.b_number }">
				 <input type="submit" value="대출등록" name="" >
				 <input type="hidden" name="op" value="addbor">
				 </form>
				 </td>
			</tr>
			</c:forEach>
	
</table>

</div>
</body>
</html>
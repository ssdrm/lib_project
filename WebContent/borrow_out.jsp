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
			<div class="title">반납 업무 </div>
		
			<div class="title2"><a href="LibPServlet">메인으로가기</a><br><a href="borrow_manage.jsp">대출 조회 </a><br><a href="borrow_in.jsp">대출 하기 </a></div>
	<div id="rebox">
			<form action="LibPServlet" method="post">
			<input type="text" class="typetext" id="searchbar" name="searchbar">
				<input type="image" id="s"	src="img/btn_msearch.gif" value="">
				<input type="hidden" name="op" value="SObor">
	</form>


		</div>


		<table>
			<tr>
				<th style="width:50px;">번호</th>
				<th>아이디 </th>

				<th style="width:150px;">도서명</th>
				<th>대출일자 </th>
				<th>반납 </th>

			</tr>
			<c:forEach var="bo" items="${bookborrow.list }">
			<tr>
				<td class="sub_title3"><c:out value="${ bo.bw_number}"/></td>

				<td class="sub_title3"><c:out value="${ bo.id}"/></td>


				<td class="sub_title3"><c:out value="${ bo.b_name}"/></td>
				<td class="sub_title3"><c:out value="${ bo.borrowdate}"/></td>
			
				<td class="sub_title3">

				 <a href="LibPServlet?op=retubor&bw_number=${bo.bw_number }" >반납처리 </a>
				 </td>

			</tr>
			</c:forEach>
	
</table>

</div>
</body>
</html>
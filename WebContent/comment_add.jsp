<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>검색결과</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/search_resul2.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/comment.js"></script>
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>

<body>

	<div id="wrap">
		<jsp:include page="share/navi.jsp">
			<jsp:param name="Aurl" value = "search_result.jsp"/>
		</jsp:include>


		<div class="title">서평보기/추가<c:out value="${sbook }"/> </div>
		<form action="LibPServlet" method="post">
			<table>
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>소장위치</th>
				<th>isbn</th>
			</tr>
			<tr>
				<td><c:out value = "${Serbook.b_number }"/></td>
				<td class="img"><img src="bookkimages/${Serbook.isbn }.jpg"></td>
				<td><c:out value = "${Serbook.b_name }"/></td>
				<td><c:out value = "${Serbook.writer }"/></td>
				<td><c:out value = "${Serbook.maker }"/></td>
				<td><c:out value = "${Serbook.location }"/></td>
				<td><c:out value = "${Serbook.isbn }"/></td>
				

			</tr>
			<tr>
				<th colspan="8" style="height:20px; ">서평 보기 </th>

			</tr>
			<c:forEach var="co" items="${comment.list }">
			<tr>
				<td colspan="8" class="comment2"><div class="sub2">작성자아이디 : <c:out value="${co.id }"/> |작성내용 : <c:out value="${co.co_comment }"/>|작성일자 : <c:out value="${co.co_date }"/>
				</div>
			</td>
			</tr>
			</c:forEach>
			<c:if test ="${user != NULL && admintype != 'O' }">
					<tr >
						<th colspan="8"style="height:20px; ">서평 추가</th>
					</tr>
						<tr >

						<td colspan="8" class="comment"> <div class="sub2">작성내용 :&nbsp;&nbsp;&nbsp;<input type="text" size="80" name="co_comment">
							<input type="submit" value="서평 추가 "></div></td>
					</tr>
					</c:if>
				</table>
				<input type="hidden" name="b_number" value="${Serbook.b_number }">
				<input type="hidden" name="id" value="${user }">
						<input type="hidden" name="op" value="addcom">
			</form>
			</div>
		</body>
</html>

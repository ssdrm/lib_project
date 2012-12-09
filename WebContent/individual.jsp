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
<link href="css/individual.css"rel="stylesheet"type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>
<body>
<div id="wrap">
	<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "individual.jsp"/>
	</jsp:include>
	<c:choose>
	<c:when test="${user != NULL }">
	<table class="box">
		<tr>
		<th>
			개인연락사항 
		</th>
	</tr>
	<c:forEach var="ff" items="${bookborrow.list }">

			<c:choose>
			<c:when test="${ff.returndate != NULL }">
				<tr>
					<td>
						<c:out value="${ff.b_name }"/>도서가 반납되었습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>
						<c:out value="${ff.b_name }"/>도서를 대출하셨습니다.
					</td>
				</tr>
			</c:otherwise>
			</c:choose>

			<c:choose>
			<c:when test="${ff.extendate == 1 }">
				<tr>
					<td>
			<c:out value="${ff.b_name }"/>도서를 연장하셨습니다.
					</td>
				</tr>
			</c:when>
			</c:choose>
			<c:choose>
			<c:when test="${ff.extendate == 1 && ff.returndate == NULL}">
				<tr>
					<td>
						<c:out value="${ff.b_name }"/>도서의 반납예정일은 <c:out value="${ff.borrdate }"/>입니다.
					</td>
				</tr>
			</c:when>
			<c:when test="${ff.extendate == 0 && ff.returndate == NULL}">
			<tr>
					<td>
						<c:out value="${ff.b_name }"/>도서의 반납예정일은 <c:out value="${ff.bordate }"/> 입니다.
					</td>
				</tr>
			</c:when>
			</c:choose>
	</c:forEach>
	<c:forEach var="fff" items="${imports.list }">
	<tr>
		<td>
			<c:out value="${fff.bookname }"/>도서를 신청하셨습니다. 현재상태는 <c:choose><c:when test="${fff.status == 'B' }">처리 </c:when><c:when test="${fff.status == 'C' }">거부</c:when><c:when test="${fff.status == 'E' }">구입완료</c:when></c:choose>상태입니다.
		</td>
	</tr>
	</c:forEach>


	</table>
	</c:when>
	<c:otherwise>
	로그인을 하셔야 이용할 수 있습니다.<br>
	<a href="LibPServlet">메인으로</a>
	</c:otherwise>
	</c:choose>
	</div>


</body>

</html>
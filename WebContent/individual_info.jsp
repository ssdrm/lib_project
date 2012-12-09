
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<meta charset="utf-8">
<title>개인정보관리 </title>
<head>





<link href = "css/reset.css" rel = "stylesheet" type = "text/css">
<link href = "css/reset2.css" rel="stylesheet" type = "text/css">
<link href="css/info.css"rel="stylesheet"type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>



</head>
<body>
	<div id="wrap">
		<jsp:include page="share/navi.jsp">
			<jsp:param name="Aurl" value = "individual_info.jsp"/>
		</jsp:include>
		<c:choose>
		<c:when test="${user != NULL }">
		<form action="LibPServlet" method="post">
		<table>
			<tr>
				<td colspan="2" class="title">개인정보관리</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><c:out value="${name }"/> </td>
			</tr>
			<tr>
				<td>학번</td>
				
				<td><c:out value="${user }"/><input type="hidden" name="id" value="${user }"></td>
			</tr>
			
			<tr>
				<td>휴대전화</td>
				<td><input type="text" class="box" name="phone" value="${chuser.phone }"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" class="box" name="mail" value="${chuser.email }">
				<input type="submit" value="작성완료">
				<input type="hidden" name="op" value="chuse">
				</td>
			</tr>
		</table>
	</form>
	</c:when>
	<c:otherwise>
	로그인을 하셔야 이용할 수 있습니다.<br>
	<a href="LibPServlet">메인으로</a>
	</c:otherwise>
	</c:choose>
</div>
</body>
	</html>
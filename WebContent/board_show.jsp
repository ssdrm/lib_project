<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  import="java.sql.*" 
    import="org.apache.commons.lang3.StringUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/board.css" rel="stylesheet" type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
<title>게시판</title>
</head>
<body>
<div id="wrap">
	<jsp:include page="share/navi.jsp">
		<jsp:param name="" value=""/>
	</jsp:include>
		
<table>
	<tr>
		<th>글번호</th>
		<td><c:out value = "${boards.bdnumber }"/></td>
	</tr>
	<tr>
		<th>작성자	</th>
		<td><c:out value = "${boards.id }"/></td>
	</tr>
	<tr>
		<th>제목	</th>
		<td><c:out value = "${boards.title }"/></td>
	</tr>
	<tr>
		<th>글 내용</th>
		<td><c:out value = "${boards.bdcomment }"/></td>
	</tr>
	<tr>
		<th>글쓴시간</th>
		<td><c:out value = "${boards.bd_date }"/></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><c:out value = "${boards.hits }"/></td>
	</tr>
</table>
<a href="BoardServlet?op=update&number=${fbn.number }">수정하기</a>
<a href="BoardServlet?op=delete&number=${fbn.number }">삭제하기</a>
<br><br>
</div>
</body>
</html>
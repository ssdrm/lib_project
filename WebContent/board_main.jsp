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
<link href="css/board1.css" rel="stylesheet" type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
<title>게시판</title>
</head>
<body>
<div id="wrap">
	<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "board_main.jsp"/>
	</jsp:include>
<table>
<tr>
<th>글번호</th>
<th>작성자</th>
<th>제목</th>
<th>날짜</th>
<th>조회수</th>
</tr>
<c:forEach var ="board" items="${boards.list }">
<tr>
<td><c:out value = "${board.bdnumber }"/></td>
<td><c:out value = "${board.id }"/></td>
<td><a href = "LibPServlet?op=boardshow&bdnumber=${board.bdnumber }"><c:out value = "${board.title }"/></a></td>
<td><c:out value = "${board.bd_date }"/></td>
<td><c:out value = "${board.hits }"/></td>
<td><a href = "BoardServlet?op=update&number=${queryed.number }">수정</a></td>
<td><a href = "BoardServlet?op=delete&number=${queryed.number }">삭제</a></td>
</tr>
</c:forEach>

</table>
<c:forEach var ="board" items="${boards.list }" begin="0" end="0">
<jsp:include page="share/page.jsp">
	<jsp:param name="currentPage" value = "${boards.page }"/>
	<jsp:param name="url" value = "LibPServlet"/>
	<jsp:param name="startPage" value = "${boards.startPageNo }"/>
	<jsp:param name="endPage" value = "${boards.endPageNo }"/>
	<jsp:param name="numPages" value = "${boards.numPages }"/>
	<jsp:param name="op" value = "board"/>
	<jsp:param name="option" value = "btype"/>
	<jsp:param name="optionvalue" value="${board.bdtype }"/>
</jsp:include>
</c:forEach>
<br><br><br>
<a href="BoardServlet?op=write">글쓰기</a>
</div>
</body>
</html>
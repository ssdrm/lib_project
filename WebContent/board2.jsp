<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="css/reset.css">
<link type="text/css" rel="stylesheet" href="css/reset2.css">
<link type="text/css" rel="stylesheet" href="css/board2.css">
<link type="text/css" rel="stylesheet" href="css/share.css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
<title>게시판</title>
</head>
<body>
<div id="wrap">
<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
</jsp:include>
<div id="box">


<div id="title">공지사항
	</div>
<table>
	<tbody><tr>
		<th>글번호</th>
		<td>17</td>
	</tr>
	<tr>
		<th>작성자	</th>
		<td>99999999</td>
	</tr>
	<tr>
		<th>제목	</th>
		<td>공지테스트5</td>
	</tr>
	<tr>
		<th>글 내용</th>
		<td>테스트중입니다.</td>
	</tr>
	<tr>
		<th>글쓴시간</th>
		<td>2012-11-30 17:45:32.0</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>0</td>
	</tr>
</tbody>
</table>

<a class="sub" href="BoardServlet?op=update&amp;number=">수정하기</a>&nbsp;&nbsp;
<a class="sub" href="BoardServlet?op=delete&amp;number=">삭제하기</a>

<br><br>
</div>
</div>
</div>
</body>
</html>
	
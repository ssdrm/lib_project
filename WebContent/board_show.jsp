<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="java.sql.*"
	import="org.apache.commons.lang3.StringUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/board2.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
<title>게시판</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="share/navi.jsp">
			<jsp:param name="Aurl" value="board_show.jsp" />
		</jsp:include>

		<div id="box">

			<table>
				<tbody>
					<tr>
						<th>글번호 :<span><c:out value="${boards.bdnumber }" /></span></th>


						<th>작성자 :<span><c:out value="${boards.id }" /></span></th>


						<th style="width: 130px;">제목 :<span><c:out
									value="${boards.title }" /></span>
						</th>

						<th style="width: 120px;"><span><c:out
									value="${boards.bd_date }" /></span></th>

						<th style="width: 80px;">조회수 :<span><c:out
									value="${boards.hits }" /></span></th>

					</tr>
					<tr>
						<td colspan="5"><c:out value="${boards.bdcomment }" /></td>
					</tr>
				</tbody>
			</table>

			<a class="sub" href="BoardServlet?op=update&number=${fbn.number }">수정하기</a>&nbsp;&nbsp;
			<a class="sub" href="BoardServlet?op=delete&number=${fbn.number }">삭제하기</a>

			<br>
			<br>
		</div>
	</div>
</body>
</html>
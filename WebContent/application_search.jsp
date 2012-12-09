<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>대출현황 조회/연장</title>

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/set.css" rel="stylesheet" type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "search_result.jsp"/>
	</jsp:include>
		<div id="box">
			<table>
				<tr class="t123">
					<th>번 호 </th>
					<th> 아이디 </th>
					<th> 신청일자  </th>
						<th>도서명   </th>
							<th> 출판사 </th>
								<th>  저자 </th>
								<th>처리</th>
				</tr>
				<c:forEach var="im" items="${imports.list }">
				<tr>
					<td><c:out value="${im.im_number }"/></td>
					<td><c:out value="${im.id }"/></td>
					<td><c:out value="${im.importdate}"/></td>
					<td><c:out value="${im.bookname }"/></td>
					<td><c:out value="${im.bookwriter }"/></td>
					<td><c:out value="${im.bookmaker }"/></td>
					<td>
					<c:choose>
					<c:when test="${admintype == 'T' }">
					<c:choose>
					<c:when test="${im.status == 'B' }">
					<a href="LibPServlet?op=caimp&im_number=${im.im_number }">구입취소</a>
					<a href="LibPServlet?op=okimp&im_number=${im.im_number }">구입완료</a>
					</c:when>
					<c:when test="${im.status == 'C' }">
					<a href="LibPServlet?op=okimp&im_number=${im.im_number }">구입완료</a>(현재취소)
					</c:when>
					<c:when test="${im.status == 'E' }">
					<a href="LibPServlet?op=caimp&im_number=${im.im_number }">구입취소</a>(현재완료)
					</c:when>
					</c:choose>
					</c:when>
					<c:otherwise>
					<c:choose>
					<c:when test="${im.status == 'B' }">
					처리중
					</c:when>
					<c:when test="${im.status == 'C' }">
					거절
					</c:when>
					<c:when test="${im.status == 'E' }">
					구입완료
					</c:when>
					</c:choose>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
					<th class="t123"> 사유 </th>
					<td colspan="6"><c:out value="${im.reason }"/></td>
					
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

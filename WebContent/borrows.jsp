<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>대출현황 조회/연장</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/borrows_new.css" rel="stylesheet" type="text/css"> 
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
	<c:choose>
	<c:when test="${user != NULL }">
	<c:set var="all" value="0"/>
	<c:set var="c0" value="0"/>
	<c:set var="c1" value="0"/>
	<c:set var="c2" value="0"/>
	<c:set var="c3" value="0"/>
	<c:set var="c4" value="0"/>
	<c:set var="c5" value="0"/>
	<c:set var="c6" value="0"/>
	<c:set var="c7" value="0"/>
	<c:set var="c8" value="0"/>
	<c:set var="c9" value="0"/>
	<c:forEach var="b" items="${categorib.list }">
	<c:choose>
	<c:when test="${b.scategory=='총류' }">
	<c:set var="c0" value="${c0+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='철학' }">
	<c:set var="c1" value="${c1+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='종교' }">
	<c:set var="c2" value="${c2+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='사회과학' }">
	<c:set var="c3" value="${c3+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='어학'}">
	<c:set var="c4" value="${c4+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='자연과학' }">
	<c:set var="c5" value="${c5+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='응용과학' }">
	<c:set var="c6" value="${c6+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='예술' }">
	<c:set var="c7" value="${c7+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='문학' }">
	<c:set var="c8" value="${c8+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='역사' }">
	<c:set var="c9" value="${c9+b.category }"/>
	</c:when>
	<c:when test="${b.scategory=='총류' }">
	<c:set var="c0" value="${c0+b.category }"/>
	</c:when>
	</c:choose>
			<c:set var="all" value="${all+b.category }"/>
	</c:forEach>
		<div class="title">
			<div class="title1">
			대출 조회현황 / 연장 
		</div>
		<div class="title2">
			HOME- MYpage- 대출 조회/현황 
		 </div>
		</div>
		<div class="tablebox">
			<div class="titles">
			대출내역 
		</div>
			<table>
				<tr>
				<th>번호</th>
				<th>도서명</th>
				<th>대출일자</th>
				<th>반납예정일</th>
				<th>반납일</th>
				<th>연장</th>
				<th>연장하기</th>
						</tr>
						<c:forEach var="bb" items="${bookborrow.list }">
										<tr>
											<td><c:out value="${bb.bw_number }"/></td>
											<td><c:out value="${bb.b_name }"/></td>
											<td><c:out value="${bb.borrowdate }"/></td>
											<c:choose>
											<c:when test="${bb.extendate==0 }">
											<td><c:out value="${bb.bordate }"/></td>
											</c:when>
											<c:otherwise>
											<td><c:out value="${bb.borrdate }"/></td>
											</c:otherwise>
											</c:choose>
											<td><c:out value="${bb.returndate }"/></td>
											<td><c:out value="${bb.extendate }"/></td>
											<td>
											<c:choose>
											<c:when test="${bb.returndate == NULL && bb.extendate == 0 }">
											<a href="LibPServlet?op=exdel&bw_number=${bb.bw_number }&id=${user}">연장하기</a>
											</c:when>
											<c:otherwise></c:otherwise>
											</c:choose>
											</td>
										</tr>
									</c:forEach>
			</table>
			<div class="titles2">
			대출성향 
		</div>
		<table class="down">
			<tr>
				<th>총류 </th>
				<th>철학 </th>
				<th>종교 </th>
				<th class="t">사회과학 </th>
				<th>어학 </th>
				<th class="t">자연과학 </th>
				<th class="t">응용과학 </th>
				<th>예술 </th>
				<th>문학 </th>
				<th>역사 </th>
			</tr>
			<tr>
				<td><fmt:formatNumber value="${c0/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c1/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c2/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c3/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c4/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c5/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c6/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c7/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c8/all*100 }" type="number"/>%</td>
				<td><fmt:formatNumber value="${c9/all*100 }" type="number"/>%</td>
			</tr>
			</table>
			
		</div>
		</c:when>
	<c:otherwise>
	로그인을 하셔야 이용할 수 있습니다.<br>
	<a href="LibPServlet">메인으로</a>
	</c:otherwise>
	</c:choose>
		</div>
	</body>
	</html>
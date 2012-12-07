<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  import="java.sql.*" 
    import="org.apache.commons.lang3.StringUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원관리  </title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/sign_up_m.css" rel="stylesheet" type="text/css">


</head>
<div id="wrap">

	<div class="title">
		회원 관리 
	</div>
	<form action="#" method="post" >
		<table class="path1">
			<tr>
				<th>
					이름
				</th>
				<th>
					아이디 
				</th>
				<th >
					폰번호 
				</th>
				<th >
					이메일 
				</th>
				<th>
					승인 
				</th>

			</tr>
			<c:forEach var="us" items="${user.list }">
			<tr>
				<td>  <c:out value = "${us.name }"/>   </td>
				<td>	<c:out value = "${us.id }"/></td>
				<td><c:out value = "${us.phone }"/></td>
				<td> <c:out value = "${us.email }"/></td>
				<td>
				<c:choose>
				<c:when test="${us.admintype == 'F' }">
				<a href="LibPServlet?op=upuse&id=${us.id }">관리자 승인</a><br>
				<a href="LibPServlet?op=reuse&id=${us.id }">삭제</a>
				</c:when>
				<c:when test="${us.admintype == 'T' }">
				<a href="LibPServlet?op=douse&id=${us.id }">관리자 권한해제</a>
				<a href="LibPServlet?op=reuse&id=${us.id }">삭제</a>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
			
		</td>
		
				</tr>
				</c:forEach>
				<tr>
		<td colspan="5"><a href="index.jsp">메인으로 가기</a></td>
</tr>
			
			</table>
</form>


	</div>



</body>
</html>
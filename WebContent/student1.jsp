
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<meta charset="utf-8">
<title>학생 관리 </title>
<head>


<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/student_manage.css"rel="stylesheet"type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery.share.js"></script>

</head>

<div id="wrap">

	<div class="title">
		학생관리 
	</div>
	<form action="LibPServlet" method="post" >
	<input type="hidden" name="op" value="stucre">
		<table class="path1">
			<tr>
				<th>
					이름
				</th>
				<th>
					학번 
				</th>
				<th >
					학생 
				</th>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="id">	</td>
				<td><input type="submit" value="학생추가 "></td>
				</tr>
			
			</table>
</form>
<table class="path">
	<tr>
		<th>이름 </th>
		<th>학번 </th>
		<th>학생삭제</th>
	</tr>
	<c:forEach var = "st" items="${Student.list }">
	<tr>
		<td><c:out value = "${st.name }"/></td>
		<td><c:out value = "${st.id }"/></td>
		
		<td><a href="LibPServlet?op=restu&id=${st.id }">학생 삭제</a></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="3"><a href="index.jsp">메인으로 가기</a></td>
</tr>

</table>

	</div>



</body>
</html>
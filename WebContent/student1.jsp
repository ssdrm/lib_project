
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/student_manage.css"rel="stylesheet"type="text/css">


</head>

<div id="wrap">

	<div class="title">
		학생관리 
	</div>
	<form action="#" method="post" >
		<table class="path1">
			<tr>
				<th>
					이름
				</th>
				<th>
					학번 
				</th>
				<th class="w">
				</th>

			</tr>
			<tr>
				<td><input type="text"></td>
				<td><input type="text">	</td>
				<td><input type="button" value="추가 "></td>
				

				</tr>
			
			</table>
</form>
<table class="path">
	<tr>
		<th>이름 </th>
		<th>학번 </th>
		<th class="w"></th>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td><input type="button" value="삭제 "></td>
	</tr>
	<tr>
		<td colspan="3"><a href="LibPServlet">메인으로 가기</a></td>
	</tr>

</table>

	</div>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>대출현황 조회/연장</title>

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<meta http-equiv="content-type" content="text/html; charset=utf-8"> 
<link href="css/set.css" rel="stylesheet" type="text/css"> 
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>
<body>
	<div id="wrap">
	
			<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
		</jsp:include>
	
		<div id="title">
			<div id="title1">
			대출 조회현황 / 연장 
		</div>
		<div id="title2">
			HOME>MYpage>대출 조회/현황 
		 </div>

		</div>
		<div id="sub">
			<div id="sub1">&nbsp;&nbsp;대출/예약현황 
			</div>  
		
		</div>
	
		<div id="tablebox">
			<div id="titles">
			대출내역 
		</div>
	

			<table>
				<tr>
				<th><input type="checkbox">번호</th>

				<th>도서명</th>
				
				<th>대출일자</th>
				
				<th>반납예정일</th>
				
				<th>연장</th>
		
				<th>연체일</th>
		
			


						</tr>
										<tr id="t">

											<td><input type="checkbox">1</td>
											<td>2</td>
											<td>우리궁궐</td>
											<td>2012-02-02</td>
											<td>?</td>
											<td>fff</td>
											
						

										
										</tr>
									

			</table>
		</div>
	
		<div id="tablebox2">
		<div id="titles2">
			예약 현황 
		</div>

	<table>
		<tr>
			
			
				
				<th>예약 번호</th>
			
				
				<th>도서 번호 </th>
				
				<th>도서명 </th>
				
				<th>예약일자 </th>
				
				<th>예약취소 </th>

						</tr>
										<tr id="t">

											<td>11</td>
											<td>도서명 </td>
											<td>2012-02-02</td>
											<td>2012-02-02</td>
											<td>?</td>
									
											
						

										
										</tr>
									


	</table>
</div>


</div>

</body>
</html>
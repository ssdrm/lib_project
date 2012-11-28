<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>테마가있는 서재 </title>
<head>
<link href="css/theme_com.css" rel="stylesheet" type="text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery.share.js"></script>

</head>

<body>
	<div id="warp">
	
	<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
		</jsp:include>
		
		
		<div id="title1">
			<div id="layer1">
				테마가 있는 서재 
			</div>
			<div id="layer2">
				테마가 있는 서재 
			</div>

		</div>
<div id="title2">
	<div id="but">
	<div class="button">
		<div class="light"></div>
		<a href="search_theme_main.jsp">환경과 에너지</a>
	</div>
	<div class="button">
		<div class="light"></div>
		<a href="search_theme_human.jsp">인   물</a> 
	</div> 

	<div class="button">
		<div class="light"></div>
	<a href="search_theme_culture.jsp">우리 문화 알기 </a> 
	</div>
	<div class="button">
		<div class="light"></div>
		<a href="search_theme_computer.jsp">컴퓨터</a> 
	</div>

</div>
				
					
</div>
				<div id="tablebox">
					<table border="1">
						<tr>
							<th colspan="2">
								자료명/저자/출판년도 
							</th>
						</tr>
						<tr>
							<td id="td1">fjf</td>
							<td id="td2">fdf</td>
						</tr>
						<tr>
							<td id="td3">fdf</td>
							<td id="td4">fdf</td>
						</tr>
						<tr>
							<td id="td5">fd</td>
							<td id="td6">fd</td>
						</tr>
		

			</table>
		</div>
	</div>



		
	
</body>
</html>
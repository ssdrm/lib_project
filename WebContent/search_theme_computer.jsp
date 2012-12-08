<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>테마가있는서재  컴퓨터</title>
<head>
<link href="css/reset.css" rel="stylesheet" type="text/css">

<link href="css/theme_main.css" rel="stylesheet" type="text/css">
	
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>

</head>

<body>
	<div id="wrap">
	
	<jsp:include page="share/navi.jsp">
		<jsp:param name="Aurl" value = "search_theme_computer.jsp"/>
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
		<div class="light">
		<a href="search_theme_main.jsp">환경과 에너지</a>
	</div>
	</div>
	<div class="button">
		<div class="light">
		<a href="search_theme_human.jsp">인   물</a> 
	</div> 
	</div>

	<div class="button">
		<div class="light">
	<a href="search_theme_culture.jsp">우리 문화 알기 </a> 
	</div>
	</div>
	<div class="button">
		<div class="light">
		<a href="search_theme_computer.jsp">컴퓨터</a> 
	</div>
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
						<tr >
							<td class="td1"><img src="bookkimages/03019.jpg" class="t"></td>
							<td class="td2">
							<div class="sub1">한글 액세스와 매크로  </div> 
								<div class="sub2">김소윤 </div>
								<div class="sub3">  2003-01-01</div>
							</td>
						</tr>
						<tr>
							<td class="td1"><img src="bookkimages/03016.jpg" class="t"></td>
							<td class="td2">	<div class="sub1">3D MAX  </div> 
								<div class="sub2">현대건축디자인 학원 </div>
								<div class="sub3">  2009-01-01</div></td>
						</tr>
					
		

			</table>
		</div>
	</div>



		
	
</body>
</html>
	
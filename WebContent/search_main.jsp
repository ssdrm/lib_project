<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>통합검색</title>
<link href="css/main.css" rel="stylesheet" type="text/css"> 
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery.share.js"></script>

</head>

<body>
<div id="warp">
	
	<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
		</jsp:include>
		

	<div id="form">
	<span>통합검색</span>
			<div id="search">
				<ul>
					<li><a href="">&nbsp;&nbsp;&nbsp;키워드&nbsp;&nbsp;</a>
					</li> 
					<li><a href="">&nbsp;&nbsp;전방일치&nbsp;&nbsp;</a>
					</li> 
					<li><a href="">&nbsp;완전일치&nbsp; </a>
					</li>
				</div>
		<div id="box">
		<form action="#" method= "post">
		<table >
			
				<tr>
					<td>
						<select >				
								<option>서명
								<option>저자 
									<option>출판사 
										<option>ISBN
										</select>
											&nbsp;&nbsp;&nbsp;
										<input type=text size="70">
											&nbsp;&nbsp;&nbsp;
										<select>
											<option>and 
												<option>or
												</select>
									</td>
								</tr>
								<tr>
					<td>
						<select>
							<option>저자
								<option>서명  
									<option>출판사 
										<option>ISBN
										</select>
											&nbsp;&nbsp;&nbsp;
										<input type=text size="70">
											&nbsp;&nbsp;&nbsp;
										<select>
											<option>and 
												<option>or
												</select>
									</td>
								</tr>
								<tr>
					<td>
						<select >
							<option>출판사 
								<option>서명 
									<option>저자  
										<option>ISBN
										</select>
											&nbsp;&nbsp;&nbsp;
										<input type=text size="70">
											&nbsp;&nbsp;&nbsp;
										<select>
											<option>and 
												<option>or
												</select>
									</td>
								</tr>
								<tr>
					<td>
						<select >
							<option>ISBN 
								<option>서명  
									<option>저자  
										<option>출판사 
										</select>
										&nbsp;&nbsp;&nbsp;
										<input type=text size="70">
									
										
									</td>
								</tr>
							
						</table>
						</form>
						<div id="chekm">
						분류 
							<input type="checkbox" id="chek">총류 
							<input type="checkbox" id="chek1">철학  
							<input type="checkbox" id="chek2">종교 
							<input type="checkbox" id="chek3">사회과학  
							<input type="checkbox" id="chek4">어학 
							<input type="checkbox" id="chek5">자연과학 
							<input type="checkbox" id="chek6">응용과학 
							<input type="checkbox" id="chek7">예술	 
							<input type="checkbox" id="chek8">문학 
							<input type="checkbox" id="chek9">역사 

					</div> 
					<div id="number">
						발행년
						<input type=text size="7">--
						<input type=text size="7">
						쪽당 출력 건수 
						<select id="select1">
							<option>10
							<option>9
								<option>8
									<option>7
										<option>6
											<option>5
												<option>4
													<option>3
														<option>2
															<option>1
															</select>

							최대검색권수 
							<select id="select2">
							<option>500
							<option>400
							<option>300
							<option>200
							<option>100
							</select>
							</div>
							<div id="butt">
								<div id="but">
	<div class="button">
		<div class="light"></div>
		
	</div>
	<div class="button">
		<div class="light"></div>
		나의History
	</div>
</div>
							</div>

	</div>
	
</div>
</div>




</body>
</html>

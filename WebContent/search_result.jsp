<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko"> 
<head>
<meta charset="utf-8">
	<title>jQuery Test</title>

<script src='js/jquery-1.8.2.min.js'></script>
<link href="css/search_resul.css" rel="stylesheet" type="text/css"> 
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery.share.js"></script>



</head>

<body>

<div class="warp">

<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
		</jsp:include>

		<div class="title">
		검색결과 
		</div>
		<div id="rebox">
			 <input type="text" class="typetext" id="searchbar"><a href="../search/search_result.jsp"><img src="img/btn_msearch.gif"></a>


		</div>
	

	
	<table>
				<tr>
				<th>번호</th>
				<th>이미지 </th>

				<th>도서명</th>
				<th>저자 </th>
				<th>출판사 </th>
				
				<th>소장위치 </th>
				
				<th>isbn </th>
				
				<th>도서상태 </th>
		
				<th>예약 </th>
					
		</tr>
									<tr>
										    <td> 7    </td>

											<td class="img"><img src="img/logo.gif"></a> </td>
											<td>ㅅ </td>
											<td>2</td>
											<td>우리궁궐</td>
											<td>2012-02-02</td>
											<td>?</td>
											<td>fff</td>
												<td style="width:100px;"><input type="button" value="예약하기"id="reser"><br>

													<input type="button" value="서평보기 " class="coms">

											

												</td>
											</tr>
										</table>


										
								
											<table class="comment_hide" border="1" >
											<tr >	
											<th>남긴이 </th>
											<th>내 용  </th>
											<th>	<input type="button" class="butt1" value="서평추가"></th>
											<th><input type="button" value="서평 목록" class="add"></th>
			
												</tr>
					
										<tbody>

										</tbody>

	
								</table>
							
												
							
									
											
									<table class="comment_in">
										

											<tr >	
												<td class="comment">서평 추가 </td>
													
										
												<td class="sub_size"><input type="text" class="text" ><input type="button" value="+" class="butt">
												<input type="button" value="-" class="butt3">
											</td>
											</tr>
									
										</table>
									</div>



											

												  
				</div>



	<div class="sample" style="display:none">
	<table>
	<tr>
		
		<td style="width:100px;height:50px;"><input type='text' size='25'>서평목록버튼은 연동시 지울것임</td>
		<td style="width:500px;height:50px;"><input type='text' size='80' ></td>
		


	
	</tr>
	</table>
	</div>
</body>
</html>

<script type="text/javascript">
$(function() {

	$("table.comment_hide").hide()


	$(".coms").click(function(){
		$("table.comment_hide").slideToggle()("slow");
	


});
	$("table.comment_in").hide()
	$(".butt1").click(function(){
		$("table.comment_hide").hide("slow")
		$("table.comment_in").show()("slow");
	
});
	$(".butt3").click(function(){
		$("table.comment_in").hide("slow")
	});

	$('.add').click(function() {
		$(".comment_hide").find("tbody").append("<tr>"+$('.sample').find('tr').html()+"</tr>");
	});
});
</script>

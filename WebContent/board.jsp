<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="css/reset.css">
<link type="text/css" rel="stylesheet" href="css/reset2.css">
<link type="text/css" rel="stylesheet" href="css/board1.css">
<link type="text/css" rel="stylesheet" href="css/share.css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
<title>게시판</title>
</head>
<body>
<div id="wrap">
<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
</jsp:include>
<div id="box">
<div id="title">공지사항
	</div>
<table>
<tbody><tr>
<th>글번호</th>
<th>작성자</th>
<th style="width:120px;">제목</th>
<th>날짜</th>
<th style="width:60px;">조회수</th>
<th colspan="2" id="text">수정/삭제</th>

</tr>
<tr>
<td>17</td>
<td>99999999</td>
<td><a href="LibPServlet?op=boardshow&amp;bdnumber=17">공지테스트5</a></td>
<td>2012-11-30 17:45:32.0</td>
<td>0</td>
<td class="up"><a href="BoardServlet?op=update&amp;number=">수정</a></td>
<td class="up1"><a href="BoardServlet?op=delete&amp;number=">삭제</a></td>
</tr>

</tbody>
</table>
 <div class="pagination_pagination_centered">
	<ul>
    

        <li class="disabled"><a href="#">≪</a></li>
      
      
    	<li class="active"><a href="LibPServlet?op=board&amp;btype=N&amp;page=1">1</a></li>
	      
	<li><a href="#">≫</a></li>
      

    
	</ul>
<a class="sub" href="BoardServlet?op=write" >글쓰기</a>
</div>


</div>
</div>
</body>
</html>
		
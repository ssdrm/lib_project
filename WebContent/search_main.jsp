<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>통합검색</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>

</head>

<body>
	<div id="wrap">
		<jsp:include page="share/navi.jsp">
			<jsp:param name="Aurl" value="board_main.jsp" />
		</jsp:include>

		<div id="form">
			<div id="title">통합검색</div>

			<div id="box">
				<div id="search">
					<ul>
						<li><a class="${cla }" href="LibPServlet?op=key&cla=m">&nbsp;&nbsp;&nbsp;키워드&nbsp;&nbsp;</a>
						</li>
						<li><a class="${clb }" href="LibPServlet?op=key&clb=m">&nbsp;&nbsp;전방일치&nbsp;&nbsp;</a>
						</li>
						<li><a class="${clc }" href="LibPServlet?op=key&clc=m">&nbsp;완전일치&nbsp;
						</a></li>
					</ul>
				</div>
				<form action="LibPServlet" method="post">
					<table>

						<tr>
							<td><select name="dsop1">
									<option>서명
									<option>저자
									<option>출판사
									<option>ISBN
							</select> &nbsp;&nbsp;&nbsp; <input type=text size="70" name="dsops1">
								&nbsp;&nbsp;&nbsp; <select name="dsop20">
									<option>and
									<option>or
							</select></td>
						</tr>
						<tr>
							<td><select name="dsop2">
									<option>저자
									<option>서명
									<option>출판사
									<option>ISBN
							</select> &nbsp;&nbsp;&nbsp; <input type=text size="70" name="dsops2">
								&nbsp;&nbsp;&nbsp; <select name="dsop30">
									<option>and
									<option>or
							</select></td>
						</tr>
						<tr>
							<td><select name="dsop3">
									<option>출판사
									<option>서명
									<option>저자
									<option>ISBN
							</select> &nbsp;&nbsp;&nbsp; <input type=text size="70" name="dsops3">
								&nbsp;&nbsp;&nbsp; <select name="dsop40">
									<option>and
									<option>or
							</select></td>
						</tr>
						<tr>
							<td><select name="dsop4">
									<option>ISBN
									<option>서명
									<option>저자
									<option>출판사
							</select> &nbsp;&nbsp;&nbsp; <input type=text size="70" name="dsops4"></td>
						</tr>
					</table>
				
				<div id="chekm">분류 
				<input type="checkbox" class="chek" name="cate0" value="총류">총류 
				<input type="checkbox" class="chek" name="cate1" value="철학">철학 
				<input type="checkbox" class="chek" name="cate2" value="종교">종교 
				<input type="checkbox" class="chek" name="cate3" value="사회과학">사회과학
				<input type="checkbox" class="chek" name="cate4" value="어학">어학 
				<input type="checkbox" class="chek" name="cate5" value="자연과학">자연과학 
				<input type="checkbox" class="chek" name="cate6" value="응용과학">응용과학 
				<input type="checkbox" class="chek" name="cate7" value="예술">예술
				<input type="checkbox" class="chek" name="cate8" value="문학">문학 
				<input type="checkbox" class="chek" name="cate9" value="역사">역사 
				<input type="hidden" name="op" value="deserch">
				<input type="hidden" name="skey1" value="${cla }">
				<input type="hidden" name="skey2" value="${clb }">
				<input type="hidden" name="skey3" value="${clc }">
				</div>

				<div id="butt">
					<input style="width: 100px;" type="submit" value="검   색 ">
					<input style="width: 100px;" type="submit" value="나의History">
				</div>
				</form>
			</div>
		</div>

	</div>




</body>
</html>

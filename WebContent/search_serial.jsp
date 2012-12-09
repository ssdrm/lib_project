<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>연속간행물</title>

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/serial.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>

</head>

<body>
	<div id="wrap">
	
		<jsp:include page="share/navi.jsp">
			<jsp:param name="Aurl" value="search_serial.jsp" />
		</jsp:include>

		<div id="form">
			<div id="title">연속간행물</div>
			<div id="box">
				<div id="search">
					<ul>
						<li><a class="${cla }" href="LibPServlet?op=skey&cla=m">&nbsp;&nbsp;&nbsp;키워드&nbsp;&nbsp;</a>
						</li>
						<li><a class="${clb }" href="LibPServlet?op=skey&clb=m">&nbsp;&nbsp;전방일치&nbsp;&nbsp;</a>
						</li>
						<li><a class="${clc }" href="LibPServlet?op=skey&clc=m">&nbsp;완전일치&nbsp;
						</a></li>
					</ul>
				</div>
				<form action="LibPServlet" method="post">
					<table>
						<tr>
							<td><select name="dsop1">
									<option>서명
									<option>저자
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
							</select> &nbsp;&nbsp;&nbsp; <input type=text size="70" name="dsops2"></td>
						</tr>
					</table>
				<input type="hidden" name="op" value="seserch">
				<input type="hidden" name="skey1" value="${cla }">
				<input type="hidden" name="skey2" value="${clb }">
				<input type="hidden" name="skey3" value="${clc }">
				<div id="butt">
					<input style="width: 100px;" type="submit" value="검   색 ">
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

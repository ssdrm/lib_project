<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="utf-8" />

<title>회원가입</title>

<link href="css/sign.css" rel="stylesheet" type="text/css">

<script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>



</head>
<body>

	<div id="reg">
		<div id="warp">
			<h2 title="회원등록">Registration</h2>
			<form id="reg_form" action="LibPServlet" method="post">
				<p>
				<div id="n">
					이름 <br>
					<div id="left">
						<img src="img/u_name.png" />
					</div>
					<div id="right">
						<input id="username" type="text" name="name">
					</div>
				</div>
				</p>
				<p>
				<div id="n1">
					아이디(학번)<br>

					<div id="left1">
						<img src="img/u_check.png">
					</div>
					<div id="right1">
						<input type="text" id="userid" name="id"> <input type="button" value="중복검사"
							onClick="idCheck()">


					</div>
				</div>
				</p>
				<p>
				<div id="n2">
					폰 번호<br>
					<div id="left2">
						<img src="img/u_phone.png">
					</div>
					<div id="right2">
						<input id="num" type="text" placeholder="폰 번호" name="phone">
					</div>
				</div>
				</p>
				<p>
				<div id="n3">
					이메일<br>
					<div id="left3">
						<img src="img/u_email.png">
					</div>
					<div id="right3">
						<input id="u_email" type="text" name="mail">
					</div>
				</div>
				</p>

				<p>
				<div id="n4">
					비밀번호<br>
					<div id="left4">
						<img src="img/u_pass.png">
					</div>
					<div id="right4">

						<input id="pwd" type="password" name="passwd">확인 <input id="pwdconfirm"
							type="password">
					</div>
				</div>
				</p>


				<p>
					<button id="regbtn" type="submit" title="회원가입">가입하기</button>
				<a href="LibPServlet">메인으로</a>
				</p>
				<input type="hidden" name="op" value="sign">
			</form>
			<div>
				
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#regbtn:button").click(function() {
					invaliditem();
					clearinput();
				});
				function invaliditem() {

					var username = $("#username:text").attr("value");
					if (username == "") {
						alert("이름을 입력하세요 ");
						return;
					}
					if ($("#userid:text").attr("value") == "") {
						alert("아이디를 입력하세요");
						return;
					}

					if ($("#userid:text").attr("value") == "") {
						alert("아이디를 입력하세요");
						return;
					}
					if ($("#u_email:text").attr("value") == "") {
						alert("이메일을  입력하세요");
						return;
					}
					if ($("#pwd:password").val() == ""
							|| $("#pwdconfirm:password").val() == "") {
						alert("암호를 입력하세요 ");
						return;
					}
					if ($("#num:text").val() == "") {
						alert("전화번호를 입력하세요 ");
						return;
					}
					if ($("#pwd:password").val() == ""
							|| $("#pwdconfirm:password").val() == "") {
						alert("암호를 입력하세요 ");
						return;
					}
					if ($("#pwd:password").val() != $("#pwdconfirm:password")
							.val()) {
						alert("암호가 일치하지 않습니다 ");
						return;
					}
					alert(username + "님 회원가입을 축하드립니다.");
				}

			});
</script>
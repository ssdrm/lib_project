<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>도서 추가</title>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reset2.css" rel="stylesheet" type="text/css">
<link href="css/bookadd.css" rel="stylesheet" type="text/css">
<link href="css/share.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>
</head>
<body>

	<div id="wrap">
		<div id="title">도서 추가</div>
		<form action="LibPServlet" method="post">
			<table class="size">
				<tr>
					<th>책이름</th>
					<td><input type="text" size="70" name="b_name"></td>
				</tr>
				<tr>
					<th>저자</th>
					<td><input type="text" size="70" name="writer"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" size="70" name="maker"></td>
				</tr>
				<tr>
					<th>날짜</th>
					<td><input type="text" size="70" name="b_date"></td>

				</tr>
				<tr>
					<th>분류</th>

					<td>
					<input type="radio" class="name" name="category" value="0">총류
						<input type="radio" class="name" name="category" value="1">철학 
						<input type="radio" class="name" name="category" value="2">종교
						<input type="radio" class="name" name="category" value="3">사회과학 
						<input type="radio" class="name" name="category" value="4">어학 
						<input type="radio" class="name" name="category" value="5">자연과학 
						<input type="radio" class="name" name="category" value="6">응용과학 
						<input type="radio" class="name" name="category" value="7">예술
						<input type="radio" class="name" name="category" value="8">문학 
						<input type="radio" class="name" name="category" value="9">역사
						</td>
				</tr>
				<tr>
					<th>위치</th>
					<td><input type="text" size="70" name="location"></td>
				</tr>
				<tr>
					<th>테마</th>
					<td><input type="radio" class="name2" size="70" name="temagory" value="0">없음
						<input type="radio" class="name2" name="temagory" value="1">환경과 에너지
						<input type="radio" class="name2" size="70" name="temagory" value="2">인 물
						<input type="radio" class="name2" size="70" name="temagory" value="3">컴퓨터
						<input type="radio" class="name2" size="70" name="temagory" value="4">우리문화 알기
						<input type="hidden" name="op" value="addbook">
						</td>
				</tr>
			</table>
			<input class="but" type="submit" value="전송 ">
		</form>
	</div>
</body>
</html>
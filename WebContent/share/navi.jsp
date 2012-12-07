<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var = "Aurl" value = "${param.Aurl }"/>
<div id = "header">
			<div id = "header_left">
				<a href="LibPServlet"><img src="img/logo.gif" alt="logo"></a>
			</div>
			<div id = "header_right">
				<c:choose>
					<c:when test = "${user != NULL}">
			  		${name }님 환영합니다. <a href="LibPServlet?op=logout&Aurl=${Aurl }">로그아웃</a>
					</c:when>
					<c:otherwise>
						<form name="form" action="LibPServlet" method="post">
							ID : <input type="text" name="user" id="id" size="10px">
							PASSWORD : <input type="password" name="passwd" id="password" size="10px">
							<input type="image" alt="login" src="img/btn_login.gif" value="Login" >
							<input type="hidden" name="Aurl" value="${Aurl }">
							<a href="sign_up.jsp">회원가입</a>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div id = "line1">
		</div>
		
		<div id = "navibar">
				
			<ul>
				<li><a href="LibPServlet?op=key"><span>자료검색</span></a>
					<div>
						<ol>
							<li class="first"><a href="LibPServlet?op=key">통합검색</a></li>
							<li><a href="LibPServlet?op=skey">연속간행물</a></li>
							<li><a href="LibPServlet?op=okey">고서</a></li>
							<li class="last"><a href="search_theme_main.jsp">테마가 있는 서재</a></li>
						</ol>
					</div>
				</li>
					
				<li><a href=""><span>도서관 서비스</span></a> 
					<div>
						<ol>
							<li class="first"><a href="data_intro.jsp">자료구입신청/조회</a></li>
							<li><a href="borrow_intro.jsp">대출현황조회/연장</a></li>
							<li class="last"><a href="reserve_intro.jsp">도서예약</a></li>
						</ol>
					</div>
				</li>
				<li><a href=""><span>알림마당</span></a>
					<div>
						<ol>
						 	<li class="first"><a href="LibPServlet?op=board&btype=N">공지사항</a></li>
							<li class="last"><a href="LibPServlet?op=board&btype=Q">질의응답</a></li>
						</ol>
					</div>
				</li>
				<li><a href=""><span>도서관 이용안내</span></a>
					<div>
						<ol>
						 	<li class="first"><a href="intro1.jsp">도서관 소개</a></li>
							<li class="last"><a href="come1.jsp">도서관 오는길</a></li>
						</ol>
					</div>
				</li>
				<li><a href=""><span>마이페이지</span></a>
					<div>
						<ol>
					 		<li class="first"><a href="individual_info.jsp">개인정보관리</a></li>
							<li><a href="data_application.jsp">자료구입신청/조회</a></li>
							<li><a href="borrows.jsp">대출현황조회/연장</a></li>
							<li><a href="individual.jsp">개인연락사항</a></li>
							<li class="last"><a href="">검색 히스토리</a></li>
						</ol>
					</div>
				</li>
			</ul>
		</div>
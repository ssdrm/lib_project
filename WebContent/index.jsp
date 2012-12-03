<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  import="java.sql.*" 
    import="org.apache.commons.lang3.StringUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>명지대학교 자연캠퍼스 도서관</title>
<link href = "css/reset.css" rel = "stylesheet" type = "text/css">
<link href = "css/reset2.css" rel="stylesheet" type = "text/css">
<link href = "css/index.css" rel = "stylesheet" type = "text/css">
<link href = "css/usernavi.css" rel = "stylesheet" type = "text/css">
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<link href = "css/set2.css" rel = "stylesheet" type = "text/css">
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.UI.min.js"></script>
<script src="js/jquery.navi.js"></script>
<script src="js/jquery.index.js"></script>
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.share.js"></script>

</head>
<body>



	<div id = "wrap">
	
		<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
		</jsp:include>
		<div id="box">
		<div id = "libmain">
		
			<div id = "mainiimage">
				<div id = "mainimage">
			
				<img alt="mju" src="img/mju.jpg">
				</div>
			<!--여기에 사진넣을꺼다.-->
					<div id = "mainserch">
							
							<p style="line-height:50%; margin-top:0; margin-bottom:0;"><img src="./img/searchTab1_c.gif"></p>
							<form id="searchForm" action="LibPServlet" method="POST">
							<input type="text" class="typetext" id="searchbar" name="searchbar">
							<input type="hidden" name="op" value="serch">
							<input type="image" alt="검색" src="img/btn_msearch.gif" value="">
							<a href="search_main.html"><img src="img/btn_searchdetail.gif" height="31px"></a>
							</form>
					</div>
				</div>
		
		
			
			<!-- 사용자에 따른 네비게이션 바 -->
			<div id = "bar">
				<div id = "user">
				사용자모드 나중에 지우거나 다른글로 교체<br><br>
					<nav id = "usernav">
						<ul class = "clear">
							<li class = "focus"><a href="borrows.html">대촐현황 / 연장 </a></li>
							<li><a href="data_application.html">자료구입 / 신청</a></li>
							<li><a href="">현재날짜 / 현재시간</a></li>
							<li><a href="">개인정보관리</a></li>
							<li><a href="come1.html">도서관 오는길</a></li>
						</ul>
					</nav>
				</div>
				<div id = "admin">
				관리자모드 나중에 지우거나 다른글로 교체<br><br>
					<nav id = "adminnav">
						<ul class = "clear">
							<li class = "focus"><a href="">대출현황조회</a></li>
							<li><a href="">신청된자료조회</a></li>
							<li><a href="">도서관리</a></li>
							<li><a href="">회원관리</a></li>
							<li><a href="">학생추가 </a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
		
		
		
		<div id = "line2">
		</div>
		<div id = "letter">
			<div id="letter1">
				PopupZone
				
			
			</div>
			<div id ="letter2">
					Notice
			</div>	
			<div id ="letter3">
					Library with Theme
			</div>
		</div>
		<div id = "libother">
			
			<div id = "other_left">
				<ul>
					<li><span><img src="img/num1.gif"></span>
						<div>
							<ul>
								<li><img src="img/b1.gif" width="215px"height="106"></li>
							</ul>

						</div>
					</li>
					<li><span><img src="img/num_2.gif"></span>
						<div>
							<ul>
								<li><img src="img/b2.gif" width="215px"height="106"></li>
							</ul>

						</div>
					</li>
					<li><span><img src="img/num_3.gif"></span>
						<div>
							<ul>
								<li><img src="img/b3.gif" width="215px"height="106"></li>
							</ul>

						</div>
					</li>
					<li><span><img src="img/num_4.gif"></span>
						<div>
							<ul>
								<li><img src="img/b4.gif" width="215px"height="106"></li>
							</ul>

						</div>
					</li>
					<li><span><img src="img/num_5.gif"></span>
						<div>
							<ul>
								<li><img src="img/b5.gif" width="215px"height="106"></li>
							</ul>

						</div>
					</li>


				</ul>
			</div>
			<div id = "other_mid">
				<ul>
					<li><a href="#"><span>공지사항</span></a>
						<div>
							<ul>
								<c:forEach var = "inNboard" items="${Nboard.list }" >
								<li><a href="LibPServlet?op=boardshow&bdnumber=${inNboard.bdnumber }"><c:out value = "${inNboard.title }"/></a></li>
								</c:forEach>
							</ul>
					  </div>
					</li>
					<li><a href="#"><span>QandA</span></a>
						<div>
							<ul>
								<c:forEach var = "inQboard" items="${Qboard.list }" >
								<li><a href="LibPServlet?op=boardshow&bdnumber=${inQboard.bdnumber }"><c:out value = "${inQboard.title }"/></a></li>
								</c:forEach>
							</ul>
						</div>
					</li>
				</ul>
			</div>
			<div id = "other_right">
				<ul>
				<li><a href="#"><span>환경</span></a>
						<div>
							<ul>
								<li ><a ><img src="img/logo.gif" class="img"></a></li>
								<li class="text"><br><a class="titletext">교수직날로먹는법</a><br>
									<a  class="copy">저자..이명호 </a>

								</li>
							</ul>

					
					  </div>
					<li><a href="#"><span>인물</span></a>
						<div>
							<ul>
								<li> <a ><img src="img/logo.gif" class="img"></a></li>
							<li class="text"><br><a class="titletext">23423423423</a><br>
									<a  class="copy">저자 </a>

							</ul>
					  </div>
					</li>
					<li><a href="#"><span>문화</span></a>
						<div>
							<ul>
								<li ><a ><img src="img/logo.gif" class="img"></a></li>
								<li class="text"><br><a class="titletext">책 이름2 </a><br>
									<a  class="copy">저자 </a>

							</ul>
					  </div>
					</li>
					<li><a href="#"><span>컴퓨터</span></a>
						<div>
							<ul>
								<li><a ><img src="img/logo.gif" class="img"></a></li>
								<li class="text"><br><a class="titletext">책 이름3 </a><br>
									<a  class="copy">저자 </a>

							</ul>
					  </div>
					</li>
				</ul>
			</div>
		</div>
		<div id = "line3">
		</div>
		<div id = "footer">
			 자연캠퍼스 도서관 (우449-728) 경기도 용인시 처인구 명지로 116
		</div><a href = "LibPServlet?op=serch&searchbar=1">test</a>
	</div>
	</div>
</body>
</html>
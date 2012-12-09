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
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<link href = "css/index.css" rel = "stylesheet" type = "text/css">
<link href = "css/usernavi.css" rel = "stylesheet" type = "text/css">
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
			<jsp:param name="Aurl" value = "index.jsp"/>
		</jsp:include>
		<div id = "box">
		<div id = "libmain">
		
			<div id = "mainiimage">
				<div id = "mainimage">
			
				<img alt="mju" src="img/mju.jpg">
				</div>
					<div id = "mainserch">
							
							<p style="line-height:50%; margin-top:0; margin-bottom:0;"><img src="./img/searchTab1_c.gif"></p>
							<form id="searchForm" action="LibPServlet" method="POST">
							<input type="text" class="typetext" id="searchbar" name="searchbar">
							<input type="hidden" name="op" value="serch">
							<input type="image" alt="검색" src="img/btn_msearch.gif" value="">
							<a href="LibPServlet?op=key"><img src="img/btn_searchdetail.gif" height="31px"></a>
							</form>
					</div>
				</div>
		
		
			
			<!-- 사용자에 따른 네비게이션 바 -->
			<div id = "bar">
			<c:choose>
			<c:when test="${admintype=='F' }">
				<div id = "user">
					<nav id = "usernav">
						<ul class = "clear">
							<li class = "focus"><a href="LibPServlet?op=userbor&id=${user }">대출현황/연장/성향 </a></li>
							<li><a href="data_application.jsp">자료구입신청</a></li>
							<li><a href="LibPServlet?op=impid&id=${user }">자료구입조회</a></li>
							<li><a href="LibPServlet?op=free&id=${user }">개인연락사항</a></li>
							<li><a href="come1.jsp">도서관 오는길</a></li>
						</ul>
					</nav>
				</div>
				
				<div id = "admin" style="display:none">
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
				
				
				</c:when>
				<c:when test="${admintype=='T' }">
				
				
				<div id = "user" style="display:none">
					<nav id = "usernav">
						<ul class = "clear">
							<li class = "focus"><a href="borrows.html">대출현황 / 연장 </a></li>
							<li><a href="data_application.html">자료구입 / 신청</a></li>
							<li><a href="">현재날짜 / 현재시간</a></li>
							<li><a href="">개인정보관리</a></li>
							<li><a href="come1.html">도서관 오는길</a></li>
						</ul>
					</nav>
				</div>
				
				
				<div id = "admin">
					<nav id = "adminnav">
						<ul class = "clear">
							<li class = "focus"><a href="borrow_manage.jsp">대출현황/관리</a></li>
							<li><a href="LibPServlet?op=showimp">신청된자료조회</a></li>
							<li><a href="bookadd.jsp">도서추가</a></li>
							<li><a href="LibPServlet?op=use">회원관리</a></li>
							<li><a href="LibPServlet?op=stu">학생추가 </a></li>
						</ul>
					</nav>
				</div>
				</c:when>
				<c:otherwise>
				<div style="width:180px;height:50px;float:left;margin-left:300px;margin-top:15px;">
				<script  src="http://widgetprovider.daum.net/view?url=http://widgetcfs1.daum.net/xml/14/widget/2009/03/31/15/20/49d1b62de0f5b.xml&&width=166&height=50&widgetId=336&scrap=1" type="text/javascript"></script></div>
				<div style="width:200px;height:80px;float:right;margin-right:260px;margin-top:10px;">
				<script src="http://widgetprovider.daum.net/view?url=http://widgetcfs1.daum.net/xml/12/widget/2008/09/23/11/01/48d84de12a690.xml&up_setLocal=108&&width=166&height=80&widgetId=120&scrap=1" type="text/javascript"></script></div>
				<div id = "user" style="display:none">
					<nav id = "usernav">
						<ul class = "clear">
							<li class = "focus"><a href="borrows.html">대출현황 / 연장 </a></li>
							<li><a href="data_application.html">자료구입 / 신청</a></li>
							<li><a href="">현재날짜 / 현재시간</a></li>
							<li><a href="">개인정보관리</a></li>
							<li><a href="come1.html">도서관 오는길</a></li>
						</ul>
					</nav>
				</div>
				
				
				<div id = "admin" style="display:none">
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
				</c:otherwise>
				</c:choose>
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
					<li><a href="LibPServlet?op=board&btype=N"><span>공지사항</span></a>
						<div>
							<ul>
								<c:forEach var = "inNboard" items="${Nboard.list }" >
								<li><a href="LibPServlet?op=boardshow&bdnumber=${inNboard.bdnumber }"><c:out value = "${inNboard.title }"/></a></li>
								</c:forEach>
							</ul>
					  </div>
					</li>
					<li><a href="LibPServlet?op=board&btype=Q"><span>QandA</span></a>
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
				<li><a href="search_theme_main.jsp"><span>환경</span></a>
						<div>
							<ul>
								<li ><a ><img src="bookkimages/31017.jpg" class="img"></a></li>
								<li style="width:150px;height:50px;margin-top:10px;text-overflow:ellipsis;overflow:hidden;margin-left:5px;">
									
									<div style="width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;font-size:20px;" > <a href="search_theme_main.jsp"> 에너지진단 원론</a></div>
									<div style="font-size:20px;width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;" > 
									 손학식 </div>
						


								</li>
							</ul>

					
					  </div>
					<li><a href="search_theme_human.jsp"><span>인물</span></a>
						<div>
							<ul>
								<li ><a ><img src="bookkimages/12004.jpg" class="img"></a></li>
								<li style="width:150px;height:50px;margin-top:10px;text-overflow:ellipsis;overflow:hidden;margin-left:5px;">
									
									<div style="width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;font-size:20px;" > <a href="search_theme_human.jsp">로버트쿠퍼의인생경영</a></div>
									<div style="font-size:20px;width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;" > 
				윤영호 </div>
						


								</li>
							</ul>
					  </div>
					</li>
					<li><a href="search_theme_culture.jsp"><span>문화</span></a>
						<div>
							<ul>
								<li ><a ><img src="bookkimages/84029.jpg" class="img"></a></li>
								<li style="width:150px;height:50px;margin-top:10px;text-overflow:ellipsis;overflow:hidden;margin-left:5px;">
									
									<div style="width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;font-size:20px;" > <a href="search_theme_culture.jsp">우리궁궐 이야기 </a></div>
									
									<div style="font-size:20px;width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;" > 
									홍순민 </div>
						


								</li>
							</ul>
					  </div>
					</li>
					<li><a href="search_theme_computer.jsp"><span>컴퓨터</span></a>
						<div>
							<ul>
								<li ><a ><img src="bookkimages/03019.jpg" class="img"></a></li>
								<li style="width:150px;height:50px;margin-top:10px;text-overflow:ellipsis;overflow:hidden;margin-left:5px;">
									
									<div style="width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;font-size:20px;" > <a href="search_theme_computer.jsp">한글 액세스와 매크로 </a></div>
									
									<div style="font-size:20px;width:150px;height:25px;text-overflow:ellipsis;overflow:hidden;" > 
						김소윤 </div>
						


								</li>
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
		</div>
		</div>
	</div>
</body>
</html>
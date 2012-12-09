package localhost.lib.pro.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;
import javax.servlet.http.*;
import localhost.lib.pro.*;

/**
 * Servlet implementation class LibPServlet
 */
@WebServlet("/LibPServlet")
public class LibPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LibPServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int getIntFromParameter(String str, int defaultValue) {
		int number;

		try {
			number = Integer.parseInt(str);
		} catch (Exception e) {
			number = defaultValue;
		}
		return number;
	}
	
	///date
	//2000-12-12
	private java.sql.Date getDateFromParameter(String str) {
		int year = Integer.parseInt(str.substring(0,4));
		int month = Integer.parseInt(str.substring(5,7));
		int day = Integer.parseInt(str.substring(8,10));
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
		
		/*
		String strdate;
		long londate;
		strdate = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
		londate = Long.parseLong(strdate);
		Date date = new java.util.Date (londate);
		*/
		//sdf.applyPattern();
		return date;
	}
	
	/*
	private java.sql.Timestamp stamp2(java.sql.Timestamp bordate) {
		String str = bordate.toString();
		//2000-12-12 15:10:48.0
		//yyyy-MM-dd hh:mm:ss
		int year = Integer.parseInt(str.substring(0,4));
		int month = Integer.parseInt(str.substring(5,7));
		int day = Integer.parseInt(str.substring(8,10));
		
		int hour = Integer.parseInt(str.substring(11,13));
		int minit = Integer.parseInt(str.substring(14,16));
		int secon = Integer.parseInt(str.substring(17,19));
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day+14, hour, minit, secon);
		java.sql.Timestamp date = new java.sql.Timestamp(cal.getTimeInMillis());
		return date;
	}
	*/
	
	private java.sql.Date sqlnowdate(){
		GregorianCalendar gc = new GregorianCalendar();
		java.sql.Date sdate = new java.sql.Date(gc.getTimeInMillis());
		
		return sdate;
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 변수선언
		request.setCharacterEncoding("utf-8");
		List<String> errorMsgs = new ArrayList<String>();
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String sbook = request.getParameter("searchbar");
		String btype = request.getParameter("btype");
		String actionUrl = "";
		String Aurl = request.getParameter("Aurl");
		String cla = request.getParameter("cla");
		String clb = request.getParameter("clb");
		String clc = request.getParameter("clc");

		boolean ret = false;
		int bdnumber = getIntFromParameter(request.getParameter("bdnumber"), -1);
		int bw_number = getIntFromParameter(request.getParameter("bw_number"), -1);
		int im_number = getIntFromParameter(request.getParameter("im_number"), -1);

		HttpSession session = request.getSession(false);
		if (session == null) {
			session = request.getSession();
		}
		// op가 무엇인지에따라 작업.
		if (op == null) {
			op = "index";
		}
		try {
			if (op == null || op.equals("index")) {// index화면.
				Showlist<Board> Qboard = LibPDAO.INboard("Q");
				Showlist<Board> Nboard = LibPDAO.INboard("N");
				request.setAttribute("Qboard", Qboard);
				request.setAttribute("Nboard", Nboard);
				actionUrl = "index.jsp";
			} else if (op.equals("serch")) {// 검색
				/*
				 * int page = getIntFromParameter(request.getParameter("page"),
				 * 1); Pagelist<Books> Serbook = LibPDAO.Serchbooks(page, 20,
				 * sbook); request.setAttribute("Serbook", Serbook);
				 * request.setAttribute("page", page);
				 */
				Showlist<Books> Serbook = LibPDAO.Serchbook(sbook);
				Showlist<Bookborrow> bookborrow = LibPDAO.Sreborbook(sbook);
				request.setAttribute("Serbook", Serbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl = "search_result.jsp";
			} else if (op.equals("boardshow")) {// 게시판내용

				Board boardshow = LibPDAO.findByBoard(bdnumber);
				request.setAttribute("boards", boardshow);
				actionUrl = "board_show.jsp";
			} else if (op.equals("board")) {// 게시판
				int page = getIntFromParameter(request.getParameter("page"), 1);
				Pagelist<Board> boards = LibPDAO.getBoard(page, 20, btype);
				request.setAttribute("boards", boards);
				request.setAttribute("page", page);
				actionUrl = "board_main.jsp";
			} else if (op.equals("logout")) {// 로그아웃.
				session.invalidate();
				Showlist<Board> Qboard = LibPDAO.INboard("Q");
				Showlist<Board> Nboard = LibPDAO.INboard("N");
				request.setAttribute("Qboard", Qboard);
				request.setAttribute("Nboard", Nboard);
				actionUrl = "index.jsp";
			} else if (op.equals("key")) {// 통합검색
				if (clb != null) {
					request.setAttribute("clb", clb);
					actionUrl = "search_main.jsp";
				} else if (clc != null) {
					request.setAttribute("clc", clc);
					actionUrl = "search_main.jsp";
				} else {
					cla = "m";
					request.setAttribute("cla", cla);
					actionUrl = "search_main.jsp";
				}
			} else if (op.equals("skey")) {// 연속간행물
				if (clb != null) {
					request.setAttribute("clb", clb);
					actionUrl = "search_serial.jsp";
				} else if (clc != null) {
					request.setAttribute("clc", clc);
					actionUrl = "search_serial.jsp";
				} else {
					cla = "m";
					request.setAttribute("cla", cla);
					actionUrl = "search_serial.jsp";
				}
			} else if (op.equals("okey")) {// 고서
				if (clb != null) {
					request.setAttribute("clb", clb);
					actionUrl = "search_old.jsp";
				} else if (clc != null) {
					request.setAttribute("clc", clc);
					actionUrl = "search_old.jsp";
				} else {
					cla = "m";
					request.setAttribute("cla", cla);
					actionUrl = "search_old.jsp";
				}
			} else if (op.equals("stu")) {// 관리자 학생
				Showlist<Student> Student = LibPDAO.stufind();
				request.setAttribute("Student", Student);
				actionUrl = "student1.jsp";
			} else if (op.equals("restu")) {// 관리자 학생삭제
				ret = LibPDAO.remstu(id);
				Showlist<Student> Student = LibPDAO.stufind();
				request.setAttribute("Student", Student);
				actionUrl = "student1.jsp";
				if (ret != true) {
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
			} else if (op.equals("use")) {//회원관리
				Showlist<User> user = LibPDAO.usefind();
				request.setAttribute("user", user);
				actionUrl = "sign_up_manage.jsp";
			} else if (op.equals("reuse")) {//회원삭제(admintype을 Out으로)
				ret = LibPDAO.userrm(id);
				Showlist<User> user = LibPDAO.usefind();
				request.setAttribute("user", user);
				actionUrl = "sign_up_manage.jsp";
				if (ret != true) {
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
			} else if (op.equals("upuse")) {//관리자승격
				ret = LibPDAO.userup(id);
				Showlist<User> user = LibPDAO.usefind();
				request.setAttribute("user", user);
				actionUrl = "sign_up_manage.jsp";
				if (ret != true) {
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
			} else if (op.equals("douse")) {//관리자박탈
				ret = LibPDAO.userdown(id);
				Showlist<User> user = LibPDAO.usefind();
				request.setAttribute("user", user);
				actionUrl = "sign_up_manage.jsp";
				if (ret != true) {
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
			}else if(op.equals("retubor")){//도서반납
				java.sql.Date nowdate = sqlnowdate();
				ret = LibPDAO.borretu(bw_number, nowdate);
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
				actionUrl = "borrow_out.jsp";
			}else if(op.equals("commen")){//서평
				int b_number = getIntFromParameter(request.getParameter("b_number"),-1);
				Books Serbook = LibPDAO.commentserch(b_number);
				Showlist<Bookcomment> comment = LibPDAO.showcom(b_number);
				request.setAttribute("comment", comment);
				request.setAttribute("Serbook", Serbook);
				actionUrl = "comment_add.jsp";
			}else if(op.equals("gchuse")){//개인정보수정
				if(id == null){
					actionUrl="index.jsp";
				}
				User chuser = LibPDAO.usefindid(id);
				request.setAttribute("chuser", chuser);
				actionUrl="individual_info.jsp";
			}else if(op.equals("userbor")){//대출조회
				Showlist<Bookborrow> bookborrow = LibPDAO.boruser(id);
				Showlist<Categorib> categorib = LibPDAO.categorib(id);
				request.setAttribute("categorib", categorib);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl="borrows.jsp";
			}else if(op.equals("exdel")){//연장
				ret=LibPDAO.borex(bw_number);
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
				Showlist<Bookborrow> bookborrow = LibPDAO.boruser(id);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl="borrows.jsp";
			}else if(op.equals("showimp")){
				Showlist<Import> imports = LibPDAO.showimpo();
				request.setAttribute("imports", imports);
				actionUrl="application_search.jsp";
			}else if(op.equals("okimp")){
				ret=LibPDAO.upbookimpok(im_number);
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
				Showlist<Import> imports = LibPDAO.showimpo();
				request.setAttribute("imports", imports);
				actionUrl="application_search.jsp";
			}else if(op.equals("caimp")){
				ret=LibPDAO.upbookimpca(im_number);
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
				Showlist<Import> imports = LibPDAO.showimpo();
				request.setAttribute("imports", imports);
				actionUrl="application_search.jsp";
			}else if(op.equals("impid")){
				Showlist<Import> imports = LibPDAO.showimpoid(id);
				request.setAttribute("imports", imports);
				actionUrl="application_search.jsp";
			}else if(op.equals("free")){
				Showlist<Import> imports = LibPDAO.showimpoid(id);
				Showlist<Bookborrow> bookborrow = LibPDAO.boruser(id);
				request.setAttribute("imports", imports);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl="individual.jsp";
			}
			/*
			 * else if(op.equals("test")){ User log = LibPDAO.login(id);
			 * request.setAttribute("log", log); actionUrl = "index.jsp"; }
			 */
		} catch (SQLException | NamingException e) {
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
			actionUrl = "error.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
		dispatcher.forward(request, response);
	}

	private boolean isRegisterMode(HttpServletRequest request) {
		String method = request.getParameter("_method");
		return method == null || method.equals("POST");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//변수선언
		boolean ret = false;
		int i;
		request.setCharacterEncoding("utf-8");
		String actionUrl = "";
		String Aurl = request.getParameter("Aurl");
		String op = request.getParameter("op");
		String user = request.getParameter("user");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sbook = request.getParameter("searchbar");
		String pw = request.getParameter("passwd");
		String login = request.getParameter("login");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String co_comment = request.getParameter("co_comment");
		
		/////////검색
		//option
		String dsop1 = request.getParameter("dsop1");
		String dsop2 = request.getParameter("dsop2");
		String dsop20 = request.getParameter("dsop20");
		String dsop3 = request.getParameter("dsop3");
		String dsop30 = request.getParameter("dsop30");
		String dsop4 = request.getParameter("dsop4");
		String dsop40 = request.getParameter("dsop40");
		String skey1 = request.getParameter("skey1");
		String skey2 = request.getParameter("skey2");
		String skey3 = request.getParameter("skey3");
		//input
		String dsops1 = request.getParameter("dsops1");
		String dsops2 = request.getParameter("dsops2");
		String dsops3 = request.getParameter("dsops3");
		String dsops4 = request.getParameter("dsops4");
		//category
		String cate0 = request.getParameter("cate0");
		String cate1 = request.getParameter("cate1");
		String cate2 = request.getParameter("cate2");
		String cate3 = request.getParameter("cate3");
		String cate4 = request.getParameter("cate4");
		String cate5 = request.getParameter("cate5");
		String cate6 = request.getParameter("cate6");
		String cate7 = request.getParameter("cate7");
		String cate8 = request.getParameter("cate8");
		String cate9 = request.getParameter("cate9");
		
		//책추가
		int b_number = getIntFromParameter(request.getParameter("b_number"), -1);
		int isbn = getIntFromParameter(request.getParameter("isbn"), -1);
		String b_name = request.getParameter("b_name");
		String writer = request.getParameter("writer");
		String maker = request.getParameter("maker");
		String b_date = request.getParameter("b_date");
		String category = request.getParameter("category");
		String location = request.getParameter("location");
		String temagory = request.getParameter("temagory");
		
		//자료구입신청
		String bookname = request.getParameter("bookname");
		String bookwriter = request.getParameter("bookwriter");
		String bookmaker = request.getParameter("bookmaker");
		String reason = request.getParameter("reason");
		
		List<String> errorMsgs = new ArrayList<String>();
		java.sql.Date Fb_date = null;
		if(b_date != null){
			Fb_date = getDateFromParameter(b_date);
		}
		
		
		HttpSession session = request.getSession(false);
		if(session == null){
			session = request.getSession();
		}
		//test.setId(id);
		//test.setName(name);
		
		//책검색 옵션설정
		if(dsop1!=null){
			if(dsop1.equals("저자")){
				dsop1 = "writer";
			}else if(dsop1.equals("출판사")){
				dsop1 = "maker";
			}else if(dsop1.equals("ISBN")){
				dsop1 = "isbn";
			}else{
				dsop1 = "b_name";
			}
		}
		
		if(dsop2!=null){
			if(dsop2.equals("저자")){
				dsop2 = "writer";
			}else if(dsop2.equals("출판사")){
				dsop2 = "maker";
			}else if(dsop2.equals("ISBN")){
				dsop2 = "isbn";
			}else{
				dsop2 = "b_name";
			}
		}
		
		if(dsop3!=null){
			if(dsop3.equals("저자")){
				dsop3 = "writer";
			}else if(dsop3.equals("출판사")){
				dsop3 = "maker";
			}else if(dsop3.equals("ISBN")){
				dsop3 = "isbn";
			}else{
				dsop3 = "b_name";
			}
		}
		
		if(dsop4!=null){
			if(dsop4.equals("저자")){
				dsop4 = "writer";
			}else if(dsop4.equals("출판사")){
				dsop4 = "maker";
			}else if(dsop4.equals("ISBN")){
				dsop4 = "isbn";
			}else{
				dsop4 = "b_name";
			}
		}
		//책검색을 받지않으면 옵션도없앰.
		if(dsops2==""){
			dsop20 = "or";
		}
		if(dsops3==""){
			dsop30 = "or";
		}
		if(dsops4==""){
			dsop40 = "or";
		}
		
		//Bean 선언
		Student student = new Student();
		User users = new User();
		Books books = new Books();
		Import imports = new Import();
		
		//Bean 값추가
		student.setId(id);
		student.setName(name);
		users.setId(id);
		users.setName(name);
		users.setPassword(pw);
		users.setEmail(mail);
		users.setPhone(phone);
		books.setB_name(b_name);
		books.setWriter(writer);
		books.setMaker(maker);
		imports.setBookname(bookname);
		imports.setBookmaker(bookmaker);
		imports.setBookwriter(bookwriter);
		imports.setReason(reason);
		imports.setId(id);
		
		//books.setB_date(Fb_date);
		
		books.setCategory(category);
		books.setLocation(location);
		
		//op가 무엇인지에따라 작업.
		if(op == null){
			op = "index";
		}
		try{
			
			if(op == null || op.equals("index")){//index를보여줄때
				Showlist<Board> Qboard = LibPDAO.INboard("Q");
				Showlist<Board> Nboard = LibPDAO.INboard("N");
				request.setAttribute("Qboard", Qboard);
				request.setAttribute("Nboard", Nboard);
				actionUrl = "index.jsp";
			}else if(op.equals("serch")){//검색을하였을때
				Showlist<Books> Serbook = LibPDAO.Serchbook(sbook);
				request.setAttribute("Serbook", Serbook);
				Showlist<Bookborrow> bookborrow = LibPDAO.Sreborbook(sbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl = "search_result.jsp";
			}else if(op.equals("deserch")){//통합검색
				Showlist<Books> Serbook = LibPDAO.DeSerchbook(skey1, skey2, skey3, dsop1, dsops1, dsop20, dsop2, dsops2, dsop30, dsop3, dsops3, dsop40, dsop4, dsops4, cate0, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8, cate9);
				request.setAttribute("Serbook", Serbook);
				Showlist<Bookborrow> bookborrow = LibPDAO.Sreborbook(sbook);
				request.setAttribute("Serbook", Serbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl = "search_result.jsp";
				
				//actionUrl = "test.jsp";
			}else if(op.equals("seserch")){//연속간행물검색
				Showlist<Books> Serbook = LibPDAO.SeSerchbook(skey1, skey2, skey3, dsop1, dsops1, dsop20, dsop2, dsops2);
				request.setAttribute("Serbook", Serbook);
				Showlist<Bookborrow> bookborrow = LibPDAO.Sreborbook(sbook);
				request.setAttribute("Serbook", Serbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl = "search_result.jsp";
			}else if(op.equals("olserch")){//고서검색
				Showlist<Books> Serbook = LibPDAO.OlSerchbook(skey1, skey2, skey3, dsop1, dsops1, dsop20, dsop2, dsops2);
				request.setAttribute("Serbook", Serbook);
				Showlist<Bookborrow> bookborrow = LibPDAO.Sreborbook(sbook);
				request.setAttribute("Serbook", Serbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl = "search_result.jsp";
			}else if(op.equals("stucre")){//학생추가
				ret = LibPDAO.crestu(student);
				Showlist<Student> Student = LibPDAO.stufind();
				request.setAttribute("Student", Student);
				actionUrl = "student1.jsp";
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
			}else if(op.equals("sign")){//회원추가
				Student teststu = LibPDAO.stufindid(id);
				User testuse = LibPDAO.usefindid(id);
				if(teststu.getId() != null){
					if(teststu.getId().equals(users.getId())){
						if(users.getId().equals(testuse.getId())){
							errorMsgs.add("이미 등록된 아이디입니다.");
							actionUrl="error.jsp";
						}else{
							ret = LibPDAO.creuse(users);
							Showlist<Board> Qboard = LibPDAO.INboard("Q");
							Showlist<Board> Nboard = LibPDAO.INboard("N");
							request.setAttribute("Qboard", Qboard);
							request.setAttribute("Nboard", Nboard);
							actionUrl = "index.jsp";
							if(ret != true){
								errorMsgs.add("실패했습니다.");
								actionUrl = "error.jsp";
							}
						}
					}
				}else{
					errorMsgs.add("죄송합니다 학교에 등록되지않았습니다.");
					actionUrl = "error.jsp";
				/*
				request.setAttribute("name",users.getName());
				request.setAttribute("id",users.getId());
				request.setAttribute("phone",users.getPhone());
				request.setAttribute("mail",users.getEmail());
				request.setAttribute("pw",users.getPassword());
				request.setAttribute("teststu", teststu);
				*/
					actionUrl = "error.jsp";
				}
			}else if(op.equals("addbook")){//책추가
				String strisbn;
				int intisbn;
				int tempisbn;
				if(b_name.equals(LibPDAO.bookname(b_name).getB_name())){
					intisbn = LibPDAO.bookname(b_name).getIsbn();
				}else{
					tempisbn = Integer.parseInt(category + temagory);
					strisbn = category + temagory + "001";
					intisbn = Integer.parseInt(strisbn);
					intisbn = LibPDAO.isbnbook(tempisbn, intisbn);
				}
				books.setIsbn(intisbn);
				books.setB_date(Fb_date);
				ret = LibPDAO.creboo(books);
				Showlist<Books> Serbook = LibPDAO.Serchbook(b_name);
				request.setAttribute("Serbook", Serbook);
				Showlist<Bookborrow> bookborrow = LibPDAO.Sreborbook(sbook);
				request.setAttribute("Serbook", Serbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl = "search_result.jsp";
				/*
				int year = Integer.parseInt(b_date.substring(0,4));
				int month = Integer.parseInt(b_date.substring(5,7));
				int day = Integer.parseInt(b_date.substring(8,10));
				
				request.setAttribute("b_name", b_name);
				request.setAttribute("writer", writer);
				request.setAttribute("maker", maker);
				request.setAttribute("b_date", b_date);
				request.setAttribute("Fb_date", Fb_date);
				request.setAttribute("category", category);
				request.setAttribute("location", location);
				request.setAttribute("temagory", temagory);
				request.setAttribute("intisbn", intisbn);
				request.setAttribute("year", year);
				request.setAttribute("month", month);
				request.setAttribute("day", day);
				actionUrl="test.jsp";
				*/
				
				
			}else if(op.equals("Sbor")){//대출검사
				Showlist<Bookborrow> bookborrow = LibPDAO.Sborbook(sbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl="borrow_manage.jsp";
			}else if(op.equals("SIbor")){//대출가능책검사
				Showlist<Books> bookborrow = LibPDAO.Saddborbook(sbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl="borrow_in.jsp";
			}else if(op.equals("SObor")){//대출한책검사
				Showlist<Bookborrow> bookborrow = LibPDAO.Sreborbook(sbook);
				request.setAttribute("bookborrow", bookborrow);
				actionUrl="borrow_out.jsp";
			}else if(op.equals("addbor")){//대출
				User findid = LibPDAO.login(id);
				if(id.equals(findid.getId())){
					ret = LibPDAO.crebor(b_number, id);
					if(ret != true){
						errorMsgs.add("실패했습니다.");
						actionUrl = "error.jsp";
					}
					actionUrl = "borrow_in.jsp";
					
				}else{
					errorMsgs.add("등록되지않은 아이디입니다.");
					actionUrl = "error.jsp";
				}
			}else if(op.equals("addcom")){
				ret = LibPDAO.crecom(id, co_comment, b_number);
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
				actionUrl = "search_result.jsp";
			}else if(op.equals("addimp")){
				ret = LibPDAO.creimp(imports);
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
				actionUrl = "index.jsp";
			}else if(op.equals("chuse")){
				ret = LibPDAO.usech(phone, mail, id);
				User chuser = LibPDAO.usefindid(id);
				request.setAttribute("chuser", chuser);
				if(ret != true){
					errorMsgs.add("실패했습니다.");
					actionUrl = "error.jsp";
				}
				actionUrl = "individual_info.jsp";
			}
			
			if(user!=null){
				//test용도//if(op == null || op.equals("index")){
					User log = LibPDAO.login(user);
					//request.setAttribute("log", log);
					if(log == null){
						errorMsgs.add("등록되지않은 아이디입니다.");
						actionUrl = "error.jsp";
					}else if(log.getId().equals(user) && log.getPassword().equals(pw)){
						session.setAttribute("user",user);
						session.setAttribute("name", log.getName());
						session.setAttribute("admintype", log.getAdmintype());
						actionUrl = Aurl;
					}else if(log.getId().equals(user) && !log.getPassword().equals(pw)){
						errorMsgs.add("비밀번호가 일치하지 않습니다.");
						actionUrl = "error.jsp";
					}else{
						errorMsgs.add("아이디가 일치하지 않습니다.");
						actionUrl = "error.jsp";
					}
					
				}
		}catch(SQLException | NamingException e){
			errorMsgs.add(e.getMessage());
			actionUrl = "error.jsp";
		}
		request.setAttribute("errorMsgs",errorMsgs);
		RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
		dispatcher.forward(request, response);
	}
}

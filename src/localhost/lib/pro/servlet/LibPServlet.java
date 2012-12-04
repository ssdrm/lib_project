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
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//변수선언
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String sbook = request.getParameter("searchbar");
		String btype = request.getParameter("btype");
		String actionUrl = "";
		String Aurl = request.getParameter("Aurl");
		
		String cla = request.getParameter("cla");
		String clb = request.getParameter("clb");
		String clc = request.getParameter("clc");
		
		boolean ret;
		int bdnumber = getIntFromParameter(request.getParameter("bdnumber"),-1);
		
		HttpSession session = request.getSession(false);
		if(session == null){
			session = request.getSession();
		}
		//op가 무엇인지에따라 작업.
		if(op == null){
			op = "index";
		}
		try{
			if(op == null || op.equals("index")){//index화면.
				Showlist<Board> Qboard = LibPDAO.INboard("Q");
				Showlist<Board> Nboard = LibPDAO.INboard("N");
				request.setAttribute("Qboard", Qboard);
				request.setAttribute("Nboard", Nboard);
				actionUrl = "index.jsp";
			}else if(op.equals("serch")){//검색
				/*
				int page = getIntFromParameter(request.getParameter("page"), 1);
				Pagelist<Books> Serbook = LibPDAO.Serchbooks(page, 20, sbook);
				request.setAttribute("Serbook", Serbook);
				request.setAttribute("page", page);
				*/
				Showlist<Books> Serbook = LibPDAO.Serchbook(sbook);
				request.setAttribute("Serbook", Serbook);
				actionUrl = "search_result.jsp";
			}else if(op.equals("boardshow")){//게시판내용
				
				Board boardshow = LibPDAO.findByBoard(bdnumber);
				request.setAttribute("boards", boardshow);
				actionUrl = "board_show.jsp";
			}else if(op.equals("board")){//게시판
				int page = getIntFromParameter(request.getParameter("page"),1);
				Pagelist<Board> boards = LibPDAO.getBoard(page, 20, btype);
				request.setAttribute("boards", boards);
				request.setAttribute("page", page);
				actionUrl = "board_main.jsp";
			}else if(op.equals("logout")){//로그아웃.
				session.invalidate();
				Showlist<Board> Qboard = LibPDAO.INboard("Q");
				Showlist<Board> Nboard = LibPDAO.INboard("N");
				request.setAttribute("Qboard", Qboard);
				request.setAttribute("Nboard", Nboard);
				actionUrl = Aurl;
			}else if(op.equals("key")){
				if(clb!=null){
					request.setAttribute("clb", clb);
					actionUrl = "search_main.jsp";
				}else if(clc!=null){
					request.setAttribute("clc", clc);
					actionUrl = "search_main.jsp";
				}else{
					cla="m";
					request.setAttribute("cla", cla);
					actionUrl = "search_main.jsp";
				}
			}
			/*
			else if(op.equals("test")){
				User log = LibPDAO.login(id);
				request.setAttribute("log", log);
				actionUrl = "index.jsp";
			}
			*/
		}catch(SQLException | NamingException e){
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//변수선언
		boolean ret = false;
		int i;
		String actionUrl = "";
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String id = request.getParameter("user");
		String name = request.getParameter("name");
		String sbook = request.getParameter("searchbar");
		String pw = request.getParameter("passwd");
		String login = request.getParameter("login");
		
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
		String category = request.getParameter("category");
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
		
		List<String> errorMsgs = new ArrayList<String>();
		
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
				actionUrl = "search_result.jsp";
			}else if(op.equals("deserch")){
				/*
				request.setAttribute("dsop1",dsop1 );
				request.setAttribute("dsop2",dsop2 );
				request.setAttribute("dsop3",dsop3 );
				request.setAttribute("dsop4",dsop4 );
				request.setAttribute("dsop20",dsop20 );
				request.setAttribute("dsop30",dsop30 );
				request.setAttribute("dsop40",dsop40 );
				request.setAttribute("category",category );
				request.setAttribute("cate0",cate0 );
				request.setAttribute("cate1",cate1 );
				request.setAttribute("cate2",cate2 );
				request.setAttribute("cate3",cate3 );
				request.setAttribute("cate4",cate4 );
				request.setAttribute("cate5",cate5 );
				request.setAttribute("cate6",cate6 );
				request.setAttribute("cate7",cate7 );
				request.setAttribute("cate8",cate8 );
				request.setAttribute("cate9",cate9 );
				request.setAttribute("dsops1",dsops1 );
				request.setAttribute("dsops2",dsops2 );
				request.setAttribute("dsops3",dsops3 );
				request.setAttribute("dsops4",dsops4 );
				*/
				
				Showlist<Books> Serbook = LibPDAO.DeSerchbook(skey1, skey2, skey3, dsop1, dsops1, dsop20, dsop2, dsops2, dsop30, dsop3, dsops3, dsop40, dsop4, dsops4, cate0, cate1, cate2, cate3, cate4, cate5, cate6, cate7, cate8, cate9);
				request.setAttribute("Serbook", Serbook);
				actionUrl = "search_result.jsp";
				
				//actionUrl = "test.jsp";
			}
			
			if(id!=null){
				//test용도//if(op == null || op.equals("index")){
					User log = LibPDAO.login(id);
					//request.setAttribute("log", log);
					if(log == null){
						errorMsgs.add("등록되지않은 아이디입니다.");
						actionUrl = "error.jsp";
					}else if(log.getId().equals(id) && log.getPassword().equals(pw)){
						session.setAttribute("id",id);
						session.setAttribute("name", log.getName());
						session.setAttribute("admintype", log.getAdmintype());
						actionUrl = "index.jsp";
					}else if(log.getId().equals(id) && !log.getPassword().equals(pw)){
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

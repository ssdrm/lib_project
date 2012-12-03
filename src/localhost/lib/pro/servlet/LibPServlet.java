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
		boolean ret;
		int bdnumber = getIntFromParameter(request.getParameter("bdnumber"),-1);
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
				
			}
		}catch(SQLException | NamingException e){
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
		String actionUrl = "";
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sbook = request.getParameter("searchbar");
		String pw = request.getParameter("passwd");
		
		HttpSession session = request.getSession(false);
		if(session == null){
			session = request.getSession();
		}
		//test.setId(id);
		//test.setName(name);
		
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
			}
		}catch(SQLException | NamingException e){
			actionUrl = "index.jsp";
		}
		//request.setAttribute("errorMsgs",test);
		RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
		dispatcher.forward(request, response);
	}

}

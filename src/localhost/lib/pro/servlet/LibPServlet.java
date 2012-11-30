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

import java.io.*;
import javax.servlet.*;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String actionUrl = "";
		boolean ret;
		
		if(op == null){
			op = "show";
		}
		
		//try{
			if(op == null || op.equals("show")){
				actionUrl = "index.jsp";
			}else if(op.equals("create")){
				actionUrl = "index.jsp";
			}else if(op.equals("remove")){
				actionUrl = "index.jsp";
			}
		
	/*
	}catch(SQLException | NamingException e){
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
			actionUrl = "index.jsp";
		}
		*/
		
			
		
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
	 
	
	
	
	
	public String testid = "aa";
	 public String testpw = "1234";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean ret = false;
		String actionUrl = "";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user");
		String name = request.getParameter("name");
		
		//test.setId(id);
		//test.setName(name);
		
		//
		
		
		 String pw = request.getParameter("passwd");
		 
		  response.setContentType("text/html;charset=UTF-8");  
		  PrintWriter out = response.getWriter();
		  out.println("<HTML><BODY>");
		  out.println("<B><BR>");
		  if(testid.equals(id) && testpw.equals(pw))
		   {
		   out.println("반갑습니다.<BR>");
		   out.println("당신의 아이디는 "+ id + " 입니다.<BR>");
		   out.println("그리고 당신의 암호는 "+ pw +" 입니다.<BR>");
		   
		   HttpSession session = request.getSession();
		   session.setAttribute("userid", testid);
		   response.sendRedirect("login");
		   
		  }
		  else if(testid.equals(id) && !testpw.equals(pw))
		   {
		   out.println("암호가 맞지 않습니다.<BR>");
		   out.println("<A href=/Login.html>LOGIN</A>");
		  }
		  else
		   {
		   out.println("당신은 등록되지 않은 사용자 입니다. 다시 로그인 하세요.<BR>");
		   out.println("<A href=/Login.html>LOGIN</A>");
		  }
		  out.println("</B>");
		  out.println("</BODY></HTML>");
		  out.close();  
		 

		//
		  
		  
		  
		  
		  
		  /*
		try{
			if(isRegisterMode(request)){
				actionUrl = "index.jsp";
			}
		}catch(SQLException | NamingException e){
			actionUrl = "index.jsp";
		}
		*/
		  actionUrl="index.jsp";
		  if(pw.equals("1234"))
			{
				actionUrl="come1.jsp";
			}
		//request.setAttribute("errorMsgs",test);
		RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
		dispatcher.forward(request, response);
	}

}

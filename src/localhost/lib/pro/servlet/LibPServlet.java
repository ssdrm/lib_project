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
			op = "index.jsp";
		}
		try{
			if(op == null || op.equals("show")){
				actionUrl = "index.jsp";
			}else if(op.equals("create")){
				actionUrl = "index.jsp";
			}else if(op.equals("remove")){
				actionUrl = "index.jsp";
			}
		}catch(SQLException | NamingException e){
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
			actionUrl = "index.jsp";
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
		boolean ret = false;
		String actionUrl = "";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		//test.setId(id);
		//test.setName(name);
		
		try{
			if(isRegisterMode(request)){
				actionUrl = "index.jsp";
			}
		}catch(SQLException | NamingException e){
			actionUrl = "index.jsp";
		}
		//request.setAttribute("errorMsgs",test);
		RequestDispatcher dispatcher = request.getRequestDispatcher(actionUrl);
		dispatcher.forward(request, response);
	}

}

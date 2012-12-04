package localhost.lib.pro;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class LibPDAO {
	public static DataSource getDataSource() throws NamingException{
		Context initCtx = null;
		Context envCtx = null;
		
		initCtx = new InitialContext();
		envCtx = (Context) initCtx.lookup("java:comp/env");
		
		return (DataSource) envCtx.lookup("jdbc/WebDB");
	}
///////////////////////////////////////////////////////////////////////////////////페이지로보여줄 게시판
	public static Pagelist<Board> getBoard(int page, int numItemsInPage, String btype) throws SQLException, NamingException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		if(page <= 0){
			page = 1;
		}
		
		DataSource ds = getDataSource();
		Pagelist<Board> result = new Pagelist<Board>(numItemsInPage, page);
		
		int startPos = (page - 1) * numItemsInPage;
		
		try{
			conn = ds.getConnection();
			stmt = conn.prepareStatement("SELECT COUNT(*) FROM board WHERE bdtype = ?");
			stmt.setString(1,btype);
			rs = stmt.executeQuery();
			rs.next();
			
			result.setNumItems(rs.getInt(1));
			
			rs.close();
			rs = null;
			stmt.close();
			stmt = null;
			
			stmt = conn.prepareStatement("SELECT * FROM board WHERE bdtype = ? ORDER BY bdnumber DESC LIMIT " + startPos + ", " + numItemsInPage);
			stmt.setString(1, btype);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				result.getList().add(
						new Board(rs.getInt("bdnumber"), rs.getString("id"),
								rs.getString("title"),rs.getString("bdcomment"), rs.getTimestamp("bd_date"),
								rs.getInt("hits"), rs.getString("parent_id"), rs.getString("bdtype")));
			}
		}finally{
			if (rs != null) try{rs.close();} catch(SQLException e) {}
			if (stmt != null) try{stmt.close();} catch(SQLException e) {}
			if (conn != null) try{conn.close();} catch(SQLException e) {}
		}
		return result;
	}
/////////////////////////////////////////////////////////////////////////////////////////인덱스에보여줄게시판
	public static Showlist<Board> INboard(String typebd) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Showlist<Board> result = new Showlist<Board>();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM board where bdtype = ? order by bdnumber desc limit 3");
			stmt.setString(1, typebd);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Board(rs.getInt("bdnumber"), rs.getString("id"),
								rs.getString("title"),rs.getString("bdcomment"), rs.getTimestamp("bd_date"),
								rs.getInt("hits"), rs.getString("parent_id"), rs.getString("bdtype")));
			}
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException e) {}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}

		return result;
	}
	
	
	
	
////////////////////////////////////////////////////////////////////////////한페이지안에 학생정보찾기
public static Showlist<Student> stufind() throws NamingException, SQLException{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		DataSource ds = getDataSource();
		Showlist<Student> result = new Showlist<Student>();
		try{
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM student");
			
			while(rs.next()){
				result.getList().add(new Student(rs.getString("id"),rs.getString("name")));
			}
		} finally{
			if(rs!=null) try{rs.close();} catch(SQLException e){}
			if(stmt!=null) try{stmt.close();} catch(SQLException e){}
			if(conn!=null) try{conn.close();} catch(SQLException e){}
		}
		
		return result;
	}

//////////////////////////////////////////////////////////////////////////////////////login
	public static User login(String idd) throws NamingException, SQLException{
	User user = null;
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	DataSource ds = getDataSource();
	
	try {
		conn = ds.getConnection();

		// 질의 준비
		stmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
		stmt.setString(1, idd);
		
		// 수행
		rs = stmt.executeQuery();

		if (rs.next()) {
			user = new User(rs.getString("id"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("admintype"));
		}	
	} finally {
		// 무슨 일이 있어도 리소스를 제대로 종료
		if (rs != null) try{rs.close();} catch(SQLException e) {}
		if (stmt != null) try{stmt.close();} catch(SQLException e) {}
		if (conn != null) try{conn.close();} catch(SQLException e) {}
	}
	
	return user;
}



/////////////////////////////////////////////////////////////////////////////////////페이지 책검색
public static Pagelist<Books> Serchbooks(int page, int numItemsInPage, String sbook) throws NamingException, SQLException {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	if(page <= 0){
		page = 1;
	}
	if(sbook == null){
		sbook = "";
	}else{
		sbook = "%" + sbook + "%";
	}

	DataSource ds = getDataSource();
	Pagelist<Books> result = new Pagelist<Books>(numItemsInPage, page);
	
	int startPos = (page - 1) * numItemsInPage;
	
	try {
		conn = ds.getConnection();
		stmt = conn.prepareStatement("SELECT count(*) FROM books where b_name like ?");
		stmt.setString(1, sbook);
		rs = stmt.executeQuery();
		
		rs.next();
		
		result.setNumItems(rs.getInt(1));
		
		rs.close();
		rs = null;
		stmt.close();
		stmt = null;
		
		stmt = conn.prepareStatement("SELECT * FROM books where b_name like ? LIMIT " + startPos + ", " + numItemsInPage);
		stmt.setString(1, sbook);
		
		rs = stmt.executeQuery();

		while (rs.next()) {
			result.getList().add(
					new Books(rs.getInt("b_number"), rs.getString("b_name"),
							rs.getString("writer"),rs.getString("maker"), rs.getDate("b_date"),
							rs.getString("category"), rs.getInt("isbn"), rs.getString("location")));
		}
	} finally {
		if (rs != null)	try {rs.close();} catch (SQLException e) {}
		if (stmt != null) try {stmt.close();} catch (SQLException e) {}
		if (conn != null) try {conn.close();} catch (SQLException e) {}
	}

	return result;
}


//////////////////////////////////////////////////////////////////////////게시판 글 보이기
public static Board findByBoard(int bdnumber) throws NamingException, SQLException{
	Board board = null;
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	DataSource ds = getDataSource();
	
	try {
		conn = ds.getConnection();

		// 질의 준비
		stmt = conn.prepareStatement("SELECT * FROM board WHERE bdnumber = ?");
		stmt.setInt(1, bdnumber);
		
		// 수행
		rs = stmt.executeQuery();

		if (rs.next()) {
			board = new Board(rs.getInt("bdnumber"),
					rs.getString("id"),
					rs.getString("title"),
					rs.getString("bdcomment"),
					rs.getTimestamp("bd_date"),
					rs.getInt("hits"),
					rs.getString("parent_id"),
					rs.getString("bdtype"));
		}	
	} finally {
		// 무슨 일이 있어도 리소스를 제대로 종료
		if (rs != null) try{rs.close();} catch(SQLException e) {}
		if (stmt != null) try{stmt.close();} catch(SQLException e) {}
		if (conn != null) try{conn.close();} catch(SQLException e) {}
	}
	
	return board;
}


//////////////////////////////////////////////////////////////////////한페이지 책찾기
public static Showlist<Books> Serchbook(String sbook) throws NamingException, SQLException {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	if(sbook == null){
		sbook = "";
	}else{
		sbook = "%" + sbook + "%";
	}

	DataSource ds = getDataSource();
	Showlist<Books> result = new Showlist<Books>();
	
	try {
		conn = ds.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM books where b_name like ?");
		stmt.setString(1, sbook);
		
		rs = stmt.executeQuery();

		while (rs.next()) {
			result.getList().add(
					new Books(rs.getInt("b_number"), rs.getString("b_name"),
							rs.getString("writer"),rs.getString("maker"), rs.getDate("b_date"),
							rs.getString("category"), rs.getInt("isbn"), rs.getString("location")));
		}
	} finally {
		if (rs != null)	try {rs.close();} catch (SQLException e) {}
		if (stmt != null) try {stmt.close();} catch (SQLException e) {}
		if (conn != null) try {conn.close();} catch (SQLException e) {}
	}

	return result;
}




	/*
	public static borad findByNumber(int number) throws NamingException, SQLException{
		borad Borad = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		DataSource ds = getDataSource();
		
		try {
			conn = ds.getConnection();

			// 질의 준비
			stmt = conn.prepareStatement("SELECT * FROM borad WHERE number = ?");
			stmt.setInt(1, number);
			
			// 수행
			rs = stmt.executeQuery();

			if (rs.next()) {
				Borad = new borad(rs.getInt("number"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("comment"),
						rs.getString("date"));
			}	
		} finally {
			// 무슨 일이 있어도 리소스를 제대로 종료
			if (rs != null) try{rs.close();} catch(SQLException e) {}
			if (stmt != null) try{stmt.close();} catch(SQLException e) {}
			if (conn != null) try{conn.close();} catch(SQLException e) {}
		}
		
		return Borad;
	}
	*/
	/*
	public static boolean create(borad cre) throws NamingException,
			SQLException {
		int result;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("INSERT INTO borad(writer, title, comment) VALUES(?,?,?)");
			stmt.setString(1, cre.getWriter());
			stmt.setString(2, cre.getTitle());
			stmt.setString(3, cre.getComment());
			result = stmt.executeUpdate();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}

		return (result == 1);
	}
	*/
	/*

	public static boolean update(borad upd) throws NamingException,
			SQLException {
		int result;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("UPDATE borad SET writer = ?, title = ?, comment = ? WHERE number = ?");
			stmt.setString(1, upd.getWriter());
			stmt.setString(2, upd.getTitle());
			stmt.setString(3, upd.getComment());
			stmt.setInt(4, upd.getNumber());
			result = stmt.executeUpdate();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}

		return (result == 1);
	}
	*/
	/*
	
	public static boolean remove(int number) throws NamingException,
	SQLException {
		int result;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("DELETE FROM borad WHERE number = ?");
			stmt.setInt(1, number);
			result = stmt.executeUpdate();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}

		return (result == 1);
	}
	*/
	
}
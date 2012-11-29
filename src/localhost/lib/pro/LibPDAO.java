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
	
	/*
	public static Page<borad> getPage(int page, int numItemsInPage) throws SQLException, NamingException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		if(page <= 0){
			page = 1;
		}
		
		DataSource ds = getDataSource();
		Page<borad> result = new Page<borad>(numItemsInPage, page);
		
		int startPos = (page - 1) * numItemsInPage;
		
		try{
			conn = ds.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT COUNT(*) FROM borad");
			rs.next();
			
			result.setNumItems(rs.getInt(1));
			
			rs.close();
			rs = null;
			stmt.close();
			stmt = null;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM borad ORDER BY number LIMIT " + startPos + ", " + numItemsInPage);
			
			while(rs.next()){
				result.getList().add(new borad(rs.getInt("number"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("comment"),
						rs.getString("date")));
			}
		}finally{
			if (rs != null) try{rs.close();} catch(SQLException e) {}
			if (stmt != null) try{stmt.close();} catch(SQLException e) {}
			if (conn != null) try{conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	*/
	
	/*
	public static boradlist<borad> find() throws NamingException, SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		boradlist<borad> result = new boradlist<borad>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM borad");

			while (rs.next()) {
				result.getList().add(
						new borad(rs.getInt("number"), rs.getString("writer"),
								rs.getString("title"),rs.getString("comment"), rs.getString("date")));
			}
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException e) {}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}

		return result;
	}
	*/
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

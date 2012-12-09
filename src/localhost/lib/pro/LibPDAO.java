package localhost.lib.pro;

import java.sql.*;
import java.util.Calendar;

import javax.naming.*;
import javax.sql.*;

public class LibPDAO {
	public static DataSource getDataSource() throws NamingException {
		Context initCtx = null;
		Context envCtx = null;

		initCtx = new InitialContext();
		envCtx = (Context) initCtx.lookup("java:comp/env");

		return (DataSource) envCtx.lookup("jdbc/WebDB");
	}

	private static java.sql.Timestamp stamp2(java.sql.Timestamp bordate) {
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
	
	private static java.sql.Timestamp stamp3(java.sql.Timestamp bordate) {
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
		cal.set(year, month-1, day+21, hour, minit, secon);
		java.sql.Timestamp date = new java.sql.Timestamp(cal.getTimeInMillis());
		return date;
	}
	// /////////////////////////////////////////////////////////////////////////////////페이지로보여줄
	// 게시판
	public static Pagelist<Board> getBoard(int page, int numItemsInPage,
			String btype) throws SQLException, NamingException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		if (page <= 0) {
			page = 1;
		}

		DataSource ds = getDataSource();
		Pagelist<Board> result = new Pagelist<Board>(numItemsInPage, page);

		int startPos = (page - 1) * numItemsInPage;

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT COUNT(*) FROM board WHERE bdtype = ?");
			stmt.setString(1, btype);
			rs = stmt.executeQuery();
			rs.next();

			result.setNumItems(rs.getInt(1));

			rs.close();
			rs = null;
			stmt.close();
			stmt = null;

			stmt = conn
					.prepareStatement("SELECT * FROM board WHERE bdtype = ? ORDER BY bdnumber DESC LIMIT "
							+ startPos + ", " + numItemsInPage);
			stmt.setString(1, btype);
			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Board(rs.getInt("bdnumber"), rs.getString("id"), rs
								.getString("title"), rs.getString("bdcomment"),
								rs.getTimestamp("bd_date"), rs.getInt("hits"),
								rs.getString("parent_id"), rs
										.getString("bdtype")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return result;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////인덱스에보여줄게시판
	public static Showlist<Board> INboard(String typebd)
			throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Showlist<Board> result = new Showlist<Board>();
		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT * FROM board where bdtype = ? order by bdnumber desc limit 3");
			stmt.setString(1, typebd);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Board(rs.getInt("bdnumber"), rs.getString("id"), rs
								.getString("title"), rs.getString("bdcomment"),
								rs.getTimestamp("bd_date"), rs.getInt("hits"),
								rs.getString("parent_id"), rs
										.getString("bdtype")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}

	// //////////////////////////////////////////////////////////////////////////한페이지안에
	// 학생정보찾기
	public static Showlist<Student> stufind() throws NamingException,
			SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Showlist<Student> result = new Showlist<Student>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM student");

			while (rs.next()) {
				result.getList().add(
						new Student(rs.getString("id"), rs.getString("name")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	//학생아이디로 찾기
	public static Student stufindid(String id) throws NamingException,
	SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Student result = new Student();
		try {
			conn = ds.getConnection();

			// 질의 준비
			stmt = conn.prepareStatement("SELECT * FROM student WHERE id = ?");
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
			}
		} finally {
			if (rs != null)
		try {
			rs.close();
		} catch (SQLException e) {
		}
	if (stmt != null)
		try {
			stmt.close();
		} catch (SQLException e) {
		}
	if (conn != null)
		try {
			conn.close();
		} catch (SQLException e) {
		}
		}

		return result;
	}

	////////////////////////////////////////////////////////////////////유저정보
	public static Showlist<User> usefind() throws NamingException,
	SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Showlist<User> result = new Showlist<User>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");

			while (rs.next()) {
				result.getList().add(
						new User(rs.getString("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"),rs.getString("phone"),rs.getString("admintype")));
	}
	} finally {
	if (rs != null)
		try {
			rs.close();
		} catch (SQLException e) {
		}
	if (stmt != null)
		try {
			stmt.close();
		} catch (SQLException e) {
		}
	if (conn != null)
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	return result;
	}
	
	///////////////////////////////////////////////유저한명찾기
	public static User usefindid(String id) throws NamingException,
	SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		User result = new User();
		try {
			conn = ds.getConnection();

			// 질의 준비
			stmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setPassword(rs.getString("password"));
				result.setEmail(rs.getString("email"));
				result.setPhone(rs.getString("phone"));
				result.setAdmintype(rs.getString("admintype"));
			}
		} finally {
			if (rs != null)
		try {
			rs.close();
		} catch (SQLException e) {
		}
	if (stmt != null)
		try {
			stmt.close();
		} catch (SQLException e) {
		}
	if (conn != null)
		try {
			conn.close();
		} catch (SQLException e) {
		}
		}

		return result;
	}
	// ////////////////////////////////////////////////////////////////////////////////////login
	public static User login(String idd) throws NamingException, SQLException {
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
				user = new User(rs.getString("id"), rs.getString("name"),
						rs.getString("password"), rs.getString("email"),
						rs.getString("phone"), rs.getString("admintype"));
			}
		} finally {
			// 무슨 일이 있어도 리소스를 제대로 종료
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return user;
	}

	// ///////////////////////////////////////////////////////////////////////////////////페이지
	// 책검색
	public static Pagelist<Books> Serchbooks(int page, int numItemsInPage,
			String sbook) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (page <= 0) {
			page = 1;
		}
		if (sbook == null) {
			sbook = "";
		} else {
			sbook = "%" + sbook + "%";
		}

		DataSource ds = getDataSource();
		Pagelist<Books> result = new Pagelist<Books>(numItemsInPage, page);

		int startPos = (page - 1) * numItemsInPage;

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT count(*) FROM books where b_name like ?");
			stmt.setString(1, sbook);
			rs = stmt.executeQuery();

			rs.next();

			result.setNumItems(rs.getInt(1));

			rs.close();
			rs = null;
			stmt.close();
			stmt = null;

			stmt = conn
					.prepareStatement("SELECT * FROM books where b_name like ? LIMIT "
							+ startPos + ", " + numItemsInPage);
			stmt.setString(1, sbook);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Books(rs.getInt("b_number"),
								rs.getString("b_name"), rs.getString("writer"),
								rs.getString("maker"), rs.getDate("b_date"), rs
										.getString("category"), rs
										.getInt("isbn"), rs
										.getString("location")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}

	// ////////////////////////////////////////////////////////////////////////게시판
	// 글 보이기
	public static Board findByBoard(int bdnumber) throws NamingException,
			SQLException {
		Board board = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();

		try {
			conn = ds.getConnection();

			// 질의 준비
			stmt = conn
					.prepareStatement("SELECT * FROM board WHERE bdnumber = ?");
			stmt.setInt(1, bdnumber);

			// 수행
			rs = stmt.executeQuery();

			if (rs.next()) {
				board = new Board(rs.getInt("bdnumber"), rs.getString("id"),
						rs.getString("title"), rs.getString("bdcomment"),
						rs.getTimestamp("bd_date"), rs.getInt("hits"),
						rs.getString("parent_id"), rs.getString("bdtype"));
			}
		} finally {
			// 무슨 일이 있어도 리소스를 제대로 종료
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return board;
	}

	// ////////////////////////////////////////////////////////////////////한페이지
	// 책찾기
	public static Showlist<Books> Serchbook(String sbook)
			throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (sbook == null) {
			sbook = "";
		} else {
			sbook = "%" + sbook + "%";
		}

		DataSource ds = getDataSource();
		Showlist<Books> result = new Showlist<Books>();

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT * FROM books where b_name like ?");
			stmt.setString(1, sbook);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Books(rs.getInt("b_number"),
								rs.getString("b_name"), rs.getString("writer"),
								rs.getString("maker"), rs.getDate("b_date"), rs
										.getString("category"), rs
										.getInt("isbn"), rs
										.getString("location")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	//정확한책찾기
	public static Books bookname(String b_name)
			throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Books result = new Books();

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT * FROM books where b_name = ?");
			stmt.setString(1, b_name);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result = new Books(rs.getInt("b_number"), rs.getString("b_name"), rs.getString("writer"), rs.getString("maker"), rs.getDate("b_date"), rs .getString("category"), rs .getInt("isbn"), rs .getString("location"));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	//코멘트(책검사)
	public static Books commentserch(int b_number)
			throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Books result = new Books();

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT * FROM books where b_number = ?");
			stmt.setInt(1, b_number);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result = new Books(rs.getInt("b_number"), rs.getString("b_name"), rs.getString("writer"), rs.getString("maker"), rs.getDate("b_date"), rs .getString("category"), rs .getInt("isbn"), rs .getString("location"));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	//코멘트보기
	public static Showlist<Bookcomment> showcom(int b_number)
			throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Showlist<Bookcomment> result = new Showlist<Bookcomment>();

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT * FROM bookcomment where b_number = ?");
			stmt.setInt(1, b_number);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(new Bookcomment(rs.getInt("conum"), rs.getString("id"), rs.getString("co_comment"), rs.getTimestamp("co_date"), rs.getInt("b_number")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	//신청자료조회
	public static Showlist<Import> showimpo()
			throws NamingException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Showlist<Import> result = new Showlist<Import>();

		try {
			conn = ds.getConnection();
			stmt = conn
					.createStatement();

			rs = stmt.executeQuery("SELECT * FROM import");

			while (rs.next()) {
				result.getList().add(new Import(rs.getInt("im_number"), rs.getTimestamp("importdate"), rs.getString("bookname"), rs.getString("bookwriter"), rs.getString("bookmaker"),rs.getString("reason"),rs.getString("status"),rs.getString("id")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	//신청자료조회(아이디)
	public static Showlist<Import> showimpoid(String id)
			throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();
		Showlist<Import> result = new Showlist<Import>();

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT * FROM import where id = ?");
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(new Import(rs.getInt("im_number"), rs.getTimestamp("importdate"), rs.getString("bookname"), rs.getString("bookwriter"), rs.getString("bookmaker"),rs.getString("reason"),rs.getString("status"),rs.getString("id")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	//책빌리기(책검사)
	public static Showlist<Books> Saddborbook(String sbook)
			throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (sbook == null) {
			sbook = "";
		} else {
			sbook = "%" + sbook + "%";
		}

		DataSource ds = getDataSource();
		Showlist<Books> result = new Showlist<Books>();

		try {
			conn = ds.getConnection();
			stmt = conn
					.prepareStatement("SELECT * FROM books where b_name like ? and b_number not in(select b_number from borrow where ifnull(returndate, 0)=0)");
			stmt.setString(1, sbook);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Books(rs.getInt("b_number"),
								rs.getString("b_name"), rs.getString("writer"),
								rs.getString("maker"), rs.getDate("b_date"), rs
										.getString("category"), rs
										.getInt("isbn"), rs
										.getString("location")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	//책반납(책검사)
		public static Showlist<Bookborrow> Sreborbook(String sbook)
				throws NamingException, SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			if (sbook == null) {
				sbook = "";
			} else {
				sbook = "%" + sbook + "%";
			}

			DataSource ds = getDataSource();
			Showlist<Bookborrow> result = new Showlist<Bookborrow>();

			try {
				conn = ds.getConnection();
				stmt = conn
						.prepareStatement("SELECT * FROM borrow, books where borrow.b_number = books.b_number and ifnull(returndate, 0) = 0 and b_name like ?");
				stmt.setString(1, sbook);

				rs = stmt.executeQuery();

				while (rs.next()) {
					result.getList().add(
							new Bookborrow(rs.getInt("b_number"),
									rs.getString("b_name"), rs.getString("writer"),
									rs.getString("maker"), rs.getDate("b_date"), rs
											.getString("category"), rs
											.getInt("isbn"), rs
											.getString("location"),rs.getInt("bw_number"),rs.getString("id")
											,rs.getTimestamp("borrowdate"),rs.getDate("returndate"),rs.getInt("extendate"),rs.getInt("delaydate"),stamp2(rs.getTimestamp("borrowdate")),stamp3(rs.getTimestamp("borrowdate"))));
				}
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
					}
			}

			return result;
		}
		//대출 모든 책 찾기
				public static Showlist<Bookborrow> Sborbook(String sbook)
						throws NamingException, SQLException {
					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					if (sbook == null) {
						sbook = "";
					} else {
						sbook = "%" + sbook + "%";
					}

					DataSource ds = getDataSource();
					Showlist<Bookborrow> result = new Showlist<Bookborrow>();

					try {
						conn = ds.getConnection();
						stmt = conn
								.prepareStatement("SELECT * FROM borrow, books where borrow.b_number = books.b_number and b_name like ? order by borrowdate");
						stmt.setString(1, sbook);

						rs = stmt.executeQuery();

						while (rs.next()) {
							result.getList().add(
									new Bookborrow(rs.getInt("b_number"),
											rs.getString("b_name"), rs.getString("writer"),
											rs.getString("maker"), rs.getDate("b_date"), rs
													.getString("category"), rs
													.getInt("isbn"), rs
													.getString("location"),rs.getInt("bw_number"),rs.getString("id")
													,rs.getTimestamp("borrowdate"),rs.getDate("returndate"),rs.getInt("extendate"),rs.getInt("delaydate"),stamp2(rs.getTimestamp("borrowdate")),stamp3(rs.getTimestamp("borrowdate"))));
						}
					} finally {
						if (rs != null)
							try {
								rs.close();
							} catch (SQLException e) {
							}
						if (stmt != null)
							try {
								stmt.close();
							} catch (SQLException e) {
							}
						if (conn != null)
							try {
								conn.close();
							} catch (SQLException e) {
							}
					}

					return result;
				}
				
				//유저명으로 대출조회
				public static Showlist<Bookborrow> boruser(String id)
						throws NamingException, SQLException {
					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
					DataSource ds = getDataSource();
					Showlist<Bookborrow> result = new Showlist<Bookborrow>();

					try {
						conn = ds.getConnection();
						stmt = conn
								.prepareStatement("SELECT * FROM borrow, books where borrow.b_number = books.b_number and id = ? order by returndate");
						stmt.setString(1, id);

						rs = stmt.executeQuery();

						while (rs.next()) {
							result.getList().add(
									new Bookborrow(rs.getInt("b_number"),
											rs.getString("b_name"), rs.getString("writer"),
											rs.getString("maker"), rs.getDate("b_date"), rs
													.getString("category"), rs
													.getInt("isbn"), rs
													.getString("location"),rs.getInt("bw_number"),rs.getString("id")
													,rs.getTimestamp("borrowdate"),rs.getDate("returndate"),rs.getInt("extendate"),rs.getInt("delaydate"),stamp2(rs.getTimestamp("borrowdate")),stamp3(rs.getTimestamp("borrowdate"))));
						}
					} finally {
						if (rs != null)
							try {
								rs.close();
							} catch (SQLException e) {
							}
						if (stmt != null)
							try {
								stmt.close();
							} catch (SQLException e) {
							}
						if (conn != null)
							try {
								conn.close();
							} catch (SQLException e) {
							}
					}

					return result;
				}
				
				//성향분석
				public static Showlist<Categorib> categorib(String id)
						throws NamingException, SQLException {
					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;

					DataSource ds = getDataSource();
					Showlist<Categorib> result = new Showlist<Categorib>();

					try {
						conn = ds.getConnection();
						stmt = conn
								.prepareStatement("SELECT category, count(*) FROM books, borrow where books.b_number = borrow.b_number and id = ? group by category");
						stmt.setString(1, id);

						rs = stmt.executeQuery();

						while (rs.next()) {
							result.getList().add(new Categorib(rs.getString("category"), rs.getInt("count(*)")));
						}
					} finally {
						if (rs != null)
							try {
								rs.close();
							} catch (SQLException e) {
							}
						if (stmt != null)
							try {
								stmt.close();
							} catch (SQLException e) {
							}
						if (conn != null)
							try {
								conn.close();
							} catch (SQLException e) {
							}
					}

					return result;
				}
				
	//isbn검사
	public static int isbnbook(int tempisbn, int intisbn) throws NamingException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DataSource ds = getDataSource();

		try {
			conn = ds.getConnection();
			stmt = conn
					.createStatement();

			rs = stmt.executeQuery("SELECT isbn FROM books WHERE isbn like '" + tempisbn + "%'");

			while (rs.next()) {
				if(intisbn != rs.getInt(1)){
					intisbn++;
				}else{
				}
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		intisbn++;
		return intisbn;
	}

	// ////////////////////////////////////////////////////////////////////한페이지
	// 상세책찾기
	public static Showlist<Books> DeSerchbook(String skey1, String skey2,
			String skey3, String dsop1, String dsops1, String dsop20,
			String dsop2, String dsops2, String dsop30, String dsop3,
			String dsops3, String dsop40, String dsop4, String dsops4,
			String cate0, String cate1, String cate2, String cate3,
			String cate4, String cate5, String cate6, String cate7,
			String cate8, String cate9) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String cateop;
		if (cate0 == null && cate1 == null && cate2 == null && cate3 == null
				&& cate4 == null && cate5 == null && cate6 == null
				&& cate7 == null && cate8 == null && cate9 == null) {
			cateop = "or";
		} else {
			cateop = "and";
		}
		if (skey1.equals("m")) {
			if (dsops2 == "") {
				dsop20 = "and";
			}
			if (dsops3 == "") {
				dsop30 = "and";
			}
			if (dsops4 == "") {
				dsop40 = "and";
			}
			dsops1 = "%" + dsops1 + "%";
			dsops2 = "%" + dsops2 + "%";
			dsops3 = "%" + dsops3 + "%";
			dsops4 = "%" + dsops4 + "%";
		} else if (skey2.equals("m")) {
			if (dsops2 == "") {
				dsop20 = "and";
			}
			if (dsops3 == "") {
				dsop30 = "and";
			}
			if (dsops4 == "") {
				dsop40 = "and";
			}
			dsops1 = dsops1 + "%";
			dsops2 = dsops2 + "%";
			dsops3 = dsops3 + "%";
			dsops4 = dsops4 + "%";
		}
		DataSource ds = getDataSource();
		Showlist<Books> result = new Showlist<Books>();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement("select * from books where " + dsop1 + " like ? "
							+ dsop20 + " " + dsop2 + " like ? " + dsop30 + " " + dsop3 + " like ? "
							+ dsop40 + " " + dsop4 + " like ? " + cateop + " (category = ? or category = ? or category = ? or category = ? or category = ? or category = ? or category = ? or category = ? or category = ? or category = ?)");
			stmt.setString(1, dsops1);
			stmt.setString(2, dsops2);
			stmt.setString(3, dsops3);
			stmt.setString(4, dsops4);
			stmt.setString(5, cate0);
			stmt.setString(6, cate1);
			stmt.setString(7, cate2);
			stmt.setString(8, cate3);
			stmt.setString(9, cate4);
			stmt.setString(10, cate5);
			stmt.setString(11, cate6);
			stmt.setString(12, cate7);
			stmt.setString(13, cate8);
			stmt.setString(14, cate9);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Books(rs.getInt("b_number"),
								rs.getString("b_name"), rs.getString("writer"),
								rs.getString("maker"), rs.getDate("b_date"), rs
										.getString("category"), rs
										.getInt("isbn"), rs
										.getString("location")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}

	// ////////////////////////////////////////////////////////////////////한페이지
	// 연속간행책찾기
	public static Showlist<Books> SeSerchbook(String skey1, String skey2,
			String skey3, String dsop1, String dsops1, String dsop20,
			String dsop2, String dsops2) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (skey1.equals("m")) {
			if (dsops2 == "") {
				dsop20 = "and";
			}
			dsops1 = "%" + dsops1 + "%";
			dsops2 = "%" + dsops2 + "%";
		} else if (skey2.equals("m")) {
			if (dsops2 == "") {
				dsop20 = "and";
			}
			dsops1 = dsops1 + "%";
			dsops2 = dsops2 + "%";
		}
		DataSource ds = getDataSource();
		Showlist<Books> result = new Showlist<Books>();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement("select * from books where (" + dsop1 + " like ? " + dsop20 + " " + dsop2 + " like ?) and (location like '%nal')");
			stmt.setString(1, dsops1);
			stmt.setString(2, dsops2);

			rs = stmt.executeQuery();

			while (rs.next()) {
				result.getList().add(
						new Books(rs.getInt("b_number"),
								rs.getString("b_name"), rs.getString("writer"),
								rs.getString("maker"), rs.getDate("b_date"), rs
										.getString("category"), rs
										.getInt("isbn"), rs
										.getString("location")));
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}
	
	// ////////////////////////////////////////////////////////////////////한페이지
		// 고서책찾기
		public static Showlist<Books> OlSerchbook(String skey1, String skey2,
				String skey3, String dsop1, String dsops1, String dsop20,
				String dsop2, String dsops2) throws NamingException, SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			if (skey1.equals("m")) {
				if (dsops2 == "") {
					dsop20 = "and";
				}
				dsops1 = "%" + dsops1 + "%";
				dsops2 = "%" + dsops2 + "%";
			} else if (skey2.equals("m")) {
				if (dsops2 == "") {
					dsop20 = "and";
				}
				dsops1 = dsops1 + "%";
				dsops2 = dsops2 + "%";
			}
			DataSource ds = getDataSource();
			Showlist<Books> result = new Showlist<Books>();
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement("select * from books where (" + dsop1 + " like ? " + dsop20 + " " + dsop2 + " like ?) and (b_date < '1960-01-01')");
				stmt.setString(1, dsops1);
				stmt.setString(2, dsops2);

				rs = stmt.executeQuery();

				while (rs.next()) {
					result.getList().add(
							new Books(rs.getInt("b_number"),
									rs.getString("b_name"), rs.getString("writer"),
									rs.getString("maker"), rs.getDate("b_date"), rs
											.getString("category"), rs
											.getInt("isbn"), rs
											.getString("location")));
				}
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
					}
			}

			return result;
		}
	/*
	 * public static borad findByNumber(int number) throws NamingException,
	 * SQLException{ borad Borad = null;
	 * 
	 * Connection conn = null; PreparedStatement stmt = null; ResultSet rs =
	 * null;
	 * 
	 * DataSource ds = getDataSource();
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * // 질의 준비 stmt =
	 * conn.prepareStatement("SELECT * FROM borad WHERE number = ?");
	 * stmt.setInt(1, number);
	 * 
	 * // 수행 rs = stmt.executeQuery();
	 * 
	 * if (rs.next()) { Borad = new borad(rs.getInt("number"),
	 * rs.getString("writer"), rs.getString("title"), rs.getString("comment"),
	 * rs.getString("date")); } } finally { // 무슨 일이 있어도 리소스를 제대로 종료 if (rs !=
	 * null) try{rs.close();} catch(SQLException e) {} if (stmt != null)
	 * try{stmt.close();} catch(SQLException e) {} if (conn != null)
	 * try{conn.close();} catch(SQLException e) {} }
	 * 
	 * return Borad; }
	 */
		
		////////////////////////////////////////////////create문
		//학생추가
		public static boolean crestu(Student student) throws NamingException,SQLException { 
			int result; Connection conn = null; PreparedStatement stmt= null; ResultSet rs = null;
			DataSource ds = getDataSource(); 
			try { conn = ds.getConnection();
			stmt =conn.prepareStatement("INSERT INTO student(id, name) VALUE(?,?)");
			stmt.setString(1, student.getId()); 
			stmt.setString(2, student.getName());
			result = stmt.executeUpdate(); 
			}
	  finally { if (rs != null) try {rs.close();} catch (SQLException e) {} if
	  (stmt != null) try {stmt.close();} catch (SQLException e) {} if (conn !=
	  null) try {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); 
	  }
		
		//유저추가
		public static boolean creuse(User user) throws NamingException,SQLException { 
			int result; Connection conn = null; PreparedStatement stmt= null; ResultSet rs = null;
			DataSource ds = getDataSource(); 
			try { conn = ds.getConnection();
			stmt =conn.prepareStatement("INSERT INTO user(id, name, password, email, phone, admintype) VALUE(?,?,?,?,?,'F')");
			stmt.setString(1, user.getId()); 
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPhone());
			result = stmt.executeUpdate(); 
			}
	  finally { if (rs != null) try {rs.close();} catch (SQLException e) {} if
	  (stmt != null) try {stmt.close();} catch (SQLException e) {} if (conn !=
	  null) try {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); 
	  }
		//코멘트추가
		
		public static boolean crecom(String id, String co_comment, int b_number) throws NamingException,SQLException { 
			int result; Connection conn = null; PreparedStatement stmt= null; ResultSet rs = null;
			DataSource ds = getDataSource(); 
			try { conn = ds.getConnection();
			stmt =conn.prepareStatement("INSERT INTO bookcomment(id, co_comment, b_number) VALUE(?,?,?)");
			stmt.setString(1, id); 
			stmt.setString(2, co_comment);
			stmt.setInt(3, b_number);
			result = stmt.executeUpdate(); 
			}
	  finally { if (rs != null) try {rs.close();} catch (SQLException e) {} if
	  (stmt != null) try {stmt.close();} catch (SQLException e) {} if (conn !=
	  null) try {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); 
	  }
		//도서추가
		public static boolean creboo(Books books) throws NamingException,SQLException { 
			int result; Connection conn = null; PreparedStatement stmt= null; ResultSet rs = null;
			DataSource ds = getDataSource(); 
			try { conn = ds.getConnection();
			if(books.getCategory().equals("0")){
				books.setCategory("총류");
			}else if(books.getCategory().equals("1")){
				books.setCategory("철학");
			}else if(books.getCategory().equals("2")){
				books.setCategory("종교");
			}else if(books.getCategory().equals("3")){
				books.setCategory("사회과학");
			}else if(books.getCategory().equals("4")){
				books.setCategory("어학");
			}else if(books.getCategory().equals("5")){
				books.setCategory("자연과학");
			}else if(books.getCategory().equals("6")){
				books.setCategory("응용과학");
			}else if(books.getCategory().equals("7")){
				books.setCategory("예술");
			}else if(books.getCategory().equals("8")){
				books.setCategory("문학");
			}else if(books.getCategory().equals("9")){
				books.setCategory("역사");
			}
			stmt =conn.prepareStatement("INSERT INTO books(b_name, writer, maker, b_date, category, isbn, location) VALUE(?,?,?,?,?,?,?)");
			stmt.setString(1, books.getB_name()); 
			stmt.setString(2, books.getWriter());
			stmt.setString(3, books.getMaker());
			stmt.setDate(4, books.getB_date());
			stmt.setString(5, books.getCategory());
			stmt.setInt(6, books.getIsbn());
			stmt.setString(7, books.getLocation());
			result = stmt.executeUpdate(); 
			}
	  finally { if (rs != null) try {rs.close();} catch (SQLException e) {} if
	  (stmt != null) try {stmt.close();} catch (SQLException e) {} if (conn !=
	  null) try {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); 
	  }
	 
		//대출추가
		public static boolean crebor(int b_number, String id) throws NamingException,SQLException { 
			int result; Connection conn = null; PreparedStatement stmt= null; ResultSet rs = null;
			DataSource ds = getDataSource(); 
			try { conn = ds.getConnection();
			stmt =conn.prepareStatement("INSERT INTO borrow(b_number, id) VALUE(?,?)");
			stmt.setInt(1, b_number); 
			stmt.setString(2, id);
			result = stmt.executeUpdate(); 
			}
	  finally { if (rs != null) try {rs.close();} catch (SQLException e) {} if
	  (stmt != null) try {stmt.close();} catch (SQLException e) {} if (conn !=
	  null) try {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); 
	  }
		
		//자료구입추가
		public static boolean creimp(Import imports) throws NamingException,SQLException { 
			int result; Connection conn = null; PreparedStatement stmt= null; ResultSet rs = null;
			DataSource ds = getDataSource(); 
			try { conn = ds.getConnection();
			stmt =conn.prepareStatement("INSERT INTO import(bookname, bookwriter, bookmaker, reason, id) VALUE(?,?,?,?,?)");
			stmt.setString(1, imports.getBookname()); 
			stmt.setString(2, imports.getBookwriter());
			stmt.setString(3, imports.getBookmaker());
			stmt.setString(4, imports.getReason());
			stmt.setString(5, imports.getId());
			result = stmt.executeUpdate(); 
			}
	  finally { if (rs != null) try {rs.close();} catch (SQLException e) {} if
	  (stmt != null) try {stmt.close();} catch (SQLException e) {} if (conn !=
	  null) try {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); 
	  }
	
	  /////////////////////////////////////////////////////////update
		//유저삭제(admintype을 O로)
	  public static boolean userrm(String id) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE user SET admintype = 'O' WHERE id = ?");
	  stmt.setString(1, id);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	  //관리자로승격
	  public static boolean userup(String id) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE user SET admintype = 'T' WHERE id = ?");
	  stmt.setString(1, id);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	  //관리자박탈
	  public static boolean userdown(String id) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE user SET admintype = 'F' WHERE id = ?");
	  stmt.setString(1, id);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	  //개인정보수정
	  public static boolean usech(String phone, String email, String id) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE user SET phone = ?, email = ? WHERE id = ?");
	  stmt.setString(1, phone);
	  stmt.setString(2, email);
	  stmt.setString(3, id);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	  //도서반납
	  public static boolean borretu(int bw_number, Date nowdate) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE borrow SET returndate = ? WHERE bw_number = ?");
	  stmt.setDate(1, nowdate);
	  stmt.setInt(2, bw_number);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	  //연장
	  public static boolean borex(int bw_number) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE borrow SET extendate = 1 WHERE bw_number = ?");
	  stmt.setInt(1, bw_number);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	  //자료구입
	  public static boolean upbookimpok(int im_number) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE import SET status = 'E' WHERE im_number = ?");
	  stmt.setInt(1, im_number);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	  //자료취소
	  public static boolean upbookimpca(int im_number) throws NamingException,
	  SQLException { int result; Connection conn = null; PreparedStatement stmt
	  = null; ResultSet rs = null;
	  
	  DataSource ds = getDataSource(); try { conn = ds.getConnection(); stmt =
	  conn .prepareStatement(
	  "UPDATE import SET status = 'C' WHERE im_number = ?");
	  stmt.setInt(1, im_number);
	  result = stmt.executeUpdate(); } finally { if (rs != null) try
	  {rs.close();} catch (SQLException e) {} if (stmt != null) try
	  {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); }
	  
	 
//////////////////////////////////////////삭제
		//학생삭제
	  public static boolean remstu(String id) throws NamingException, SQLException { 
		  int result; Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
	  	  DataSource ds = getDataSource(); 
	  	  try {
	  		  conn = ds.getConnection(); 
	  		  stmt = conn .prepareStatement("DELETE FROM student WHERE id = ?");
	  		  stmt.setString(1, id); 
	  		  result = stmt.executeUpdate(); 
	  } finally { if (rs
	  != null) try {rs.close();} catch (SQLException e) {} if (stmt != null)
	  try {stmt.close();} catch (SQLException e) {} if (conn != null) try
	  {conn.close();} catch (SQLException e) {} }
	  
	  return (result == 1); 
	  }
}

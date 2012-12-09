package localhost.lib.pro;

import java.sql.Date;
import java.sql.Timestamp;

public class Bookborrow {
	//b_number만 겹치는거
	private int b_number;
	private String b_name;
	private String writer;
	private String maker;
	private Date b_date;
	private String category;
	private int isbn;
	private String location;
	private int bw_number;
	private String id;
	private Timestamp borrowdate;
	private Date returndate;
	private int extendate;
	private int delaydate;
	private Timestamp bordate;
	private Timestamp borrdate;
	
	public Bookborrow(){
	}
	
	public Bookborrow(int b_number, String b_name, String writer, String maker, Date b_date, String category, int isbn, String location, int bw_number, String id ,Timestamp borrowdate, Date returndate, int extendate, int delaydate,Timestamp bordate, Timestamp borrdate){
		super();
		this.b_number = b_number;
		this.b_name = b_name;
		this.writer = writer;
		this.maker = maker;
		this.b_date = b_date;
		this.category = category;
		this.isbn = isbn;
		this.location = location;
		this.bw_number = bw_number;
		this.id = id;
		this.borrowdate = borrowdate;
		this.returndate = returndate;
		this.extendate = extendate;
		this.delaydate = delaydate;
		this.bordate = bordate;
		this.borrdate = borrdate;
	}

	public Timestamp getBorrdate() {
		return borrdate;
	}

	public void setBorrdate(Timestamp borrdate) {
		this.borrdate = borrdate;
	}

	public Timestamp getBordate() {
		return bordate;
	}

	public void setBordate(Timestamp bordate) {
		this.bordate = bordate;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getBw_number() {
		return bw_number;
	}

	public void setBw_number(int bw_number) {
		this.bw_number = bw_number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(Timestamp borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public int getExtendate() {
		return extendate;
	}

	public void setExtendate(int extendate) {
		this.extendate = extendate;
	}

	public int getDelaydate() {
		return delaydate;
	}

	public void setDelaydate(int delaydate) {
		this.delaydate = delaydate;
	}
	
}

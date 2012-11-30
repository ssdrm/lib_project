package localhost.lib.pro;

import java.sql.Date;

public class Books {
	private int b_number;
	private String b_name;
	private String writer;
	private String maker;
	private Date b_date;
	private String category;
	private int isbn;
	private String location;
	
	public Books(){
		
	}
	
	public Books(int b_number, String b_name, String writer, String maker, Date b_date, String category, int isbn, String location){
		super();
		this.b_number = b_number;
		this.b_name = b_name;
		this.writer = writer;
		this.maker = maker;
		this.b_date = b_date;
		this.category = category;
		this.isbn = isbn;
		this.location = location;
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
}

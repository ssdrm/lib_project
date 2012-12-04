package localhost.lib.pro;

import java.sql.Timestamp;
public class Bookcomment {
	private int conum;
	private String id;
	private String co_comment;
	private Timestamp co_date;
	private int b_number;
	
	public Bookcomment(){
	}
	
	public Bookcomment(int conum, String id, String co_comment, Timestamp co_date, int b_number){
		super();
		this.conum = conum;
		this.id = id;
		this.co_comment = co_comment;
		this.co_date = co_date;
		this.b_number = b_number;
	}

	public int getConum() {
		return conum;
	}

	public void setConum(int conum) {
		this.conum = conum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCo_comment() {
		return co_comment;
	}

	public void setCo_comment(String co_comment) {
		this.co_comment = co_comment;
	}

	public Timestamp getCo_date() {
		return co_date;
	}

	public void setCo_date(Timestamp co_date) {
		this.co_date = co_date;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

}

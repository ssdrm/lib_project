package localhost.lib.pro;

import java.sql.Timestamp;

public class Import {
	private int im_number;
	private Timestamp importdate;
	private String bookname;
	private String bookwriter;
	private String bookmaker;
	private String reason;
	private String status;
	private String id;

	public Import(){
	}
	
	public Import(int im_number, Timestamp importdate, String bookname, String bookwriter, String bookmaker, String reason, String status, String id){
		super();
		this.im_number = im_number;
		this.importdate = importdate;
		this.bookname = bookname;
		this.bookwriter = bookwriter;
		this.bookmaker = bookmaker;
		this.reason = reason;
		this.status = status;
		this.id = id;
	}

	public int getIm_number() {
		return im_number;
	}

	public void setIm_number(int im_number) {
		this.im_number = im_number;
	}

	public Timestamp getImportdate() {
		return importdate;
	}

	public void setImportdate(Timestamp importdate) {
		this.importdate = importdate;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookwriter() {
		return bookwriter;
	}

	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}

	public String getBookmaker() {
		return bookmaker;
	}

	public void setBookmaker(String bookmaker) {
		this.bookmaker = bookmaker;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

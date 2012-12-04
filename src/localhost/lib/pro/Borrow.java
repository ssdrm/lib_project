package localhost.lib.pro;
import java.sql.Date;
import java.sql.Timestamp;

public class Borrow {
	private int bw_number;
	private int b_number;
	private String id;
	private Timestamp borrowdate;
	private Date returndate;
	private int extendate;
	private int delaydate;
	
	public Borrow(){
	}
	
	public Borrow(int bw_number, int b_number, String id ,Timestamp borrowdate, Date returndate, int extendate, int delaydate){
		super();
		this.bw_number = bw_number;
		this.b_number = b_number;
		this.id = id;
		this.borrowdate = borrowdate;
		this.returndate = returndate;
		this.extendate = extendate;
		this.delaydate = delaydate;
	}

	public int getBw_number() {
		return bw_number;
	}

	public void setBw_number(int bw_number) {
		this.bw_number = bw_number;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
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

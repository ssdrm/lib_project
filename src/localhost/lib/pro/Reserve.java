package localhost.lib.pro;

import java.sql.Timestamp;

public class Reserve {
	private int re_number;
	private String id;
	private int b_number;
	private Timestamp reservedate;
	private String reserveinfo;
	
	public Reserve(){
	}
	
	public Reserve(int re_number, String id, int b_number, Timestamp reservedate, String reserveinfo){
		super();
		this.re_number = re_number;
		this.id = id;
		this.b_number = b_number;
		this.reservedate = reservedate;
		this.reserveinfo = reserveinfo;
	}

	public int getRe_number() {
		return re_number;
	}

	public void setRe_number(int re_number) {
		this.re_number = re_number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public Timestamp getReservedate() {
		return reservedate;
	}

	public void setReservedate(Timestamp reservedate) {
		this.reservedate = reservedate;
	}

	public String getReserveinfo() {
		return reserveinfo;
	}

	public void setReserveinfo(String reserveinfo) {
		this.reserveinfo = reserveinfo;
	}

}

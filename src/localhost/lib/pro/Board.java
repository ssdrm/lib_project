package localhost.lib.pro;

import java.sql.Timestamp;

public class Board {
	private int bdnumber;
	private String id;
	private String title;
	private String bdcomment;
	private Timestamp bd_date;
	private int hits;
	private String parent_id;
	private String bdtype;
	
	public Board(){
	}
	
	public Board(int bdnumber, String id, String title, String bdcomment, Timestamp bd_date, int hits, String parent_id, String bdtype){
		super();
		this.bdnumber = bdnumber;
		this.id = id;
		this.title = title;
		this.bdcomment = bdcomment;
		this.bd_date = bd_date;
		this.hits = hits;
		this.parent_id = parent_id;
		this.bdtype = bdtype;
	}

	public int getBdnumber() {
		return bdnumber;
	}

	public void setBdnumber(int bdnumber) {
		this.bdnumber = bdnumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBdcomment() {
		return bdcomment;
	}

	public void setBdcomment(String bdcomment) {
		this.bdcomment = bdcomment;
	}

	public Timestamp getBd_date() {
		return bd_date;
	}

	public void setBd_date(Timestamp bd_date) {
		this.bd_date = bd_date;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getBdtype() {
		return bdtype;
	}

	public void setBdtype(String bdtype) {
		this.bdtype = bdtype;
	}

}

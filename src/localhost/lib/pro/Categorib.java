package localhost.lib.pro;

public class Categorib {
	private String scategory;
	private int category;
	
	public Categorib(){
	}
	
	public Categorib(String scategory, int category){
		super();
		this.scategory = scategory;
		this.category = category;
	}

	public String getScategory() {
		return scategory;
	}

	public void setScategory(String scategory) {
		this.scategory = scategory;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
}

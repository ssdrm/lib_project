package localhost.lib.pro;

import java.util.*;

public class Pagelist<T> {
	private List<T> list;
	private int numItemsInPage;
	private int numItems;
	private int numPages;
	private int page;
	
	private final static int delta = 2;
	
	public List<T> getList(){
		return list;
	}
	public Pagelist(int numItemsInPage, int page){
		super();
		this.numItemsInPage = numItemsInPage;
		this.page = page;
		numItems = 0;
		numPages = 0;
		list = new ArrayList<T>();
	}

	public int getNumItemsInPage() {
		return numItemsInPage;
	}

	public void setNumItemsInPage(int numItemsInPage) {
		this.numItemsInPage = numItemsInPage;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
		numPages = (int) Math.ceil((double)numItems / (double)numItemsInPage);
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public int getStartPageNo(){
		return (page <= delta) ? 1: page - delta;
	}
	
	public int getEndPageNo(){
		int endPageNo = getStartPageNo() + (delta * 2) + 1;
		
		if(endPageNo > numPages){
			endPageNo = numPages;
		}
		
		return endPageNo;
	}
}

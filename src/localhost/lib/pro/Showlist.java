package localhost.lib.pro;

import java.util.*;

public class Showlist<T> {
	
	private List<T> list;
	
	public Showlist(){
		super();
		list = new ArrayList<T>();
	}
	
	public List<T> getList() {
		return list;
	}

	

}

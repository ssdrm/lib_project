package localhost.lib.pro;

public class User {
	private String id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String admintype;
	
	public User(){
		
	}
	
	public User(String id,String name, String password, String email, String phone, String admintype){
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.admintype = admintype;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdmintype() {
		return admintype;
	}

	public void setAdmintype(String admintype) {
		this.admintype = admintype;
	}
}

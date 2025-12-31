package model;

public class Clientmodel {
	private int id;
	private String restname; 
	private String contact;	
	private String address;
	private String password;
	private String status;
	public Clientmodel(int id, String restname, String contact, String address, String password, String status) {
		super();
		this.id = id;
		this.restname = restname;
		this.contact = contact;
		this.address = address;
		this.password = password;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Clientmodel(int id, String restname, String contact, String address, String password) {
		super();
		this.id = id;
		this.restname = restname;
		this.contact = contact;
		this.address = address;
		this.password = password;
	}
	public String getRestname() {
		return restname;
	}
	public void setRestname(String restname) {
		this.restname = restname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Clientmodel(String restname, String contact, String address, String password) {
	
		this.restname = restname;
		this.contact = contact;
		this.address = address;
		this.password = password;
	}
	public Clientmodel(String contact, String password) {
		
		this.contact = contact;
		this.password = password;
	}
	
	

}

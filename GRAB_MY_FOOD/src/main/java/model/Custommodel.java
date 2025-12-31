package model;

public class Custommodel {
	private int id;
	private String username; 
	private String contact;	
	private String address;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Custommodel(String username, String contact, String address, String password) {
		super();
		this.username = username;
		this.contact = contact;
		this.address = address;
		this.password = password;
	}
	public Custommodel(String contact, String password) {
		super();
		this.contact = contact;
		this.password = password;
	}
	public Custommodel(int id, String username, String contact, String address, String password) {
		super();
		this.id = id;
		this.username = username;
		this.contact = contact;
		this.address = address;
		this.password = password;
	}
	
	
}

package model;

public class Ordersmodel {
	private int id;
	private int qty;
	private int price;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int itemid;
	private int clientid;
	private int customerid;
	private String Status;  
	public Ordersmodel(int id, int qty, int price, int itemid, int clientid) {
		super();
		this.id = id;
		this.qty = qty;
		this.price = price;
		this.itemid = itemid;
		this.clientid = clientid;
	}
	public Ordersmodel(int id, int itemid, int clientid, int customerid, String status) {
		this.id = id;
		this.itemid = itemid;
		this.clientid = clientid;
		this.customerid = customerid;
		Status = status;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Ordersmodel(int id, int itemid, int clientid, int customerid) {
		this.id = id;
		this.itemid = itemid;
		this.clientid = clientid;
		this.customerid = customerid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

}

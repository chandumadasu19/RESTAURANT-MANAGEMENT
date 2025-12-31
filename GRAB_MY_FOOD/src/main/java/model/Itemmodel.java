package model;

public class Itemmodel {
	
	private int id;
	private  String iname;
	private String iprice;
	private String des;
	private String status;
	private int irestid;
	public int getIrestid() {
		return irestid;
	}
	public void setIrestid(int irestid) {
		this.irestid = irestid;
	}
	public Itemmodel(String iname, String iprice, String des, int irestid) {
		super();
		this.iname = iname;
		this.iprice = iprice;
		this.des = des;
		this.irestid=irestid;
	}
	public Itemmodel(int id,String iname, String iprice, String des, String status) {
		super();
		this.id=id;
		this.iname = iname;
		this.iprice = iprice;
		this.des = des;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIprice() {
		return iprice;
	}
	public void setIprice(String iprice) {
		this.iprice = iprice;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

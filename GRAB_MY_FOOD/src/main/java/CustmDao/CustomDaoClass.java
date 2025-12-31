package CustmDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBUtill.DBUtil;
import model.Clientmodel;
import model.Custommodel;
import model.Itemmodel;
import model.Ordersmodel;

public class CustomDaoClass implements CustomDaoInter{

	@Override
	public Custommodel CheckLogin(Custommodel cm) {
	
		Custommodel cm1 = null;
		
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("Select * from Custom where contact=? and password=?");
			ps.setString(1,cm.getContact());
			ps.setString(2,cm.getPassword());
			System.out.println(cm.getContact()+""+cm.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cm1= new Custommodel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				System.out.println("user exists");
			}
			rs.close();
			ps.close();
			con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		return cm1;
		
	}

	@Override
	public boolean RegisterCustom(Custommodel cm) {
		boolean status=false;
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("insert into Custom(username,contact,address,password) values(?,?,?,?)");
			ps.setString(1,cm.getUsername());
			ps.setString(2,cm.getContact());
			ps.setString(3,cm.getAddress());
			ps.setString(4,cm.getPassword());
			int result = ps.executeUpdate();
			if(result >0) {
				status=true;
			}
			
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Clientmodel> getRestlist() {
		List<Clientmodel> rlist = new ArrayList<Clientmodel>();
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("Select * from Client order by status");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rlist.add(new Clientmodel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
			}
			rs.close();
			ps.close();
			con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return rlist;
		
	}

	@Override
	public List<Itemmodel> getRestitems(int rid) {
		List<Itemmodel> ilist = new ArrayList<>();
		try {
			
				Connection con = DBUtil.getconn();
				PreparedStatement ps = con.prepareStatement("Select * from items where irestid =?");
				ps.setInt(1, rid);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ilist.add(new Itemmodel(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5)));
				}
		}catch (Exception e) {
            e.printStackTrace();
		}
		return ilist;
	}

	@Override
	public List<Ordersmodel> getolist(int cid) {
		List<Ordersmodel> olist = new ArrayList<Ordersmodel>();
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("Select id,qty,price,itemid,clientid from orders where customerid=? and Status=?");
			ps.setInt(1,cid);
					ps.setString(2,"preparing..");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	olist.add( new Ordersmodel(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
		    }
		
		rs.close();
		ps.close();
		con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return olist;
		
	}

	@Override
	public List<Ordersmodel> customhist(int cid) {
		List<Ordersmodel> olist = new ArrayList<Ordersmodel>();
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("Select id,qty,price,itemid,clientid from orders where customerid=? and Status=?");
			ps.setInt(1,cid);
					ps.setString(2,"done");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	olist.add( new Ordersmodel(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
		    }
		
		rs.close();
		ps.close();
		con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return olist;
		
	}

	@Override
	public boolean Updatecustom(Custommodel cm1) {
		boolean status=false;
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement(
				    "UPDATE Custom SET username=?, contact=?, address=?, password=? WHERE id=?"
				);

			ps.setString(1,cm1.getUsername());
			ps.setString(2,cm1.getContact());
			ps.setString(3,cm1.getAddress());
			ps.setString(4,cm1.getPassword());
			ps.setInt(5,cm1.getId());
			int res=ps.executeUpdate();
			System.out.println(res);
			if(res>0) {
				status=true;
				System.out.println("upadted");
			}
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}

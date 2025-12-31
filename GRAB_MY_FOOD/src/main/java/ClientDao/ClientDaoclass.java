package ClientDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBUtill.DBUtil;
import model.Clientmodel;
import model.Itemmodel;
import model.Ordersmodel;

public class ClientDaoclass implements ClientDaoInter {

	@Override
	public Clientmodel CheckLogin(Clientmodel cm) {
		Clientmodel cm1=null;
		try {
		Connection con = DBUtil.getconn();
		PreparedStatement ps = con.prepareStatement("Select * from Client where contact=? and password=?");
		ps.setString(1,cm.getContact());
		ps.setString(2,cm.getPassword());
		System.out.println(cm.getContact()+""+cm.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			cm1= new Clientmodel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
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
	public boolean RegisterClient(Clientmodel cm) {
		boolean status=false;
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("insert into client(restname,contact,address,password) values(?,?,?,?)");
			ps.setString(1,cm.getRestname());
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
	public boolean additem(Itemmodel im) {
		boolean status = false;
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("insert into items(iname,iprice,ides,irestid) values(?,?,?,?)");
			ps.setString(1,im.getIname());
			ps.setString(2,im.getIprice());
			ps.setString(3,im.getDes());
			ps.setInt(4,im.getIrestid());
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
	public List<Itemmodel> getitemlist(int a) {
		List<Itemmodel> list= new ArrayList<Itemmodel>();
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("Select id,iname,iprice,ides,istatus from items where irestid=?");
			ps.setInt(1,a);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	list.add( new Itemmodel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) ));
		    }
		
		rs.close();
		ps.close();
		con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}

	return list;
}

	@Override
	public boolean updateitem(Itemmodel im) {
		boolean status=false;
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement(
				    "UPDATE items SET iname=?, iprice=?, ides=?, istatus=? WHERE id=?"
				);

			ps.setString(1,im.getIname());
			ps.setString(2,im.getIprice());
			ps.setString(3,im.getDes());
			ps.setString(4,im.getStatus());
			ps.setInt(5,im.getId());
			int res=ps.executeUpdate();
			if(res>0) {
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
	public boolean deleteitem(int id) {
	     boolean status =false;
	     try {
				Connection con = DBUtil.getconn();
				PreparedStatement ps = con.prepareStatement(
					    "DELETE FROM items WHERE id=?"
					);
				ps.setInt(1,id);
				int res=ps.executeUpdate();
				if(res>0) {
					status=true;
				}
				ps.close();
				con.close();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();
		}
	     
		return status;
	}

	@Override
	public boolean Updateclient(Clientmodel cm1) {
		boolean status=false;
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement(
				    "UPDATE client SET restname=?, contact=?, address=?, password=? WHERE id=?"
				);

			ps.setString(1,cm1.getRestname());
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

	@Override
	public boolean Deleteclient(int id) {
		boolean status= false;
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement(
				    "DELETE FROM client WHERE id=?"
				);
			ps.setInt(1,id);
			int res=ps.executeUpdate();
			if(res>0) {
				status=true;
			}
			ps.close();
			con.close();
     }
     catch (Exception e) {
    	 e.printStackTrace();
	}
     
	return status;
		
	}

	@Override
	public List<Ordersmodel> clientorders(int restid) {
		List<Ordersmodel> olist = new ArrayList<Ordersmodel>();
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("Select * from orders where clientid=? and Status=?");
			ps.setInt(1,restid);
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
	public List<Ordersmodel> clienthist(int restid) {
		List<Ordersmodel> olist = new ArrayList<Ordersmodel>();
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement("Select * from orders where clientid=? and Status=?");
			ps.setInt(1,restid);
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
	public boolean Clientstatus(int id,String sts) {
		boolean status=false;
		sts=sts.equalsIgnoreCase("Active")?"UNACTIVE":"ACTIVE";
		try {
			Connection con = DBUtil.getconn();
			PreparedStatement ps = con.prepareStatement(
				    "UPDATE client SET status=? WHERE id=?"
				);
			ps.setString(1,sts);
			ps.setInt(2,id);
			int res=ps.executeUpdate();
			System.out.println(res);
			if(res>0) {
				status=true;
			}
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
			
	
}
}

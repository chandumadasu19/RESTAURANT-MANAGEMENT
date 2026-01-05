package ClientDao;

import java.util.List;

import model.Clientmodel;
import model.Custommodel;
import model.Itemmodel;
import model.Ordersmodel;

public interface ClientDaoInter {
	
	Clientmodel CheckLogin(Clientmodel cm);
	boolean RegisterClient(Clientmodel cm);
	boolean additem(Itemmodel im);
	List<Itemmodel> getitemlist(int a);
	boolean updateitem(Itemmodel im);
	boolean deleteitem(int id);
	boolean Updateclient(Clientmodel cm1);
	boolean Deleteclient(int id);
	List<Ordersmodel> clientorders(int restid);
	List<Ordersmodel> clienthist(int restid);
	boolean Clientstatus(int id, String Sts);
	boolean doneitem(int id);
	
	
	

}

package CustmDao;

import java.util.List;

import model.Clientmodel;
import model.Custommodel;
import model.Itemmodel;
import model.Ordersmodel;

public interface CustomDaoInter {

	Custommodel CheckLogin(Custommodel cm);

	boolean RegisterCustom(Custommodel cm);
	List<Clientmodel> getRestlist();
	List<Itemmodel> getRestitems(int rid);
	List<Ordersmodel> getolist(int cid);
	List<Ordersmodel> customhist(int cid);

	boolean Updatecustom(Custommodel cm1);
	
	

}

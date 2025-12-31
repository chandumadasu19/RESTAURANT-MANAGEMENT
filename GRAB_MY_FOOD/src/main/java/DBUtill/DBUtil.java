package DBUtill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Connection getconn() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Grabmyfood","root","Chandu@1234");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}

package controller;

import java.io.IOException;

import CustmDao.CustomDaoClass;
import CustmDao.CustomDaoInter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Custommodel;

/**
 * Servlet implementation class CustomerRegistServlet
 */
@WebServlet("/CustomerRegistServlet")
public class CustomerRegistServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname= request.getParameter("uname");
		String contact= request.getParameter("contact");
		String address= request.getParameter("address");
		String password= request.getParameter("password");
		Custommodel cm= new Custommodel(uname, contact, address, password);
		CustomDaoInter dao= new CustomDaoClass();
		boolean ststus= dao.RegisterCustom(cm);
		if(ststus) {
			request.setAttribute("msg", "registering Sucuessfull");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "registering failed");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerRegist.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

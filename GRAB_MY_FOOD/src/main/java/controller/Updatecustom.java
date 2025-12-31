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
import jakarta.servlet.http.HttpSession;
import model.Custommodel;

/**
 * Servlet implementation class Updatecustom
 */
@WebServlet("/Updatecustom")
public class Updatecustom extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Custommodel cm= (Custommodel)session.getAttribute("custom");
		int id = Integer.parseInt(request.getParameter("id"));
		String restname= request.getParameter("uname");
		String contact= request.getParameter("contact");
		String address= request.getParameter("address");
		String password= request.getParameter("password");
		Custommodel cm1= new Custommodel(id, restname, contact, address, password);
		CustomDaoInter dao= new CustomDaoClass();
		boolean ststus= dao.Updatecustom(cm1);	
		if(ststus) {
			request.setAttribute("msg", "update Sucuessfull");
			session.setAttribute("custom",cm1);
			RequestDispatcher rd = request.getRequestDispatcher("Custompage.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "update failed");
			RequestDispatcher rd = request.getRequestDispatcher("Custompage.jsp");
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

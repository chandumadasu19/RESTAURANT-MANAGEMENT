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
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		Custommodel cm = new Custommodel(contact,password);
		CustomDaoInter dao = new CustomDaoClass();
		Custommodel cm1=dao.CheckLogin(cm);
		if(cm1!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("custom",cm1);
			request.setAttribute("msg", "login Sucuessfull");
			RequestDispatcher rd = request.getRequestDispatcher("Custompage.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "login failed");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
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

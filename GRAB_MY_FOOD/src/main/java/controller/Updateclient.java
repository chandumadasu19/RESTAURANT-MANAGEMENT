package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Clientmodel;

import java.io.IOException;

import ClientDao.ClientDaoInter;
import ClientDao.ClientDaoclass;

/**
 * Servlet implementation class Updateclient
 */
@WebServlet("/Updateclient")
public class Updateclient extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clientmodel cm=(Clientmodel) session.getAttribute("client");
		int id = Integer.parseInt(request.getParameter("id"));
		String restname= request.getParameter("restname");
		String contact= request.getParameter("contact");
		String address= request.getParameter("address");
		String password= request.getParameter("password");
		Clientmodel cm1= new Clientmodel(id, restname, contact, address, password);
		ClientDaoInter dao= new ClientDaoclass();
		boolean ststus= dao.Updateclient(cm1);
		cm1.setStatus("ACTIVE");
		if(ststus) {
			request.setAttribute("msg", "update Sucuessfull");
			session.setAttribute("client",cm1);
			RequestDispatcher rd = request.getRequestDispatcher("Clientpage.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "update failed");
			RequestDispatcher rd = request.getRequestDispatcher("Clientpage.jsp");
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

package controller;

import java.awt.Window;
import java.awt.event.WindowStateListener;
import java.io.IOException;

import ClientDao.ClientDaoclass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Clientmodel;

/**
 * Servlet implementation class ClientLoginServlet
 */
@WebServlet("/ClientLoginServlet")
public class ClientLoginServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		Clientmodel cm = new Clientmodel(contact,password);
		ClientDaoclass dao= new ClientDaoclass();
		Clientmodel cm1= dao.CheckLogin(cm);
		if(cm1!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("client",cm1);
			request.setAttribute("msg", "login Sucuessfull");
			RequestDispatcher rd = request.getRequestDispatcher("Clientpage.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "login failed");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;

import ClientDao.ClientDaoInter;
import ClientDao.ClientDaoclass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Clientmodel;

@WebServlet("/ClientRegistServlet")
public class ClientRegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String restname= request.getParameter("restname");
		String contact= request.getParameter("contact");
		String address= request.getParameter("address");
		String password= request.getParameter("password");
		Clientmodel cm= new Clientmodel(restname, contact, address, password);
		ClientDaoInter dao= new ClientDaoclass();
		boolean ststus= dao.RegisterClient(cm);
		if(ststus) {
			request.setAttribute("msg", "update Sucuessfull");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "update failed");
			RequestDispatcher rd = request.getRequestDispatcher("ClientRegist.jsp");
			rd.forward(request, response);
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

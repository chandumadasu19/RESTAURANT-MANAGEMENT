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


@WebServlet("/Clientstatus")
public class Clientstatus extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clientmodel cm=(Clientmodel) session.getAttribute("client");
		int id = Integer.parseInt( request.getParameter("id"));
		String sts=request.getParameter("status");
		ClientDaoInter dao= new ClientDaoclass();
		boolean status = dao.Clientstatus(id,sts);
		if(status) {
			request.setAttribute("msg","Stuats sucesfully");
			cm.setStatus(sts.equalsIgnoreCase("Active")?"UNACTIVE":"ACTIVE");
			RequestDispatcher rd= request.getRequestDispatcher("Clientpage.jsp");  
			rd.forward(request, response);
		}else {
			request.setAttribute("msg","Status  failed");
			RequestDispatcher rd= request.getRequestDispatcher("Clientpage.jsp");  
			rd.forward(request, response);

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

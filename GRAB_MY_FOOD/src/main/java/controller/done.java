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
 * Servlet implementation class done
 */
@WebServlet("/done")
public class done extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clientmodel cm=(Clientmodel) session.getAttribute("client");
		int id=Integer.parseInt(request.getParameter("id"));
		ClientDaoInter dao= new ClientDaoclass();
		boolean status=dao.doneitem(id);
		if(status) {
			request.setAttribute("msg","item preparation sucesfully");
			RequestDispatcher rd= request.getRequestDispatcher("Clientpage.jsp");  
			rd.forward(request, response);
		}else {
			request.setAttribute("msg","item preparation failed");
			RequestDispatcher rd= request.getRequestDispatcher("Clientpage.jsp");  
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

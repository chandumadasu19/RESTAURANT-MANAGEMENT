package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Clientmodel;
import model.Itemmodel;

import java.io.IOException;

import ClientDao.ClientDaoInter;
import ClientDao.ClientDaoclass;

/**
 * Servlet implementation class Deleteitem
 */
@WebServlet("/Deleteitem")
public class Deleteitem extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clientmodel cm=(Clientmodel) session.getAttribute("client");
		int id=Integer.parseInt(request.getParameter("id"));
		ClientDaoInter dao= new ClientDaoclass();
		boolean status = dao.deleteitem(id);
		if(status) {
			request.setAttribute("msg","iteam deleted sucesfully");
			RequestDispatcher rd= request.getRequestDispatcher("Clientpage.jsp");  
			rd.forward(request, response);
		}else {
			request.setAttribute("msg","iteam deleted failed");
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

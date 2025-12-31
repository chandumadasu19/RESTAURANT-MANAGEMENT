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
import jakarta.servlet.http.HttpSession;
import model.Clientmodel;
import model.Itemmodel;

/**
 * Servlet implementation class updateitem
 */
@WebServlet("/updateitem")
public class updateitem extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clientmodel cm=(Clientmodel) session.getAttribute("client");
		String iname=request.getParameter("iname");
		int id=Integer.parseInt(request.getParameter("id"));
		String iprice=request.getParameter("iprice");
		String ides=request.getParameter("ides");
		String istatus=request.getParameter("istatus");
		Itemmodel im = new Itemmodel(id, iname, iprice, ides, istatus);
		ClientDaoInter dao= new ClientDaoclass();
		boolean status = dao.updateitem(im);
		if(status) {
			request.setAttribute("msg", "update item Sucuessfull");
			RequestDispatcher rd = request.getRequestDispatcher("Clientpage.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "update item failed");
			RequestDispatcher rd = request.getRequestDispatcher("Clientpage.jsp");
			rd.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

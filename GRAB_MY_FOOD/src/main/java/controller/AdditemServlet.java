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
 * Servlet implementation class AdditemServlet
 */
@WebServlet("/AdditemServlet")
public class AdditemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clientmodel cm=(Clientmodel) session.getAttribute("client");
		String iname=request.getParameter("iname");
		String iprice=request.getParameter("iprice");
		String ides=request.getParameter("ides");
		int irestid = Integer.parseInt(request.getParameter("irestid"));
		Itemmodel im = new Itemmodel(iname, iprice, ides,irestid);
		ClientDaoInter dao= new ClientDaoclass();
		boolean status = dao.additem(im);
		if(status) {
			request.setAttribute("msg","iteam added sucesfully");
			RequestDispatcher rd= request.getRequestDispatcher("Clientpage.jsp");  
			rd.forward(request, response);
		}else {
			request.setAttribute("msg","iteam added failed");
			RequestDispatcher rd= request.getRequestDispatcher("Clientpage.jsp");  
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

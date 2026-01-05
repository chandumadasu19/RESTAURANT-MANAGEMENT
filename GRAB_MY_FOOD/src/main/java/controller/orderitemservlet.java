package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Custommodel;
import model.Ordersmodel;

import java.io.IOException;

import CustmDao.CustomDaoClass;
import CustmDao.CustomDaoInter;

/**
 * Servlet implementation class orderitemservlet
 */
@WebServlet("/orderitemservlet")
public class orderitemservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Custommodel cm= (Custommodel)session.getAttribute("custom");
		int iid = Integer.parseInt(request.getParameter("iid"));
		int cuid = Integer.parseInt(request.getParameter("cuid"));
		int rid = Integer.parseInt(request.getParameter("rid"));
		int iprice =Integer.parseInt(request.getParameter("iprice"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		Ordersmodel om = new Ordersmodel(qty,iprice,iid, rid,cuid,"preparing..");
		CustomDaoInter dao= new CustomDaoClass();
		boolean status=dao.placeorder(om);
		if(status) {
			request.setAttribute("msg", "order placed Sucuessfull");
			session.setAttribute("custom",cm);
			RequestDispatcher rd = request.getRequestDispatcher("Custompage.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "order placed failed");
			RequestDispatcher rd = request.getRequestDispatcher("Custompage.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

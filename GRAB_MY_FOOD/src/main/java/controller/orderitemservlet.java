package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Custommodel;

import java.io.IOException;

/**
 * Servlet implementation class orderitemservlet
 */
@WebServlet("/orderitemservlet")
public class orderitemservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Custommodel cm= (Custommodel)session.getAttribute("custom");
		int iid= Integer.parseInt(request.getParameter("iid"));
		int cuid=Integer.parseInt(request.getParameter("cuid"));
		int rid=Integer.parseInt(request.getParameter("rid"));
		int iprice =Integer.parseInt(request.getParameter("iprice"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		Ordersmodel om = new Ordersmodel
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

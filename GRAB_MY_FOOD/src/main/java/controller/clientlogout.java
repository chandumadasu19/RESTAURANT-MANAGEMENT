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

/**
 * Servlet implementation class clientlogout
 */
@WebServlet("/Clientlogout")
public class clientlogout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clientmodel cm=(Clientmodel) session.getAttribute("client");
		session.invalidate();
		request.setAttribute("msg","logout sucessfull");
	    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
	    rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

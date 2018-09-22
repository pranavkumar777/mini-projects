package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.PaymentDAO;
import entity.Customer;
import entity.Payment;
import entity.TimeTable;

/**
 * Servlet implementation class CancelServlet
 */
@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
     
    public CancelServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session=request.getSession(false);
	 Customer cust=(Customer)session.getAttribute("user");
	 int userid=cust.getUserId();
	   List<Payment> paymentlist= new ArrayList<Payment>();

	 			 
		PaymentDAO dao;
		try {
			dao = new PaymentDAO();
			System.out.println(userid);
			 paymentlist=dao.getbyId(userid);
			 

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Show Payment"+paymentlist);
		request.setAttribute("paymentlist",paymentlist);
		RequestDispatcher rd= request.getRequestDispatcher("/cancel.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

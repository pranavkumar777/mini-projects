package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.PaymentDAO;
import database.TimeTabledatabase;
import entity.Customer;
import entity.TimeTable;

/**
 * Servlet implementation class SuccessCancelServlet
 */
@WebServlet("/SuccessCancelServlet")
public class SuccessCancelServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Customer cust=(Customer)session.getAttribute("user");
		 int userid=cust.getUserId();
			int busno= Integer.parseInt(request.getParameter("busno")); 
			int seat= Integer.parseInt(request.getParameter("seat")); 
			System.out.println(busno);
			System.out.println(seat);
			
		 
		 try {
			 TimeTabledatabase t=new TimeTabledatabase();
			 List<TimeTable> timeList=t.getAll();
				TimeTable data=timeList.stream().filter(p-> p.getBusno()==busno).findFirst().get();
				System.out.println("Book Servlet"+ data);
				Integer updatedSeatAvailablity=Integer.parseInt(data.getAvailablity())+seat;
				data.setAvailablity(updatedSeatAvailablity.toString());
				t.updateOrder(data);
			
				
			 
			PaymentDAO dao=new PaymentDAO();
			dao.deletePayment(userid,seat);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	 RequestDispatcher rd=request.getRequestDispatcher("/cancelsuccess.jsp");
	  rd.forward(request, response);
	 		
	
	}

	
}

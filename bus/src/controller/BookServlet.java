package controller;


import java.io.IOException;
import java.io.PrintWriter;
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
import entity.Payment;
import entity.TimeTable;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int busno1= Integer.parseInt(request.getParameter("id")); 
		 System.out.println(busno1);
		 HttpSession session1=request.getSession(false);
		 session1.setAttribute("busno", busno1);
			PrintWriter out = response.getWriter();
			
			double amount;

		try {
		 
			HttpSession session = request.getSession(false);

		  int busno= Integer.parseInt(request.getParameter("id"));
		  System.out.println(busno);
		 int requiredseat= Integer.parseInt(request.getParameter("requiredseat")); 
		 	request.setAttribute("seat",requiredseat);
		 
		 
		// request.setAttribute("totalPrice",totalPrice );
		 
		 
		 
		
			TimeTabledatabase t= new TimeTabledatabase();
			List<TimeTable> timeList=t.getAll();
			TimeTable data=timeList.stream().filter(p-> p.getBusno()==busno).findFirst().get();
			System.out.println("Book Servlet"+ data);
			Integer updatedSeatAvailablity=Integer.parseInt(data.getAvailablity())-requiredseat;
			data.setAvailablity(updatedSeatAvailablity.toString());
			t.updateOrder(data);
			if(requiredseat <5)
			{int totalPrice=data.getTicket_rate()*requiredseat;
			amount=totalPrice;
			session.setAttribute("rate",totalPrice);
			request.setAttribute("totalPrice",totalPrice );
			}
			else if(requiredseat>=5 &&requiredseat<10)
			
		    {double totalPrice=data.getTicket_rate()*requiredseat*0.80;
		    amount=totalPrice;
		    request.setAttribute("totalPrice",totalPrice);
			}
			else{
				double totalPrice=data.getTicket_rate()*requiredseat*0.70;
				amount=totalPrice;
				request.setAttribute("totalPrice",totalPrice);
			}
			
			 Customer cust=(Customer)session.getAttribute("user");
			 int userid=cust.getUserId();
			 String date=(String) session.getAttribute("date");
			 
			
			 Payment p=new Payment(busno,userid,amount,date,requiredseat);			 
			
				PaymentDAO dao = new PaymentDAO();
				 dao.addpay(p);
			
						 
			 RequestDispatcher rd= request.getRequestDispatcher("/success.jsp");
				rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		/* HttpSession session=request.getSession(false);
		 int userid=session.getAttribute(user.userid);
		 Payment p=new Payment(busno1,userid,amount);
		 
		 PaymentDAO dao=new PaymentDAO();
		 dao.addpay(p);
		 
		 
		
		 */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

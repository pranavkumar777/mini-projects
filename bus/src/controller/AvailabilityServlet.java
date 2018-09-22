package controller;

import java.io.IOException;
import java.sql.ResultSet;
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

import database.TimeTabledatabase;
import entity.TimeTable;

@WebServlet("/AvailabilityServlet")
public class AvailabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String source = request.getParameter("source");
		        String destination=request.getParameter("destination");
		        String date=request.getParameter("date");
		        String bustype=request.getParameter("bustype");
		        
		        HttpSession session=request.getSession(false);
		        session.setAttribute("source", source);
		        session.setAttribute("destination",destination);
		        session.setAttribute("date", date);
		        session.setAttribute("bustype",bustype);
		      
		        System.out.println("Availablity"+date);
		        TimeTable s= new TimeTable();
		        s.setSource(source);
		        s.setDestination(destination);
		        s.setDate(date);
		        s.setBus_type(bustype);
		       
		        System.out.println("Availablity Servlet : "+s);
				TimeTabledatabase e;
				List<TimeTable> BusList = null;
				try {
					e = new TimeTabledatabase();
					BusList=e.Methodm1(s);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Avail Servlet"+ BusList);	        		      
		        request.setAttribute("BusList", BusList);
				RequestDispatcher rd= request.getRequestDispatcher("/avail.jsp");
				rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
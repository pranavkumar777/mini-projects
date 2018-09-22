package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AdminDAO;
import database.CustomerDAO;
import database.TimeTabledatabase;
import entity.AdminDetails;
import entity.TimeTable;


@WebServlet("/AdminAddBus")
public class AdminAddBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminAddBus() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String date = request.getParameter("date");
        int busno= Integer.parseInt(request.getParameter("busno"));
        String bustype=request.getParameter("bustype");
        String source=request.getParameter("source");
        String destination=request.getParameter("destination");
        String avail=request.getParameter("avail");
       // int username=Integer.parseInt(request.getParameter("userid"));
        int ticketrate=Integer.parseInt(request.getParameter("ticketrate"));
       
       TimeTable ad=new TimeTable(date,busno,bustype,source,destination,ticketrate,avail);
        
        
        try {
			TimeTabledatabase dao=new TimeTabledatabase();
			dao.insertTimetable(ad);
			RequestDispatcher rd = request.getRequestDispatcher("/successadd.jsp");
			rd.forward(request,response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	
	}



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

import database.TimeTabledatabase;
import entity.TimeTable;

/**
 * Servlet implementation class ShowBusList
 */
@WebServlet("/ShowBusList")
public class ShowBusList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TimeTabledatabase s;
		List<TimeTable> timeTableList= new ArrayList();
		List<String> timeTableListsource= new ArrayList();
		List<String> timeTableListdestination= new ArrayList();
		try {
			s = new TimeTabledatabase();
			timeTableList=s.getAll();
			timeTableListsource=s.Source();
			timeTableListdestination=s.Destination();


		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Show Buslist"+timeTableList);
		System.out.println("Show Buslist"+timeTableListsource);
		System.out.println("Show Buslist"+timeTableListdestination);
		
		request.setAttribute("listsource", timeTableListsource);
		request.setAttribute("listdestination", timeTableListdestination);

		request.setAttribute("list", timeTableList);
		//	System.err.println("hello");
		RequestDispatcher rd= request.getRequestDispatcher("/bookticket.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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

import database.CustomerDAO;
import database.TimeTabledatabase;
import entity.Customer;
import entity.TimeTable;

/**
 * Servlet implementation class AddServletSignup
 */
@WebServlet("/AddServletSignup")
public class AddServletSignup extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
        int age= Integer.parseInt(request.getParameter("age"));
        String address=request.getParameter("address");
        String email=request.getParameter("email");
        int telephone=Integer.parseInt(request.getParameter("telephone"));
        String gender=request.getParameter("gender");
       // int username=Integer.parseInt(request.getParameter("userid"));
        String password=request.getParameter("password");
        
		Customer newCustomer=new Customer(-1, name, age, address, email, telephone, gender, password);
		
		log("Customer Data: "+newCustomer);
		
		try {
			CustomerDAO custdao=new CustomerDAO();
			int userId=custdao.addNewUser(newCustomer);
			if(userId>=1){
				out.println("Sucess: user created with Id"+ userId);// forward to success
				RequestDispatcher rd = request.getRequestDispatcher("/ShowBusList");
				rd.forward(request,response);

			}
			// forward to fail
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//doGet(request, response);
		}

	

	
	
	}



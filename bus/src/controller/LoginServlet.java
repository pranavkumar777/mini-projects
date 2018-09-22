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
import javax.servlet.http.HttpSession;

import database.CustomerDAO;
import entity.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();

			String name = request.getParameter("user");
			String password = request.getParameter("password");
			Customer cust=new Customer();
			
			cust.setName(name); //setting the username and password through the custinBean object then only you can get it in future.
			cust.setPassword(password);
			try {
				CustomerDAO dao=new CustomerDAO();
				Customer customer = dao.validate(cust); //Calling authenticateUser function
				if(customer !=null) //If function returns success string then user will be rooted to Home page
				{
					HttpSession session= request.getSession();
					session.setAttribute("user",customer );
			///	request.setAttribute("userName", name); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
					RequestDispatcher rd = request.getRequestDispatcher("/ShowBusList");
					rd.forward(request,response);
				}
			/*	else
				{
				 out.println("please enter valid username and password");
				
				}
			*/
			
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
		
		
		}

}

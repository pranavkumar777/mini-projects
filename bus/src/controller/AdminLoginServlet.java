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
import entity.AdminDetails;
import entity.Customer;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter("user");
		String password = request.getParameter("password");
		AdminDetails adm=new AdminDetails();
		
		adm.setAdminid(name);; //setting the username and password through the custinBean object then only you can get it in future.
		adm.setPassword(password);
		
		try {
			AdminDAO dao=new AdminDAO();
		     AdminDetails admin=dao.validate(adm);
		     if(admin!=null)
		     {
		    	 
		    	 RequestDispatcher rd = request.getRequestDispatcher("/adminhome.jsp");
					rd.forward(request,response);

		     }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

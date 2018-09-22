package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.AdminDetails;

public class AdminDAO {

	Connection connection;
	String URL;

	public AdminDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		URL = "jdbc:mysql://localhost:3306/bus";
		connection = DriverManager.getConnection(URL, "root", "root");

	}

	public AdminDetails validate(AdminDetails a) throws SQLException{
		String adminid=a.getAdminid();
		String password=a.getPassword();
		String query = "SELECT * FROM HEAD where adminid=? and password=?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, adminid);
		stmt.setString(2, password);
		ResultSet set = stmt.executeQuery();
		AdminDetails ad=null;
		while(set.next())
		{
			String adminidDB=set.getString("adminid");
			String passwordDB=set.getString("password");
			ad=new AdminDetails(adminidDB,passwordDB);
			return ad;
			
		}
		
		
		return null;
		
		
		
		
	}
	
	
	
	
}





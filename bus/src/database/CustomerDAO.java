package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Customer;

public class CustomerDAO {

	Connection connection;
	String URL;

	public CustomerDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		URL = "jdbc:mysql://localhost:3306/bus";
		connection = DriverManager.getConnection(URL, "root", "root");

	}

	public List<Customer> getAll() throws SQLException {
		try {
			List<Customer> s = new ArrayList<Customer>();
			String query = "SELECT * FROM CUSTOMER";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet set = stmt.executeQuery();
			while (set.next()) {
				String name = set.getString("name");
				int age = set.getInt("age");
				String address = set.getString("address");
				String email = set.getString("email");
				int telephone = set.getInt("telephone");
				String gender = set.getString("gender");
				int userId = set.getInt("userid");
				String password = set.getString("password");
				Customer sig= new Customer(userId, name, age, address, email, telephone, gender, password);
				s.add(sig);

			}
			return s;
		} finally {
		}
	}

	public int addNewUser(Customer b) throws SQLException {
		try {
			PreparedStatement p = connection.prepareStatement(
					"INSERT INTO CUSTOMER(name,age,address,email,telephone,gender,password)VALUES(?,?,?,?,?,?,?)");
			p.setString(1, b.getName());
			p.setInt(2, b.getAge());
			p.setString(3, b.getAddress());
			p.setString(4, b.getEmail());
			p.setInt(5, b.getTelephone());
			p.setString(6, b.getGender());
			
			p.setString(7, b.getPassword());
			int rowsAdded = p.executeUpdate();
			System.out.println("Added " + rowsAdded + "added to database");
			if (rowsAdded >= 1) {
				String query = "SELECT max(userid) as id FROM CUSTOMER";
				PreparedStatement stmt = connection.prepareStatement(query);
				ResultSet set = stmt.executeQuery();
				set.next();
				return set.getInt("id");

			}
			return -1;

		}

		catch (Exception e) {
			e.printStackTrace();
			return -1;	
		}
	}

	public int deleteOrder(int username) throws SQLException {

		try {
			String query = "DELETE FROM CUSTOMER WHERE userid=? ";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, username);
			int set = stmt.executeUpdate();

			return set;
		} finally {
		}
	}
	
	public Customer validate(Customer cust) throws SQLException{
		String name = cust.getName(); //Keeping user entered values in temporary variables.
		String password = cust.getPassword();
		

		String query = "SELECT * FROM CUSTOMER where name=? and password=?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, name);
		stmt.setString(2, password);
		ResultSet set = stmt.executeQuery();
		Customer customer =null;
		while(set.next()){
			
			String userNameDB = set.getString("name"); //fetch the values present in database
			String passwordDB = set.getString("password");
			String email=set.getString("email");
			int age=set.getInt("age");
			String address=set.getString("address");
			int telephone=set.getInt("telephone");
			String gender=set.getString("gender");
			int userId=set.getInt("userid");
			customer=new Customer(userId, userNameDB , age, address, email, telephone, gender, passwordDB);
			return customer; 
			
			
		}
	
		
		
		
		return null;
		
		
		
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Customer c1=new Customer(0, "Harish", 24, "chennai", "vsg@gmail.com", 978965, "Male", "test@123");
		//System.out.println(new CustomerDAO().addNewUser(c1));
	}
}
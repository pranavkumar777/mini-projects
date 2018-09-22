package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CreditDetails;
import entity.Payment;

public class PaymentDAO {
	Connection connection;
	String URL;
	public  PaymentDAO() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	URL = "jdbc:mysql://localhost:3306/bus";
	connection = DriverManager.getConnection(URL,"root","root");
	}
	

	
	
	public void addpay(Payment b) throws SQLException {

	try{
		PreparedStatement preparedstatement= connection.prepareStatement("insert into pay (userid,busno,amount,date,seat) values(?,?,?,?,?)");
		preparedstatement.setInt(2,b.getBusno());
		preparedstatement.setInt(1,b.getUserId());
		preparedstatement.setDouble(3,b.getAmount());
		preparedstatement.setString(4, b.getDate());
		preparedstatement.setInt(5,b.getSeat());
		preparedstatement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}
public List<Payment> getAll() throws SQLException{
		
		try{
		List <Payment> paymentlist= new ArrayList <Payment>();

		String query="SELECT * FROM pay";
		PreparedStatement preparedstatement=connection.prepareStatement(query);
		//preparedstatement.setInt(1, userid);
		ResultSet set=preparedstatement.executeQuery();
		while(set.next()){
			int busno=set.getInt("busno");
			int userId=set.getInt("userid");
			double amount=set.getDouble("amount");
			String date=set.getString("date");	
			int seat=set.getInt("seat");

			Payment p=new Payment(busno, userId,amount,date,seat);
			paymentlist.add(p);
		}
		System.out.print(paymentlist);
		return paymentlist;
		}
		finally{}
		}

	
	public List<Payment> getbyId(int  userid) throws SQLException{
		
		try{
		List <Payment> paymentlist= new ArrayList <Payment>();

		String query="SELECT * FROM PAY WHERE userid=?";
		PreparedStatement preparedstatement=connection.prepareStatement(query);
		preparedstatement.setInt(1, userid);
		ResultSet set=preparedstatement.executeQuery();
		while(set.next()){
			int busno=set.getInt("busno");
			int userId=set.getInt("userid");
			double amount=set.getDouble("amount");
			System.out.println(amount);
			String date=set.getString("date");	
			int seat=set.getInt("seat");
			System.out.println(date);
			Payment p=new Payment(busno,userId,amount,date,seat);
			paymentlist.add(p);
		}
		return paymentlist;
		}
		finally{}
		
		//return null;
		
		
		
		
		
	}
	
	public int deletePayment(int userid,int seat) throws SQLException{
		try{
			String query="Delete from pay where userid=? and seat=?";
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, seat);
			int set=pstmt.executeUpdate();
			return set;
		}
		finally{
			
		}
	}	
	

}

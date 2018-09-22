package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.PaymentDetails;

public class PaymentDatabase {

	Connection connection;
	String URL;
	
	public PaymentDatabase() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		URL="jdbc:mysql://localhost:3306/bus";
		connection=DriverManager.getConnection(URL,"Pranessh","Pranessh");
		
	}
	public List <PaymentDetails> getAll() throws SQLException{
	try{	List<PaymentDetails> s=new ArrayList <PaymentDetails>();
		String query="SELECT * FROM payment";
		PreparedStatement stmt=connection.prepareStatement(query);
		ResultSet set=stmt.executeQuery();
		while(set.next()){
			
			int tid=set.getInt("tid");
			int pid=set.getInt("pid");
			int busnumber=set.getInt("bus_number");
			String date=set.getString("date");
			float amt=set.getFloat("amount");
			String transdate=set.getString("trans_date");
			int creditid=set.getInt("credit_id");
			
		
			PaymentDetails sig=new PaymentDetails(tid,pid,busnumber,date,amt,transdate,creditid);
			s.add(sig);
			
		}
		return s;
		}
	finally{
		}
	}
	
	public void insertOrder(PaymentDetails b)throws SQLException{
		try{
			PreparedStatement p=connection.prepareStatement("INSERT INTO payment(tid,pid,bus_number,date,amount,trans_date,credit_id)VALUES(?,?,?,?,?,?,?)");
			p.setInt(1, b.getTid());
			p.setInt(2, b.getPid());
		    p.setInt(3, b.getBusnumber());
		   
			p.setString(4,b.getDate());
		    p.setFloat(5,b.getAmt());
		    p.setString(6, b.getTransdate());
		    p.setInt(7,b.getCreditid());	
		    p.executeUpdate();
		}
		
		catch(Exception e){
			e.printStackTrace();
			
		}}
		
	public int deleteOrder(int tid ) throws SQLException
	{ 
		
		
		try{
		String query="DELETE FROM payment where tid=? ";
		PreparedStatement stmt=connection.prepareStatement(query);
		stmt.setInt(1,tid);
		int set=stmt.executeUpdate();
		
		return set;
	}
	finally{}
	}
	
	
	
	
	
	
	
	
	
}
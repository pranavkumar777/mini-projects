package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CreditDetails;

public class CreditDatabase {
	Connection connection;
	String URL;
	
	public CreditDatabase() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		URL = "jdbc:mysql://localhost:3306/bus";
		connection = DriverManager.getConnection(URL,"root","root");
	
	}
	
	
	public  List <CreditDetails> getCreditList() throws SQLException{
	try{
			List <CreditDetails> creditlist= new ArrayList <CreditDetails>();
			String query="SELECT * FROM creditcard";
			PreparedStatement pstmt= connection.prepareStatement(query);
			ResultSet set = pstmt.executeQuery();
			while (set.next()){
				int creditid = set.getInt("creditid");
				String cname = set.getString("cname");
				String cnum = set.getString("cnum");
				String expiry = set.getString("expiry");
				CreditDetails creditdetails= new CreditDetails(creditid,cname,cnum,expiry);
				creditlist.add(creditdetails);
			}
			return creditlist;
		}
		finally{
			
		}
		
		}
	
	public  CreditDetails getCreditById(int id) throws SQLException{
		try{
		//	List <CreditDetails> creditlist= new ArrayList <CreditDetails>();
			String query="SELECT * FROM creditcard WHERE creditid= ?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet set = pstmt.executeQuery();
			if(set.next()){
				int creditid = set.getInt("creditid");
				String cname = set.getString("cname");
				String cnum = set.getString("cnum");
				String expiry = set.getString("expiry");
				CreditDetails creditdetails= new CreditDetails(creditid,cname,cnum,expiry);
				return creditdetails;
			}
			return null;
		}
		finally{
			
		}
	
	}
	
	public void insertCreditdetails(CreditDetails b1) throws SQLException {
		try{
			PreparedStatement preparedstatement= connection.prepareStatement("insert into creditcard(creditid,cname,cnum,expiry) values(?,?,?,?)");
			preparedstatement.setInt(1,b1.getCredit_id());
			preparedstatement.setString(2, b1.getC_name());
			preparedstatement.setString(3, b1.getC_num());
			preparedstatement.setString(4, b1.getExpiry());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int deleteCredit(int creditid) throws SQLException{
		try{
			String query="Delete from creditcard where creditid=?";
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setInt(1, creditid);
			int set=pstmt.executeUpdate();
			return set;
		}
		finally{
			
		}
	}
}
			

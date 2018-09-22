package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entity.TimeTable;

public class TimeTabledatabase {
	Connection connection;
	String URL;

	public TimeTabledatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		URL = "jdbc:mysql://localhost:3306/bus";
		connection = DriverManager.getConnection(URL, "root", "root");

	}

	public List<TimeTable> getAll() throws SQLException {
		try {
			List<TimeTable> timetablelist = new ArrayList<TimeTable>();
			String query = "SELECT * FROM timetable";
			PreparedStatement pstmt = connection.prepareStatement(query);
			ResultSet set = pstmt.executeQuery();
			while (set.next()) {
				String date = set.getString("date");
				int busno = set.getInt("busno");
				String bustype = set.getString("bustype");
				String source = set.getString("source");
				String destination = set.getString("destination");
				int ticketrate = set.getInt("ticketrate");
				String avail = set.getString("availability");
				TimeTable timetable = new TimeTable(date, busno, bustype, source, destination, ticketrate, avail);
				timetablelist.add(timetable);
			}
			System.out.println(timetablelist.stream().map(TimeTable::getSource).collect(Collectors.toList()));
			return timetablelist;
		} finally {

		}

	}
	public  List<String> Source() throws SQLException
	{   List<TimeTable> timetablelist = new ArrayList<TimeTable>();
	List<String> timetablelistsource = new ArrayList<String>();
	String query = "SELECT * FROM timetable";
	PreparedStatement pstmt = connection.prepareStatement(query);
	ResultSet set = pstmt.executeQuery();
	while (set.next()) {
		String date = set.getString("date");
		int busno = set.getInt("busno");
		String bus_type = set.getString("bustype");
		String source = set.getString("source");
		String destination = set.getString("destination");
		int ticket_rate = set.getInt("ticketrate");
		String avail = set.getString("availability");
		TimeTable timetable = new TimeTable(date, busno, bus_type, source, destination, ticket_rate, avail);
		timetablelist.add(timetable);

		timetablelistsource =timetablelist.stream().map(TimeTable::getSource).collect(Collectors.toList());

	}
	return timetablelistsource;
	}


	public  List<String> Destination() throws SQLException
	{   List<TimeTable> timetablelist = new ArrayList<TimeTable>();
	List<String> timetablelistsource = new ArrayList<String>();
	String query = "SELECT * FROM timetable";
	PreparedStatement pstmt = connection.prepareStatement(query);
	ResultSet set = pstmt.executeQuery();
	while (set.next()) {
		String date = set.getString("date");
		int busno = set.getInt("busno");
		String bus_type = set.getString("bustype");
		String source = set.getString("source");
		String destination = set.getString("destination");
		int ticket_rate = set.getInt("ticketrate");
		String avail = set.getString("availability");
		TimeTable timetable = new TimeTable(date, busno, bus_type, source, destination, ticket_rate, avail);
		timetablelist.add(timetable);

		timetablelistsource =timetablelist.stream().map(TimeTable::getDestination).collect(Collectors.toList());

	}
	return timetablelistsource;
	}


	public void insertTimetable(TimeTable b1) throws SQLException {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"insert into timetable(date,busno,bustype,source,destination,ticketrate,availability) values(?,?,?,?,?,?,?)");
			preparedstatement.setString(1, b1.getDate());
			preparedstatement.setInt(2, b1.getBusno());
			preparedstatement.setString(3, b1.getBus_type());
			preparedstatement.setString(4, b1.getSource());
			preparedstatement.setString(5, b1.getDestination());
			preparedstatement.setInt(6, b1.getTicket_rate());
			preparedstatement.setString(7, b1.getAvailablity());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int deleteTimetable(int busno) throws SQLException {
		try {
			String query = "Delete from timetable where busno=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, busno);
			int set = pstmt.executeUpdate();
			return set;
		} finally {

		}

	}


	public void updateOrder(TimeTable s) throws SQLException{
		try{
			String query="UPDATE timetable SET date=?, bustype=?, source=?, destination=?, ticketrate=? , availability=? where busno=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			pstmt.setString(1,s.getDate());
			
			pstmt.setString(2, s.getBus_type());
			pstmt.setString(3, s.getSource());
			pstmt.setString(4, s.getDestination());
			pstmt.setInt(5, s.getTicket_rate());
			pstmt.setString(6, s.getAvailablity());
			pstmt.setInt(7, s.getBusno());
			pstmt.executeUpdate();

		}
		finally {
		}

	}
	//public TimeTable Methodm1(TimeTable s) throws SQLException{
	public List<TimeTable> Methodm1(TimeTable s) throws SQLException{
		List<TimeTable> timetablelist = new ArrayList<TimeTable>();
		System.out.println("Time table servlet"+s);
		String date=s.getDate();
		String source1=s.getSource() ;
		String dest =s.getDestination();
		String bustype=s.getBus_type();
		try{
			//int busno;
			//String source1, dest;
			String query="Select * from timetable where date=?and bustype=? and source=? and destination=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			pstmt.setString(1, date);
			pstmt.setString(4, dest);
			pstmt.setString(3, source1);
			pstmt.setString(2,bustype);
			ResultSet set = pstmt.executeQuery();
			//System.out.println(set);
			TimeTable obj=null;
			while(set.next()){
				date = set.getString("date");
				int busno  = set.getInt("busno");
				bustype = set.getString("bustype");
				String source = set.getString("source");
				String destination = set.getString("destination");
				int ticketrate = set.getInt("ticketrate");
				String avail = set.getString("availability");
				obj=new TimeTable(date,busno,bustype,source,destination,ticketrate,avail);
				timetablelist.add(obj);			

			}
			System.out.println(timetablelist);
			return timetablelist;
		}
		finally{

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//new TimeTabledatabase().getAll();
	}

}


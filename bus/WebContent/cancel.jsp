<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>body {
    color: yellow;
}

h1 {
    color: green;
} 
body {
    background-color: lightgrey;
    width: 700px;
    border: 25px solid green;
    padding: 25px;
    margin: 25px;
}
 body {
    background-color: black;
  }

table, th, td {
   border: 1px solid White;
   border-collapse: collapse;

}

</style>

</head>
<body>

	<h1>Confirm to Cancel</h1>
	<table>
	<tr><th>Bus no.</th>
	    <th>User Id</th>
	    <th>Amount</th>
	    <th>Date</th>
	    <th>number of seats</th>
	    <th>Click here to Cancel</th></tr>
	    
		<c:forEach items="${paymentlist}" var="p">
		<tr>	<form action="SuccessCancelServlet" method="get">
		<td>	<c:out value="${p.busno}" /></td>
			<td><c:out value="${p.userId}" /></td>
		<td>	<c:out value="${p.amount}" /></td>
		<td>	<c:out value="${p.date}" /></td>
		<input type="hidden" name="busno" value="${p.busno}"/>
		
		
		<td>	<c:out value="${p.seat}" /></td>
		        <input type="hidden" name="seat" value="${p.seat}"/>
		
		
		<td><input type="submit" value="cancel"/></td>	
    </form>
 		</tr>
		</c:forEach>


	</table>

</body>
</html>
  <%--

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

  
 
      <link rel="stylesheet" href="css/style.css">
	  <script type="text/javascript">
  function fill(){
window.location="D:\\project\\seat\\index.html";}  
    
function back(){
window.location="D:\\project\\bookticket\\index.html";}    

  </script>  




<body>
  <h1 align="center">Availability of seats</h1>
<center><table width="700"><tr>
  <th>bus no. </th>
<th>source</th>
<th>destination</th>  <th>availability </th>
  <th> seats</th>
  <th>Book tickets</th>
  </tr>
  
  <tr>
    <td> 314</td>
	<td>chennai</td>
	<td>madurai</td>
    <td>yes</td>
    <td>30</td>
	<td><input type="button" value="book" onclick="fill()"/></td></tr>
  <tr>
    <td> 324</td>
	<td>chennai</td>
	<td>madurai</td>
    <td>yes</td> 
    <td>30</td><td><input type="button" value="book" onclick="fill()"/></td></tr>
</table> <br> <br> </center>
 <tbody>
            <c:forEach items="${busList1}" var="emp">
                <tr>
                    <td><c:out value="${bus.date}"/></td>
                    <td><c:out value="${bus.no}"/></td>
                    <td><c:out value="${bus.source}"/></td>
                    <td><c:out value="${bus.destination}"/></td>
                    <td><c:out value="${bus.ticket_rate}"/></td>
                    <td><c:out value="${bus.availability}"/></td>
                   <td><a href="UpdateServlet?id = <c:out value="${emp.id}"/>">book</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <input type = "button" value = "back" onclick="back()"/>   
  

</body>

</html>

 --%>
 <%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h1> Availability List</h1> <br>
<table border=1>
        <thead>
            <tr>
                <th>Bus Number</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Availability</th>
                 <th>Book </th>                
            </tr>            
        </thead>
         <tbody>
            <c:forEach items="${Buslist}" var="buslist">
                <tr>
                 <td><c:out value="${buslist.date}" /></td>
                    <td><c:out value="${buslist.bustype}" /></td>
                    <td><c:out value="${buslist.busno}" /></td>
                    <td><c:out value="${buslist.source}" /></td>
                    <td><c:out value="${buslist.destination}" /></td>
                    <td><c:out value="${buslist.availablity}" /></td>
                   <td><c:out value="${buslist.ticket_rate}" /></td> 
                    <td><a href="SelectServlet?id=<c:out value="${employee.id}"/>">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
</body>
</html> --%>
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
 <script>
function validate(){
if (alform.requiredseat.value == "") {
	alert("please enter seats");
	return false;
}
if (isNaN(alform.requiredseat.value)) {
	alert("please enter the numeric value for seats");
	return false;
}
return true;}

</script> 
</head>
<body> 
<h1> Availability List</h1> <br>

<h3>Discount</h3>
<h4>* 20% discount for booking 5 or more tickets</h4>
<h4>* 30% discount for booking 10 or more tickets</h4>


<table border=1>
        <thead>
            <tr>
                <th>Bus Number</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Seats Available</th>
                <th>Required Seats</th>
                <th>Ticket Rate </th>
                 <th>Book </th>                
            </tr>            
        </thead>
         <tbody>
         
            <c:forEach items="${BusList}" var="buslist">
           
                <tr>
                 <form name="alform" action="BookServlet" onsubmit="return validate()">
                 <%-- <td><c:out value="${buslist.date}" /></td>
                    <td><c:out value="${buslist.bus_type}" /></td> --%>
                    <td><c:out value="${buslist.busno}" /></td>
                    <td><c:out value="${buslist.source}" /></td>
                    <td><c:out value="${buslist.destination}" /></td>
                    <td><c:out value="${buslist.availablity}" /></td>
                    <td><input type="text" name="requiredseat"></td>
                   <td><c:out value="${buslist.ticket_rate}" /></td> 
                   <input type="hidden" name="id" value="${buslist.busno}"/>
                   <td><input type="submit" /></td>
                   <%--  <td><a href="BookServlet?id=${buslist.busno}"/>Book</a></td> --%>
                    </form>
                </tr>
               
            </c:forEach>
        </tbody>
</body>
</html>
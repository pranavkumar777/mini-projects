<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<script type="text/javascript">
 // function chec(){
//window.location="D:\\project\\availability\\index.html";}  
    
function back(){
window.location="D:\\project\\login\\index.html";}    

  </script>   
  
<form name="alform" action="AvailabilityServlet" method="post">
  <h1><center> Book Ticket Now </h1>
  <center>
  <p> From : <select>
  <option value="Chennai">Chennai</option>
  <option value="Mumbai">Mumbai</option>
  <option value="Trichy">Trichy</option>
  <option value="others">Others</option>
</select>
    <p> To : <select>
  <option value="Chennai">Bangalore</option>
  <option value="Mumbai">Mumbai</option>
  <option value="Trichy">Trichy</option>
  <option value="others">Others</option>
</select>
    <p> Bus type: <select>
  <option value="volvo">volvo</option>
  <option value="saab">express</option>
  <option value="mercedes">normal</option>
  <option value="audi">Others</option>
</select>  
      <p> Date of journey  <input id="date" type="date"> <br><br><br></p>
          <input type="submit" value="check availability" /><br><br>
		  <input type="button" value="back" onclick="back()"/>
  </form>
  



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
<script>



</script>
<style>
body {
    color: yellow;
}

h1 {
    color: green;
} 
body {
    background-color: lightgrey;
    width: 300px;
    border: 25px solid green;
    padding: 25px;
    margin: 25px;
}
 body {
    background-color: black;
  }
  
</style>


</head>

<body> 

<h1>BUS LIST</h1> <br>
<form name="bus" action="AvailabilityServlet" onsubmit="return validate()">

 <p> Source: 
<select name="source">
    <c:forEach var="list1" items="${listsource}">
        <option> <c:out value="${list1}"/></option>
    </c:forEach>
 </select>
<br>
<br>
 <p> Destination: 
<select name="destination">
    <c:forEach var="list1" items="${listdestination}">
        <option><c:out value="${list1}"/></option>
    </c:forEach>
 </select>
 
 

    <p> Bus type: <select name = "bustype">
  <option value="volvo">volvo</option>
  <option value="saab">express</option>
  <option value="mercedes">normal</option>
  <option value="audi">Others</option>
</select>  
      <p> Date of journey  <input name="date" type="date"> <br><br><br></p>
      
      Click submit to know selected bus availability.
           <input type="submit" value="Submit">
          
</form>
<form action="CancelServlet" method="get">
Click here to cancel tickets.
<input type="submit" value="cancel tickets"/>
</form>
 <%-- <table border=1>
        <thead>
            <tr>
                <th>Date</th>
                <th>Date</th>
                <th>Availability</th>
               
                <th colspan=2>Action</th>
            </tr>            
        </thead>
         <tbody>
            <c:forEach items="${list}" var="employee">
                <tr>
                    <td><c:out value="${employee.date}" /></td>
                    <td><c:out value="${employee.availablity}" /></td>
                   
                    <td><a href="SelectServlet?id=<c:out value="${employee.busno}"/>">Update</a></td>
                    <td><a href="DeleteEmployeeServlet?id=<c:out value="${employee.busno}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody> 
</body>
</html> --%>
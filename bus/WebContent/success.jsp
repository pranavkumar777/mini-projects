<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

body {
    color: yellow;
}

h1 {
    color: yellow;
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
<center>
<h1>Your Ticket has been booked </h1>

<%--
HttpSession sessionsa = request.getSession(false);
String user = (String) sessionsa.getAttribute("user");

--%>
  
Id:${user.userId} <br><br>
Name:${user.name} <br><br>
Source:${source}<br><br>
Destination:${destination}<br><br>
Date:${date}<br><br>
Bustype:${bustype}<br><br>

Total Price: ${totalPrice}<br>
<form    action="index.jsp">
<input type="submit" value="home page"></form>
</h1> </center>
</body>
</html>
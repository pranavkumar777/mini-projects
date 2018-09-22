
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function validate(){
	
	var name=/^[A-za-z]+$/;
	
	 var user1=alform.user.value;
	 if(alform.user.value=="")
	 {  alert("please enter valid username ");
	 return false;
	 }
	  if(!name.test(user1)){
	 
	 alert("username can only contain only alphabets(A-za-z)");
	  return false;
	 }
	  if(alform.password.value=="")
	  { 
	  alert("please enter valid password");
	  return false;}
	  
	  
	  
	  
	  
	return true;
	
}




</script>


</head>
<style>body {
    color: green;
}

h1 {
    color:yellow;
}
body {
    background-color: black;
}</style>


<body>

<center>
  <h1> ONLINE BUS RESERVATION</h1>
  <h2> Login </h2>

  <form name="alform" action="LoginServlet" method="post"  onsubmit="return validate()">
Username: <input type="text" name="user" value="pranav"><br><br>
 
Password: <input type="password" name="password" value="admin"> <br><br> 
  <input type="submit" value="submit" /> &nbsp; &nbsp;<br><br>
   

</form>
<input type="submit" value="signup" onclick="window.location.href='signup.jsp'" /><br><br>


<form action="adminlogin.jsp">
<input type="submit" value="Admin login">
</form>
</center>

</body>
</html>
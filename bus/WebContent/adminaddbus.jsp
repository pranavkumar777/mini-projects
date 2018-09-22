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
	color: green;
}

body {
	background-color: black;
}
</style>
<script>
function validate() {
	var name1 = /^[A-za-z]+$/;
	var num = /^[0-9]/;
	
	if (alform.busno.value == "") {
		alert("please enter busno");
		return false;
	}
	if (!num.test(alform.busno.value)) {
		alert("please enter valid busno");
		return false;
	}
	
	
	if (alform.source.value == "") {
		alert("please enter source ");
		return false;
	}
	if (!name1.test(alform.source.value)) {

		alert("destination can only contain only alphabets(A-za-z)");
		return false;
	}
	if (alform.destination.value == "") {
		alert("please enter destination ");
		return false;
	}
	if (!name1.test(alform.destination.value)) {

		alert("destination can only contain only alphabets(A-za-z)");
		return false;
	}
	
	if (alform.ticketrate.value == "") {
		alert("please enter ticketrate");
		return false;
	}

	if (isNaN(alform.ticketrate.value)) {
		alert("please enter the numeric value for ticket rate");
		return false;
	}
		
	if (alform.avail.value == "") {
		alert("please enter seats");
		return false;
	}
	if (isNaN(alform.avail.value)) {
		alert("please enter the numeric value for seats");
		return false;
	}

	return true;
}



</script>
</head>
<body>
<h1 align="center">Add Bus in Schedule</h1>
	<center>
		<form name="alform" action="AdminAddBus" method="get"
		onsubmit="return validate()"	>

			<table align="center">

				<tr>
					<td>DATE</td>
					<td><input name="date" type="date"/></td>
				</tr>

				<tr>
					<td>BUS NO.</td>
					<td><input maxlength="99" size="12" type="TEXT" name="busno"
						value="24" /></td>
				</tr>

				<tr>
					<td>BUS TYPE</td>
					<td><select name="bustype">
							<option value="volvo">volvo</option>
							<option value="saab">express</option>
							<option value="mercedes">normal</option>
							<option value="audi">Others</option>
					</select></td>
				</tr>

				<tr>
					<td>SOURCE</td>
					<td><input maxlength="99" size="30" type="TEXT" name="source"
						value="chennai" /></td>
				</tr>

				<tr>
					<td>DESTINATION</td>
					<td><input maxlength="99" size="10" type="TEXT"
						name="destination" value="bangalore" /></td>
				<tr>
					<td>TICKET RATE</td>
					<td><input name="ticketrate" type="text" value="350"/> </td>
				</tr>


				<tr>
					<td>NUMBER OF SEATS</td>
					<td><input type="TEXT" name="avail" value="50" /></td>
				</tr>


			</table>
			<input type="submit" value="submit" /> 
			<input type="reset"
				value="reset" />
				</form></center>

</body>
</html>
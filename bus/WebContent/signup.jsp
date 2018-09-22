<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function validate() {
		var name1 = /^[A-za-z]+$/;
		var pwd = /^[A-za-z]{8,12}$/;
		var num = /^[0-9]/;
		var e = /^[A-za-z\d]+@[a-z]{3,5}.[a-z]{2,3}$/;
		if (alform.name.value == "") {
			alert("please enter name ");
			return false;
		}
		if (!name1.test(alform.name.value)) {

			alert("name can only contain only alphabets(A-za-z)");
			return false;
		}
		if (alform.age.value == "") {
			alert("please enter age");
			return false;
		}

		if (alform.address.value == "") {
			alert("please enter address");
			return false;
		}
		if (!num.test(alform.age.value)) {
			alert("please enter valid age");
			return false;
		}

		if (alform.email.value == "") {
			alert("please enter email");
			return false;
		}
		if (!e.test(alform.email.value)) {
			alert("please enter valid email");
			return false;
		}

		if (alform.telephone.value == "") {
			alert("please enter telephone");
			return false;
		}

		if (isNaN(alform.telephone.value)) {
			alert("please enter the numeric value");
			return false;
		}
				if ((alform.gender[0].checked == false)
				&& (alform.gender[1].checked == false)) {
			alert("please select your gender");
			return false;
		}

		if (alform.password.value == "") {
			alert("please enter password");
			return false;
		}
		return true;
	}
</script>



</head>

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
<body>
	<center>
		<form name="alform" action="AddServletSignup" method="post"
			onsubmit="return validate()">

			<h1 align="center">SIGN UP DETAILS</h1>
			<table align="center">

				<tr>
					<td>NAME</td>
					<td><input maxlength="99" size="20" type="TEXT" name="name" value="Raj" /></td>
				</tr>

				<tr>
					<td>AGE</td>
					<td><input maxlength="99" size="12" type="TEXT" name="age"
						value="24" /></td>
				</tr>

				<tr>
					<td>ADDRESS</td>
					<td><input maxlength="99" size="42" type="TEXT" name="address" value="chennai"/></td>
				</tr>

				<tr>
					<td>EMAIL</td>
					<td><input maxlength="99" size="30" type="TEXT" name="email"
						value="test@abc.com" /></td>
				</tr>

				<tr>
					<td>TELEPHONE</td>
					<td><input maxlength="99" size="10" type="TEXT"
						name="telephone" value="98789" /></td>
				<tr>
					<td>SELECT YOUR GENDER :</td>
					<td><input name="gender" type="radio" value="male" /> MALE <input
						name="gender" type="radio" value="female" /> FEMALE</td>
				</tr>

				<!-- <tr><td>USERNAME:</td><td><input type="text" name="userid"></td></tr> -->

				<tr>
					<td>PASSWORD:</td>
					<td><input type="password" name="password" value="admin" /></td>
				</tr>


			</table>
			<input type="submit" value="submit" /> <input type="reset"
				value="reset" />

	</form>

	</center>




</body>
</html>
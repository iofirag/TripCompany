<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<h1>Add Instructor:</h1><br><br>
	<form action="../controller/addInstructor" method="get">
		Instructor ID: <input type="text" name="instructorId"><br>
		First Name: <input type="text" name="firstName"><br>
		Last Name: <input type="text" name="lastName"><br>
		Address: <input type="text" name="address"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
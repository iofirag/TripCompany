<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<h1>Add Site:</h1><br><br>
	<form action="../controller/addSite" method="get">
		Site name: <input type="text" name="siteName"><br>
		Instructor ID: <input type="text" name="instructorId"><br>
		Duration: <input type="text" name="duration"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
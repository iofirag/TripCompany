<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<%

String instructorId = (String)request.getAttribute("instructorId");
String instuctorIdOld = instructorId; // Save P.k for future
String name = (String)request.getAttribute("name");
String lastName = (String)request.getAttribute("lastName");
String address = (String)request.getAttribute("address");

%>

<h1>Update Instructor:</h1><br><br>

	<form action="../controller/updateInstructorAfterPreview" method="get">
		<input type="hidden" name="instuctorIdOld" value="<% out.print(instuctorIdOld); %>">
		Instructor ID: <input type="text" name="instructorId" value="<% out.print(instructorId); %>"><br>
		Name: <input type="text" name="name" value="<% out.print(name); %>"><br>
		Last Name: <input type="text" name="lastName" value="<% out.print(lastName); %>"><br>
		Address: <input type="text" name="address" value="<% out.print(address); %>"><br>
		<input type="submit" value="Update">
	</form>
</body>
</html>
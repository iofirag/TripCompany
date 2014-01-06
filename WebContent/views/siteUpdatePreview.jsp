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

String name = (String)request.getAttribute("name");
String nameOld = name; // Save P.K for future use
String instructorId = (String)request.getAttribute("instructorId");
String duration = (String)request.getAttribute("duration");

%>
<h1>Update Site:</h1><br><br>

<form action="../controller/updateSiteAfterPreview" method="get">
	<input type="hidden" name="nameOld" value="<% out.print(nameOld); %>">
	Site name: <input type="text" name="name" value="<% out.print(name); %>"><br>
	Instructor ID: <input type="text" name="instructorId" value="<% out.print(instructorId); %>"><br>
	Duration: <input type="text" name="duration" value="<% out.print(duration); %>"><br>
	<input type="submit" value="Update">
</form>
</body>
</html>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	 <!-- Bootstrap core CSS -->
    <link href="../dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron-narrow.css" rel="stylesheet">
    
</head>
<body>
<h1>Number of sites per instructor:</h1>
<table class="table table-hover">
<% ResultSet  rs = (ResultSet)request.getAttribute("rs");
int counter=1;
out.print("<tr><th>No.</th> <th>Instructor ID</th> <th>Instructor name</th> <th>Instructor last-name</th> <th>Number of sites</th></tr>");
while (rs.next())
{
	out.print("<tr><td>"+counter+"</td>  <td>"+rs.getString("instructorId") +"</td>      <td>"+rs.getString("name")+"</td>     <td>"+rs.getString("lastName")+"</td><td>"+ rs.getString("number_of_sites")+"</td></tr>");
	counter++;
}
%>
</table>
</body>
</html>
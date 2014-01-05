<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<% ResultSet  rs = (ResultSet)request.getAttribute("ResultSet");
int counter=1;
while (rs.next())
{
	out.print(counter + ". " + rs.getString("name") + " ," + "Price:"+ rs.getFloat("ratePerTravEler")+"<br>");
	counter++;
}
if (counter==1)
{
	out.print("<h2>There are 0 results</h2>");
}
%>
</body>
</html>
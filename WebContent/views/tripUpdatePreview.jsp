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

int tripId = (Integer)request.getAttribute("tripId");
String name = (String)request.getAttribute("name");
String startDate = (String)request.getAttribute("startDate");
String endDate = (String)request.getAttribute("endDate");
double ratePerTraveler = (Double)request.getAttribute("ratePerTraveler");
int numOfTravelers = (Integer)request.getAttribute("numOfTravelers");


%>

<h1>Update Trip:</h1><br><br>

<form action="../controller/updateTripAfterPreview" method="get">
<input type="hidden" name="tripId" value="<% out.print(tripId); %>">
Trip name: <input type="text" name="name" value="<% out.print(name); %>"><br>
Start date: <input type="text" name="startDate" value="<% out.print(startDate); %>"><br>
End date: <input type="text" name="endDate" value="<% out.print(endDate); %>"><br>
Rate per traveler: <input type="text" name="ratePerTraveler" value="<% out.print(ratePerTraveler); %>"><br>
num Of Travelers:<input type="text" name="numOfTravelers" value="<% out.print(numOfTravelers); %>"><br>
<input type="submit" value="Update">
</form>
</body>
</html>
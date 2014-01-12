<%@page import="com.shenkar.tripcompany.Controller"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="com.shenkar.tripcompany.Controller, java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<%

	//Create connection and open statement
	try {
		Connection connecion = Controller.getConnection();
		Statement statement = connecion.createStatement();
	
		//Create tables
	    try{
	    	statement.executeUpdate(Controller.createdeletedTripsBackup);
							System.out.println("create deletedTripBackup table");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    try{
			statement.executeUpdate(Controller.createTripTable);
							System.out.println("create trip table");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		try{
			statement.executeUpdate(Controller.createInstructorTable);
							System.out.println("create instructor table");
		}catch(Exception e){
	    	e.printStackTrace();
	    }
		try{
	        statement.executeUpdate(Controller.createSiteTable);
							System.out.println("create site table");
		}catch(Exception e){
	    	e.printStackTrace();
	    }
	    try{
	        statement.executeUpdate(Controller.createTravelerTable);
							System.out.println("create traveler table");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    try{
	        statement.executeUpdate(Controller.createManagerTable);
	        				System.out.println("create manager table");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	    //Create procedure	    	
	    try{  	
	        statement.executeUpdate(Controller.dropProcedureTripsCheaperThenProcdure);
										System.out.println("Drop Procdure.");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    try{  	
	        statement.executeUpdate(Controller.tripsCheaperThenProcdure);
										System.out.println("Create Procedure.");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	    //Create trigger
	    try{      	
	        statement.executeUpdate(Controller.triggerBeforeDelete);
	        							System.out.println("Create Trigger.");
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>
</body>
</html>
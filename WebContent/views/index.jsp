<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page errorPage="showError.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Narrow Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron-narrow.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
	      <div class="header">
	        <ul class="nav nav-pills pull-right">
	          <li class="active"><a href="../views/index.jsp">Home</a></li>
	          <li><a href="../views/about.jsp">About</a></li>
	          <li><a href="../views/contact.jsp">Contact</a></li>
	        </ul>
	        <h3 class="text-muted">MySQL Project 2014</h3>
	      </div>
		by Ofir Aghai & Vidran Abdovich<br>
		<br><br>
	
	
	<!--  trip -->
		<div class="panel panel-primary">
		<div class="panel-heading">Trip options</div>
		  	<div class="panel-body">
			   	<a href = "../views/addTrip.jsp"><button type="button" class="btn btn-primary">Add trip</button></a>
			   	<br>
			   	
				<form action= "../controller/tripUpdatePreview" method="get">
				    Trip Name to update: <input type="Text" name="tripUpdateName">
				    <!-- submit-button update trip -->
				    <button type="submit" class="btn btn-primary">Update Trip</button>
				</form>
				
				  <br>
				  
				<form action="../controller/deleteTrip" method="get">
				    Trip name to delete: <input type="Text" name="tripDeleteName">
				    <!-- submit-button delete trip -->
				    <button type="submit" class="btn btn-primary">Delete Trip</button>
				</form>
				
			</div>
		</div>
		
	<!-- instructor -->
		<div class="panel panel-success">
		<div class="panel-heading">Instructor options</div>
		  	<div class="panel-body">
			   	<a href = "../views/addInstructor.jsp"><button type="button" class="btn btn-success">Add Instructor</button></a>
			   	<br>
			   	
				<form action= "../controller/instructorUpdatePreview" method="get">
				    Instructor ID to update: <input type="Text" name="instructorUpdateId">
				    <!-- submit-button update trip -->
				    <button type="submit" class="btn btn-success">Update Instructor</button>
				</form>
				
				  <br>
				  
				<form action="../controller/deleteInstructor" method="get">
				    Instructor name to delete: <input type="Text" name="instructorDeleteName">
				    <!-- submit-button delete trip -->
				    <button type="submit" class="btn btn-success">Delete Instructor</button>
				</form>
				
			</div>
		</div>
	
	<!-- Site -->
		<div class="panel panel-danger">
		<div class="panel-heading">Site options</div>
		  	<div class="panel-body">
			   	<a href = "../views/addSite.jsp"><button type="button" class="btn btn-danger">Add Site</button></a>
			   	<br>
			   	
				<form action= "../controller/siteUpdatePreview" method="get">
				    Site name to update: <input type="Text" name="siteUpdateName">
				    <!-- submit-button update trip -->
				    <button type="submit" class="btn btn-danger">Update Site</button>
				</form>
				
				  <br>
				  
				<form action="../controller/deleteSite" method="get">
				    Site name to delete: <input type="Text" name="siteDeleteName">
				    <!-- submit-button delete trip -->
				    <button type="submit" class="btn btn-danger">Delete Site</button>
				</form>
				
			</div>
		</div>
		
	<!-- Procedure sites. -->
		<div class="panel panel-warning">
		<div class="panel-heading">Procedure example</div>
		  	<div class="panel-body">
			   	This is an example of a procedure that will retrieve all trips that have a lower price then the one that is passed to the procedure.
			   	<form action="../controller/procedure_example" method="get">
			   		Show all trips with price lower then:
			   		<input type="Text" name="procedureText">
			   		<button type="submit" class="btn btn-warning">Show trips</button>
			   	</form>
				
			</div>
		</div>

		<div class="footer">
        <p>&copy; MySQL final project - Vidran Abdovich & Ofir Aghai 2014</p>
      </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
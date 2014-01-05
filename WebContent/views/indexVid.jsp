<%-- <%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>MySQL Project 2014 - Vidran Abdovich & Ofir Aghai</title>

    <!-- Bootstrap core CSS -->
    <link href="../views/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../views/css/jumbotron-narrow.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">About</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
        <h3 class="text-muted">MySQL Project 2014</h3><small>by Ofir Aghai & Vidran Abdovich</small>
      </div>
      <br><br>
      
<!-- Trip -->
	<div class="panel panel-primary">
	 <div class="panel-heading">Trip options</div>
	 <div class="panel-body">
	<a href="../views/addTrip.jsp"> <button class="btn btn-primary">Add Trip</button></a>
	<br>
	
	<form action="../controller/updateTripPreview" method="get">
	Trip name to update: <input type="text" name="tripNameToUpdate" required>
	<button type="submit" class="btn btn-primary">Update Trip</button>
	</form>	
	<br>
	
	<form action="../controller/deleteTrip" method="get">
	Trip name to delete: <input type="text" name="tripNameToDelete" required>
	<button type="submit" class="btn btn-primary">Delete Trip</button>
	</form>	
	</div>
	</div>
<!-- End of trip -->	
		
<!-- instructor -->
	<div class="panel panel-success">
	<div class="panel-heading">Instructor options</div>
	 <div class="panel-body">
	<a href="../views/addInstructor.jsp"><button class="btn btn-success">Add Instructor</button></a>
	<br>
	<form action="../controller/updateInstructorPreview" method="get">
	Instructor name to update: <input type="text" name="instructorNameToUpdate" required>
	<button type="submit" class="btn btn-success">Update Instructor</button>
	</form>
	<br>
	<form action="../controller/deleteInstructor" method="get">
	Instructor name to delete: <input type="text" name="instructorNameToDelete" required>
	<button type="submit" class="btn btn-success">Delete Instructor</button>
	</form>
	</div>
	</div>
<!-- End of instructor -->	
	
<!-- Site -->
	<div class="panel panel-danger">
	<div class="panel-heading">Site options</div>
	 <div class="panel-body">
	<a href="../views/addSite.jsp"><button class="btn btn-danger">Add Site</button></a>
	<br>
	<form action="../controller/updateSitePreview" method="get">
	Site name to update: <input type="text" name="siteNameToUpdate" required>
	<button type="submit" class="btn btn-danger">Update Site</button>
	</form>
	<br>
	<form action="../controller/deleteSite" method="get">
	Site name to delete: <input type="text" name="siteNameToDelete" required>
	<button type="submit" class="btn btn-danger">deleteSite</button>
	</form>
	</div>
	</div>
<!-- End OF Site -->


<!-- Procedure example -->
	<div class="panel panel-warning">
	<div class="panel-heading">Procedure example</div>
	 <div class="panel-body">
	This is an example of a procedure that will retrieve all trips that have
	a lower price then the one that is passed to the procedure.
	
	<form action="../controller/procedureExample" method="get">
	Show all trips with price lower then: <input type="text" name="tripPrice" required>
	<button type="submit" class="btn btn-warning">Show trips</button>
	</form>
	<br>
	
	</div>
	</div>
<!-- End OF procedure exampls -->

      <div class="footer">
        <p>&copy; MySQL final project - Vidran Abdovich & Ofir Aghai 2014</p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html> --%>
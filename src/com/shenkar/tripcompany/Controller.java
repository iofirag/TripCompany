package com.shenkar.tripcompany;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	Connection connection = null;
	
	 String createdeletedTripsBackup = "CREATE TABLE deletedtripsbackup2 ("
            +"        tripId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
            +"        name VARCHAR(30), "
            +"        startDate VARCHAR(30), "
            +"        endDate VARCHAR(30), "
            +"        numOfTravelers INT(4), "
            +"        ratePerTraveler FLOAT(4) "
            +"        )";
	
	 String createTripTable = "CREATE TABLE trip ("
            +"        tripId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
            +"        name VARCHAR(30), "
            +"        startDate VARCHAR(30), "
            +"        endDate VARCHAR(30), "
            +"        numOfTravelers INT(4), "
            +"        ratePerTraveler FLOAT(4) "
            +"        )";
	
	 String createInstructorTable = "CREATE TABLE instructor ("
	        +"        instructorId VARCHAR(30) NOT NULL PRIMARY KEY, "
	        +"        name VARCHAR(30), "
	        +"        lastName VARCHAR(30), "
	        +"        address VARCHAR(30) "
	        +"        )";
	
	 String createSiteTable = "CREATE TABLE site ("
	        +"        name VARCHAR(30) NOT NULL PRIMARY KEY, "
	        +"        instructorId VARCHAR(30), "
	        +"        duration VARCHAR(5) "
	        +"        )";
	 String createTravelerTable = "CREATE TABLE traveler ("
	        +"        travelerId VARCHAR(30) NOT NULL PRIMARY KEY, "
	        +"        name VARCHAR(30), "
	        +"        lastName VARCHAR(30), "
	        +"        rate FLOAT(4) "                //maybe a mistake to have rate in traveler
	        +"        )";
	 String createManagerTable = "CREATE TABLE manager ("
	        +"        managerId VARCHAR(30) NOT NULL PRIMARY KEY, "
	        +"        name VARCHAR(30), "
	        +"        lastName VARCHAR(30), "
	        +"        address VARCHAR(30), "                //maybe a mistake to have rate in traveler
	        +"        managingArea VARCHAR(30) "
	        +"        )";
	
	
	 String dropProcedureTripsCheaperThenProcdure= 
			" DROP PROCEDURE IF EXISTS getTripsCheaperThen ;";
	
	 String tripsCheaperThenProcdure = 
			 "CREATE PROCEDURE getTripsCheaperThen(IN tripPrice FLOAT)"
			+" BEGIN"
			+" SELECT * FROM trip WHERE ratePerTraveler <= tripPrice;"
			+" END; ";
	
	
	 String triggerBeforeDelete = 
			" CREATE TRIGGER tripBackup"
			+ " BEFORE DELETE ON trip"
			+ " FOR EACH ROW"
			+ " BEGIN"
			+ " INSERT INTO deletedtripsbackup2 (name,startDate,endDate,numOfTravelers,ratePerTraveler)" 
			+ " VALUES (OLD.name, OLD.startDate, OLD.endDate, OLD.numOfTravelers, OLD.ratePerTraveler);"
			+ " END; ";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        System.out.println("controller constructor");
        
        try{
        	
	    		
	    		
		        //Create tables
	
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "jaja", "gaga");
	        	
	              
	            //executing statements the create the main tables
	        	try{
	        		Statement statement = connection.createStatement();
	        		
	        	statement.executeUpdate(createdeletedTripsBackup);
				statement.executeUpdate(createTripTable);
				statement.executeUpdate(createInstructorTable);
	            statement.executeUpdate(createSiteTable);
	            statement.executeUpdate(createTravelerTable);
	            statement.executeUpdate(createManagerTable);
	            System.out.println("create tables");
	        	}
	        	catch(SQLException e)
	        	{
	        		e.printStackTrace();
	        	}
	            //executing a procedure code
	        	try{
	        	Statement statement = connection.createStatement();
	            statement.executeUpdate(dropProcedureTripsCheaperThenProcdure);
	            statement.executeUpdate(tripsCheaperThenProcdure);
	            statement.executeUpdate(triggerBeforeDelete);
	        	}
	        	catch(SQLException e)
	        	{
	        		e.printStackTrace();
	        	}
	           		
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getPathInfo();
		System.out.println("doGet");
		try {
		    
	    	

		    
////--------------Add------------------------------------------------ 
			//working!
	    	if (str.equals("/addTrip")){
				String tripName= request.getParameter("tripName");
				String startDate= request.getParameter("startDate");
				String endDate= request.getParameter("endDate");
				String ratePerTraveler= request.getParameter("ratePerTraveler");
				String numOfTravelers= request.getParameter("numOfTravelers");
				PreparedStatement prepstate = connection.prepareStatement
				("INSERT INTO trip (`name`, `startDate`, `endDate`, `numOfTravelers`, `ratePerTraveler`) "
						+ "VALUES (?, ?, ?, ?, ?)");
				prepstate.setString(1, tripName);
				prepstate.setString(2, startDate);
				prepstate.setString(3, endDate);
				prepstate.setInt(4, Integer.parseInt(numOfTravelers));
				prepstate.setDouble(5, Double.parseDouble(ratePerTraveler));
				prepstate.execute();
				prepstate.close();
				
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/index.jsp");
				dispatcher.forward(request, response);	
		    }
	    	//working!
		    else if(str.equals("/addInstructor")){
		    	String instructorId= request.getParameter("instructorId");
				String firstName= request.getParameter("firstName");
				String lastName= request.getParameter("lastName");
				String address= request.getParameter("address");
				PreparedStatement prepstate = connection.prepareStatement
				("INSERT INTO instructor (`instructorId`, `name`, `lastName`, `address`) "
						+ "VALUES (?, ?, ?, ?)");
				prepstate.setString(1, instructorId);
				prepstate.setString(2, firstName);
				prepstate.setString(3, lastName);
				prepstate.setString(4, address);
				prepstate.execute();
				prepstate.close();
				
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/index.jsp");
				dispatcher.forward(request, response);
		    }
	    	//working!
			else if(str.equals("/addSite")){
				String siteName= request.getParameter("siteName");
				String instructorId= request.getParameter("instructorId");
				// optional: check if instuctor-id exist in `tripcompany.instructor` table
				String duration= request.getParameter("duration");
				PreparedStatement prepstate = connection.prepareStatement
				("INSERT INTO site (`name`, `instructorId`, `duration`) "
						+ "VALUES (?, ?, ?)");
				prepstate.setString(1, siteName);
				prepstate.setString(2, instructorId);
				prepstate.setString(3, duration);
				prepstate.execute();
				prepstate.close();
				
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/index.jsp");
				dispatcher.forward(request, response);		
			}
		    	    	
	    	
////---------preview (before update)----------------------------------------------------- 
	    	//Working!
			else if (str.equals("/tripUpdatePreview")){
                //Select in database the trip with the name passed to the controller
                //then pass the trip details to jsp preview form
				String tripUpdateName= request.getParameter("tripUpdateName");
				// Trip fields
				String name = null;
                String startDate= null;
                String endDate= null;
                double ratePerTraveler = 0;
                int numOfTravelers = 0;
                int tripId=0;
                try {
                	//Including SQL FUNCTION LCASE()
	                	PreparedStatement prepstate = connection.prepareStatement ("SELECT * FROM trip WHERE LCASE( nAMe )=?");
	                    prepstate.setString(1, tripUpdateName);
	                    ResultSet rs = prepstate.executeQuery();
	                    while (rs.next())
	                    {
	                    	if(rs.getString("name").equals(tripUpdateName)){
	                            tripId=        rs.getInt("tripId");
	                            name = rs.getString("name");
	                            startDate = rs.getString("startDate");
	                            endDate = rs.getString("endDate");
	                            ratePerTraveler = rs.getDouble("ratePerTraveler");
	                            numOfTravelers = rs.getInt("numOfTravelers"); 
	                            break;
	                    	}
	                    }
	                    request.setAttribute("tripId", tripId);
	                    request.setAttribute("name", name);
	                    request.setAttribute("startDate", startDate);
	                    request.setAttribute("endDate", endDate);
	                    request.setAttribute("ratePerTraveler", ratePerTraveler);
	                    request.setAttribute("numOfTravelers", numOfTravelers);
                        
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                RequestDispatcher dispatcher = getServletContext()
                                .getRequestDispatcher("/views/tripUpdatePreview.jsp");
                dispatcher.forward(request, response);        
			}
	    	
	    	//Working!
			else if(str.equals("/instructorUpdatePreview")){
				String instructorUpdateId= request.getParameter("instructorUpdateId");
				// instructor fields
				String instructorId = null;
				String name = null;
				String lastName = null;
				String address = null;
                try {
                		PreparedStatement prepstate = connection.prepareStatement ("SELECT * FROM instructor WHERE instructorId=?");
                        prepstate.setString(1, instructorUpdateId);
                        ResultSet rs = prepstate.executeQuery();
                        while (rs.next())
                        {
                        	if(rs.getString("instructorId").equals(instructorUpdateId)){
                        		instructorId = rs.getString("instructorId");
                        		name = rs.getString("name");
                        		lastName = rs.getString("lastName");
                        		address = rs.getString("address");
                        		break;
                        	}
                        }
                        request.setAttribute("instructorId", instructorId);
                        request.setAttribute("name", name);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("address", address);
                        
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                RequestDispatcher dispatcher = getServletContext()
                                .getRequestDispatcher("/views/instructorUpdatePreview.jsp");
                dispatcher.forward(request, response);   
			}
	    	
	    	//Working
			else if(str.equals("/siteUpdatePreview")){
				String siteUpdateName= request.getParameter("siteUpdateName");
				// Site fields
				String name = null;
				String instructorId = null;
				String duration = null;
                try {
                		PreparedStatement prepstate = connection.prepareStatement ("SELECT * FROM site WHERE name=?");
                        prepstate.setString(1, siteUpdateName);
                        ResultSet rs = prepstate.executeQuery();
                        while (rs.next())
                        {
                        	if(rs.getString("name").equals(siteUpdateName)){
                        		name = rs.getString("name");
                        		instructorId = rs.getString("instructorId");
                        		duration = rs.getString("duration");
                        		break;
                        	}
                        }
                        request.setAttribute("name", name);
                        request.setAttribute("instructorId", instructorId);
                        request.setAttribute("duration", duration);
                        
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                RequestDispatcher dispatcher = getServletContext()
                                .getRequestDispatcher("/views/siteUpdatePreview.jsp");
                dispatcher.forward(request, response); 
		    }
	    	
	    	
		    
////------------Update-After Preview------------------------------------------------- 
	    	//Working!
			else if(str.equals("/updateTripAfterPreview")){
				// Trip fields
				int tripId= Integer.parseInt( request.getParameter("tripId") ); // P.k
				String name = request.getParameter("name");
                String startDate= request.getParameter("startDate");
                String endDate= request.getParameter("endDate");
                int numOfTravelers = Integer.parseInt( request.getParameter("numOfTravelers") );
                double ratePerTraveler = Double.parseDouble( request.getParameter("ratePerTraveler")  );
                
//                //add to db this fields
                PreparedStatement prepstate = connection.prepareStatement (" UPDATE trip SET name=?, startDate=?, endDate=?, numOfTravelers=?, ratePerTraveler=? WHERE tripId=?" );
                prepstate.setString(1, name);
                prepstate.setString(2, startDate);
                prepstate.setString(3, endDate);
                prepstate.setInt(4, numOfTravelers);
                prepstate.setDouble(5, ratePerTraveler);
                prepstate.setInt(6, tripId);
                prepstate.executeUpdate();

                RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/success.jsp");
				dispatcher.forward(request, response);
		    }
	    	
	    	//Working
			else if(str.equals("/updateInstructorAfterPreview")){
				// Instructor fields
				String instructorId = request.getParameter("instructorId");
				String instuctorIdOld = request.getParameter("instuctorIdOld"); // Save P.k for future
				String name = request.getParameter("name");
				String lastName = request.getParameter("lastName");
				String address = request.getParameter("address");
				
				//add to db this fields
                PreparedStatement prepstate = connection.prepareStatement (" UPDATE instructor SET instructorId=?, name=?, lastName=?, address=? WHERE instructorId=?");
                prepstate.setString(1, instructorId);
                prepstate.setString(2, name);
                prepstate.setString(3, lastName);
                prepstate.setString(4, address);
                prepstate.setString(5, instuctorIdOld);
                prepstate.executeUpdate();
                
                RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/success.jsp");
				dispatcher.forward(request, response);
			}
	    	
	    	//Working!
			else if(str.equals("/updateSiteAfterPreview")){
				// Site fields
				String name = request.getParameter("name");
				String nameOld = request.getParameter("nameOld"); // Save P.K for future use
				String instructorId = request.getParameter("instructorId");
				String duration = request.getParameter("duration");
				
				//add to db this fields
                PreparedStatement prepstate = connection.prepareStatement ("UPDATE site SET name=?, instructorId=?, duration=? WHERE name=?" );
                prepstate.setString(1, name);
                prepstate.setString(2, instructorId);
                prepstate.setString(3, duration);
                prepstate.setString(4, nameOld);
                prepstate.executeUpdate();

                RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/success.jsp");
				dispatcher.forward(request, response);
		    }    
		    
		    
		    
////---------Delete----------------------------------------------------- 
	    	//Working!
			else if(str.equals("/deleteTrip")){
                String TripNameToDelete= request.getParameter("tripDeleteName");
                PreparedStatement prepstate = null;
                try {
                        prepstate = connection.prepareStatement
                        ("DELETE FROM `trip` WHERE name=?");
                        prepstate.setString(1, TripNameToDelete);
                        prepstate.execute();
                } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                }
		        RequestDispatcher dispatcher = getServletContext()
		                        .getRequestDispatcher("/views/index.jsp");
		        dispatcher.forward(request, response);                        
				}
	    	
	    	//Working!
			else if(str.equals("/deleteInstructor")){
                String instructorIdToDelete= request.getParameter("instructorDeleteId");
                PreparedStatement prepstate = null;
                try {
                        prepstate = connection.prepareStatement
                        ("DELETE FROM `instructor` WHERE instructorId=?");
                        prepstate.setString(1, instructorIdToDelete);
                        prepstate.execute();
                } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                }
		        RequestDispatcher dispatcher = getServletContext()
		                        .getRequestDispatcher("/views/index.jsp");
		        dispatcher.forward(request, response);                        
				}
		
			else if(str.equals("/deleteSite")){
                String siteNameToDelete= request.getParameter("siteDeleteName");
                PreparedStatement prepstate = null;
                try {
                        prepstate = connection.prepareStatement
                        ("DELETE FROM `site` WHERE name=?");
                        prepstate.setString(1, siteNameToDelete);
                        prepstate.execute();
                } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                }
		        RequestDispatcher dispatcher = getServletContext()
		                        .getRequestDispatcher("/views/index.jsp");
		        dispatcher.forward(request, response);                        
				}
			
///-----------Procedures----------------------------------------------------
			else if (str.equals("/procedureExample")){
				String tripPrice = request.getParameter("tripPrice");
				float price = Float.parseFloat(tripPrice);
				CallableStatement cs;
				ResultSet rs = null;
				try {
					cs = connection.prepareCall("call getTripsCheaperThen(?)");
					cs.setFloat(1, price);
				    rs = cs.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("ResultSet", rs);
				
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/procedureOutcome.jsp");
				dispatcher.forward(request, response);	
			}

	    	
	    	
////---------About-----------------------------------------------------
			else if (str.equals("/about")){
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/about.jsp");
				dispatcher.forward(request, response);
			}
			else if (str.equals("/contact")){
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/contact.jsp");
				dispatcher.forward(request, response);
			}
		    
	
	    	
////---------Drop All-----------------------------------------------------
			else if(str.equals("/dropAll")){
				Statement statement = connection.createStatement();
				statement.execute("DROP TABLE trip");
				statement.execute("DROP TABLE traveler");
				statement.execute("DROP TABLE site");
				statement.execute("DROP TABLE manager");
				statement.execute("DROP TABLE instructor");
				statement.close();
				System.out.println("drop all completed.");
			}
////---------------------------------------------------------------------------
			else if(str.equals("/twoFiltersSelect")){
				Statement statement = connection.createStatement();
				String tripName= request.getParameter("tripName");
				String numOfTravelers= request.getParameter("numOfTravelers");
				
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM  `trip` WHERE name = ? AND numOfTravelers < ? ");
                ps.setString(1, tripName);
                ps.setInt(2, Integer.parseInt(numOfTravelers));
                ResultSet rs = ps.executeQuery();
                request.setAttribute("rs", rs);
                statement.close();
				System.out.println("Filter executed");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/twoFiltersTrip.jsp");
				dispatcher.forward(request, response);
			}
		    
	
	    	
	    	
////---------index--------------------------------------------------------
			else{
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/index.jsp");
				dispatcher.forward(request, response);
			}

////---------Error page----------------------------------------------------
		}catch (Exception  e) {
			// TODO Auto-generated catch block
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/showError.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}

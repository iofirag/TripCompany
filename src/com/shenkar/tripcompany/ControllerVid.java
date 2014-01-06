package com.shenkar.tripcompany;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/controllerVid/*")
public class ControllerVid extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public ControllerVid()  {
                super();
        }

        
        protected void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
                        String str = request.getPathInfo();
                        
                        //Create trip table statement
                        String createTripTable = "CREATE TABLE trip ("
                                                +"        tripId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                                                +"        name VARCHAR(30), "
                                                +"        startDate VARCHAR(30), "
                                                +"        endDate VARCHAR(30), "
                                                +"        numOfTravelers INT(4), "
                                                +"        ratePerTraveler FLOAT(4) "
                                                +"        )";
                        String createInstructorTable = "CREATE TABLE instructor ("
                                        +"        instructorId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                                        +"        name VARCHAR(30), "
                                        +"        lastName VARCHAR(30), "
                                        +"        address VARCHAR(30) "
                                        +"        )";
                        String createSiteTable = "CREATE TABLE site ("
                                        +"        name VARCHAR(30) NOT NULL PRIMARY KEY, "
                                        +"        instructorId INT(3), "
                                        +"        duration VARCHAR(5) "
                                        +"        )";
                        String createTravelerTable = "CREATE TABLE traveler ("
                                        +"        travelerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                                        +"        name VARCHAR(30), "
                                        +"        lastName VARCHAR(30), "
                                        +"        rate FLOAT(4) "                //maybe a mistake to have rate in traveler
                                        +"        )";
                        String createManagerTable = "CREATE TABLE manager ("
                                        +"        managerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                                        +"        name VARCHAR(30), "
                                        +"        lastName VARCHAR(30), "
                                        +"        address VARCHAR(30), "                //maybe a mistake to have rate in traveler
                                        +"        managingArea VARCHAR(30) "
                                        +"        )";
                        String dropProcedureTripsCheaperThenProcdure= "DELIMITER //"
                                        + "DROP PROCEDURE IF EXISTS tripsCheaperThenProcdure //"
                                        + "DELIMITER ;";
                        
                        String tripsCheaperThenProcdure = "DELIMITER // "
                                        +" CREATE PROCEDURE getTripsCheaperThen(IN tripPrice FLOAT) "
                                        +" BEGIN "
                                        +" SELECT * FROM trip WHERE ratePerTraveler < tripPrice; "
                                        +" END // "
                                        +" DELIMITER ; ";
                        try {
                                Class.forName("com.mysql.jdbc.Driver");
                        } catch (ClassNotFoundException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                        }
                        Connection connection = null;
                        try {
                        		connection = DriverManager.getConnection("jdbc:mysql://localhost/tripcompany", "jaja", "gaga");
                                Statement statement = connection.createStatement();
                                //executing statements the create the main tables
                                statement.executeUpdate(createTripTable);
                                statement.executeUpdate(createInstructorTable);
                                statement.executeUpdate(createSiteTable);
                                statement.executeUpdate(createTravelerTable);
                                statement.executeUpdate(createManagerTable);
                                //executing a procedure code
                                //statement.executeUpdate(dropProcedureTripsCheaperThenProcdure);
                                //statement.executeUpdate(tripsCheaperThenProcdure);
                        } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        

                // Add a trip to database - WORKING!
                if (str.equals("/addTrip")){
                        
                        try {
                                String tripName= request.getParameter("tripName");
                                String startDate= request.getParameter("startDate");
                                String endDate= request.getParameter("endDate");
                                String ratePerTraveler= request.getParameter("ratePerTraveler");
                                String numOfTravelers= request.getParameter("numOfTravelers");
                                PreparedStatement prepstate =connection.prepareStatement
                                ("INSERT INTO `test`.`trip` (`tripId`, `name`, `startDate`, `endDate`, `numOfTravelers`, `ratePerTraveler`) "
                                                + "VALUES (NULL, ?, ?, ?, ?, ?)");
                                prepstate.setString(1, tripName);
                                prepstate.setString(2, startDate);
                                prepstate.setString(3, endDate);
                                prepstate.setInt(4, Integer.parseInt(numOfTravelers));
                                prepstate.setDouble(5, Double.parseDouble(ratePerTraveler));
                                prepstate.execute();
                        } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        RequestDispatcher dispatcher = getServletContext()
                                        .getRequestDispatcher("/views/index.jsp");
                        dispatcher.forward(request, response);                        
                }
                //Delete a trip from database - WORKING!
                else if (str.equals("/deleteTrip")){
                                String TripNameToDelete= request.getParameter("tripNameToDelete");
                                PreparedStatement prepstate = null;
                                try {
                                        prepstate = connection.prepareStatement
                                        ("DELETE FROM `trip` WHERE name=?");
                                } catch (SQLException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                }
                                try {
                                        prepstate.setString(1, TripNameToDelete);
                                } catch (SQLException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                                
                                try {
                                        prepstate.execute();
                                } catch (SQLException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                        
                        RequestDispatcher dispatcher = getServletContext()
                                        .getRequestDispatcher("/views/index.jsp");
                        dispatcher.forward(request, response);                        
                }
                //WORKING!
                else if (str.equals("/updateTripPreview")){
                        //Select in database the trip with the name passed to the controller
                        //then pass the trip details to jsp preview form
                        String tripName = null;
                        String startDate= null;
                        String endDate= null;
                        double ratePerTraveler = 0;
                        int numOfTravelers = 0;
                        int id=0;
                        String TripNameToUpdate= request.getParameter("tripNameToUpdate");
                        PreparedStatement prepstate = null;
                        
                        try {
                                prepstate = connection.prepareStatement
                                ("SELECT * FROM `trip` WHERE name=?");
                        } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                        }
                        try {
                                 prepstate.setString(1, TripNameToUpdate);
                        } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        
                        try {
                                ResultSet rs = prepstate.executeQuery();
                                while (rs.next())
                                {
                                        id=        rs.getInt("tripId");
                                        tripName = rs.getString("name");
                                    startDate = rs.getString("startDate");
                                        endDate = rs.getString("endDate");
                                        ratePerTraveler = rs.getDouble("ratePerTraveler");
                                        numOfTravelers = rs.getInt("numOfTravelers");        
                                }
                                request.setAttribute("id", id);
                                request.setAttribute("tripName", tripName);
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
                //WORKING!
                else if (str.equals("/updateAfterPreview")){
                        
                        try {
                                String id = request.getParameter("id");
                                String tripName= request.getParameter("tripName");
                                String startDate= request.getParameter("startDate");
                                String endDate= request.getParameter("endDate");
                                String ratePerTraveler= request.getParameter("ratePerTraveler");
                                String numOfTravelers= request.getParameter("numOfTravelers");
                                PreparedStatement prepstate =connection.prepareStatement
                                ("UPDATE `test`.`trip` SET name=? , startDate=? , endDate=? , numOfTravelers=? , ratePerTraveler=? WHERE tripId=?");
                                prepstate.setString(1, tripName);
                                prepstate.setString(2, startDate);
                                prepstate.setString(3, endDate);
                                prepstate.setInt(4, Integer.parseInt(numOfTravelers));
                                prepstate.setDouble(5, Double.parseDouble(ratePerTraveler));
                                prepstate.setInt(6, Integer.parseInt(id));
                                prepstate.executeUpdate();
                        } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                        RequestDispatcher dispatcher = getServletContext()
                                        .getRequestDispatcher("/views/index.jsp");
                        dispatcher.forward(request, response);                        
                }

                else if (str.equals("/updateInstructorPreview")){
                        
                        
                        
                        RequestDispatcher dispatcher = getServletContext()
                                        .getRequestDispatcher("/views/index.jsp");
                        dispatcher.forward(request, response);        
                }
                else if (str.equals("/updateSitePreview")){
                        
                        
                        
                        RequestDispatcher dispatcher = getServletContext()
                                        .getRequestDispatcher("/views/index.jsp");
                        dispatcher.forward(request, response);        
                }
                //WORKING!
                //A procedure that print all trips that cost less then
                //the price that the user chose.
                else if (str.equals("/procedureExample")){
                        String tripPrice = request.getParameter("tripPrice");
                        float price = Float.parseFloat(tripPrice);
                        CallableStatement cs;
                        ResultSet rs = null;
                        try {
                                cs = connection.prepareCall("CALL getTripsCheaperThen(?)");
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
                
                else if(str.equals("/dropAll")){
    				Statement statement;
					try {
						statement = connection.createStatement();
					
    				statement.execute("DROP TABLE trip");
    				statement.execute("DROP TABLE traveler");
    				statement.execute("DROP TABLE site");
    				statement.execute("DROP TABLE manager");
    				statement.execute("DROP TABLE instructor");
    						System.out.println("drop all completed.");
    				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
                
                else{
                        RequestDispatcher dispatcher = getServletContext()
                                        .getRequestDispatcher("/views/index.jsp");
                        dispatcher.forward(request, response);        
                }
                                
        }
}
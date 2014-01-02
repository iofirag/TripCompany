package il.ac.shenkar.TripCompany;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CouponsPlatformController
 */
@WebServlet("/controller/*")
public class Controller extends HttpServlet {
	
	// Create db Singleton
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String str = request.getPathInfo();
		
			DAO instance = DAO.getInstance();
			//instance.createTables();

			
		// Home-page - working!
		if (str.equals("/index")){
			//request.setAttribute("timestamp", new java.util.Date());
			System.out.print("1111111111");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/index.jsp");
			dispatcher.forward(request, response);			
		}
		else{
			System.out.print("22222222222");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/index.jsp");
			dispatcher.forward(request, response);	
		}
				
	}
}
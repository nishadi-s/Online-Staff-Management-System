package leaving_Emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 //Servlet implementation class leavingServlet
 

@WebServlet("/leavingServlet")
public class leavingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve user ID and email from the request parameters
		String userid= request.getParameter("uid");
		String email= request.getParameter("email");
		
		try {
			 // Call the validate method from HistoryDBUtil to check if there is a leaving history for the user
			List<Leaving_History> l2= HistoryDBUtil.validate(userid, email);
			
			// Set the leaving history details as a request attribute
	        request.setAttribute("history_details", l2);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
		// Forward the request to showleaving.jsp for displaying the leaving history
		RequestDispatcher dis = request.getRequestDispatcher("showleaving.jsp");
		dis.forward(request,response);
	}
		
	}



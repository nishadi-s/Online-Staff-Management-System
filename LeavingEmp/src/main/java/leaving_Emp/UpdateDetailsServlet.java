package leaving_Emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateDetailsServlet")
public class UpdateDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve form data from request parameters
		String first_name=request.getParameter("fname");
		String last_name=request.getParameter("lname");
		String emp_id=request.getParameter("id");
		String emaile=request.getParameter("eemail");
		String reason=request.getParameter("ereason");
		
		boolean isTrue;
		
		// Call updateLeave method from HistoryDBUtil to update leaving history
		isTrue = HistoryDBUtil.updateLeave(first_name, last_name, emp_id, emaile, reason);
		
		if (isTrue == true)
		{  // If update is successful, retrieve updated leaving details and forward to showleaving.jsp
			List <Leaving_History> leavingDetails = HistoryDBUtil.getEmpHistory(emp_id);
		    request.setAttribute("history_details",leavingDetails);
		    
			RequestDispatcher dis =request.getRequestDispatcher("showleaving.jsp");
			dis.forward(request, response);
		}
		
		else
		{   // If update is not successful, retrieve leaving details and forward to showleaving.jsp
			List <Leaving_History> leavingDetails = HistoryDBUtil.getEmpHistory(emp_id);
	        request.setAttribute("history_details",leavingDetails);
	        
			RequestDispatcher dis2 =request.getRequestDispatcher("showleaving.jsp");
			dis2.forward(request, response);
		}
	}

}

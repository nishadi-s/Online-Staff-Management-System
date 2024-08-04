package leaving_Emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LeavingInsertServlet")
public class LeavingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve form data from request parameters
		String first_name=request.getParameter("FirstName");
		String last_name=request.getParameter("LastName");
		String emp_id=request.getParameter("IdValidation");
		String emaile=request.getParameter("EmailValidation");
		String reason=request.getParameter("reason");
		
		boolean isTrue;
		
		// Call insertHistory method from HistoryDBUtil to add leaving history to the database
		isTrue=HistoryDBUtil.insertHistory(first_name, last_name, emp_id, emaile, reason);
		
		if (isTrue == true)
		{
			 // If insertion is successful, forward the request to success.jsp
			RequestDispatcher dis =request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}
		
		else
		{
			 // If insertion is not successful, forward the request to unsuccess.jsp
			RequestDispatcher dis2 =request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}

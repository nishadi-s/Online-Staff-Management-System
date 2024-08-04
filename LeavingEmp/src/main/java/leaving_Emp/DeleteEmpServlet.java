package leaving_Emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmpServlet
 */
@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the employee ID from the request parameter
		String emp_id=request.getParameter("id");
		boolean isTrue;
		
		 // Call the deleteEmp method from HistoryDBUtil to attempt to delete the employee record
		isTrue = HistoryDBUtil.deleteEmp(emp_id);
		
		if (isTrue == true)
		{
			// If deletion is successful, forward the request to LeavingInsert.jsp
			RequestDispatcher dis =request.getRequestDispatcher("LeavingInsert.jsp");
			dis.forward(request, response);
		}
		
		else
		{
			// If deletion is not successful, retrieve the leaving history for display
			List <Leaving_History> deleteDetails = HistoryDBUtil.getEmpHistory(emp_id);
			 request.setAttribute("delete_details",deleteDetails);
			 
			   // Forward the request to showleaving.jsp
			RequestDispatcher dis =request.getRequestDispatcher("showleaving.jsp");
			dis.forward(request, response);
		}
	}

}

package leaving_Emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HistoryDBUtil {
    private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static List <Leaving_History> validate (String userId, String u_email1)
	{
		// Validate user against the database
		ArrayList<Leaving_History> leave = new ArrayList<>();
		
		
		//validate
		
		try {
		    con = DBConnect.getConnection();
		    stmt = con.createStatement();
			String sql = "select * from emp_leave where emp_id='"+ userId+"' and email='"+u_email1+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next())
			{
				String first_name= rs.getString(1);
				String last_name= rs.getString(2);
				String emp_id= rs.getString(3);
				String email= rs.getString(4);
				String reason= rs.getString(5);
				
				Leaving_History l1 = new Leaving_History(first_name,last_name,emp_id,email,reason);
				leave.add (l1);
			}
			

			
		} catch (Exception e)
		{
			e.printStackTrace(); // print the error 
		}
		
		
		
		return leave;
		
	}
	
	 // Insert a leaving history record into the database
	public static boolean insertHistory(String firstName,String lastName,String empID,String email,String reason)
	{
		
	boolean isSuccess= false;
	
	
	try {
		con = DBConnect.getConnection();
	    stmt = con.createStatement();
		String sql="insert into emp_leave values ('"+firstName+"','"+lastName+"','"+empID+"','"+email+"','"+reason+"')";
		int rs=stmt.executeUpdate(sql);
		
		if (rs>0)
		{
			isSuccess= true;
		}
		
		else
		{
			isSuccess= false;
		}
	}
	
	catch(Exception e)
	{
		e.printStackTrace(); // print the error 
	}
	
	return isSuccess;
		
	}
	
	
	 // Update a leaving history record in the database
	public static boolean updateLeave(String firstName,String lastName,String empID,String email,String reason)
	{
		try {
			con = DBConnect.getConnection();
		    stmt = con.createStatement();
		    String sql="update  emp_leave set first_name='"+firstName+"',last_name='"+lastName+"',email='"+email+"',reason='"+reason+"'"
		    		+ "where emp_id='"+empID+"'";
		    
		    int rs=stmt.executeUpdate(sql);
			
			if (rs>0)
			{
				isSuccess= true;
			}
			
			else
			{
				isSuccess= false;
			}
		    
		}
		catch (Exception e)
		{
			e.printStackTrace(); // print the error 
		}
		
		
		return  isSuccess;
	}
	

	 // Get leaving history for a specific employee
	public static List <Leaving_History> getEmpHistory(String id)
	{   
		int convertedID=Integer.parseInt(id);
		
		ArrayList<Leaving_History> lh= new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
		    stmt = con.createStatement();
		    String sql= "select * from emp_leave where emp_id='"+convertedID+"'";
		     rs=stmt.executeQuery(sql);
		     
		     while(rs.next())
		     {
		    	 
		    	    String first_name= rs.getString(1);
					String last_name= rs.getString(2);
					String emp_id= rs.getString(3);
					String email= rs.getString(4);
					String reason= rs.getString(5);
					
					Leaving_History l = new Leaving_History(first_name,last_name,emp_id,email,reason);
					lh.add(l);
					
		     }

		}
		catch (Exception e)
		{
			e.printStackTrace(); // print the error 
		}
		return lh;
	}
	
	
	 // Delete a leaving history record from the database
	public static boolean deleteEmp(String id)
	{
		int convtID=Integer.parseInt(id);
		
		try {
			con = DBConnect.getConnection();
		    stmt = con.createStatement();
		    String sql = "delete from emp_leave where emp_id='"+convtID+"'";
		    int rs=stmt.executeUpdate(sql);
		  
		    if (rs>0)
			{
				isSuccess= true;
			}
			
			else
			{
				isSuccess= false;
			}
		    
		}
		
		catch (Exception e)
		{
			e.printStackTrace(); // print the error 
		}
		
		
		return  isSuccess;
	}
}

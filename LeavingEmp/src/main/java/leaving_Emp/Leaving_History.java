package leaving_Emp;


//implementing an interface
public class Leaving_History  implements LeaveRecord  {

	private String first_name;
	private String last_name;
	private String emp_id;
	private String email;
	private String reason;
	
	
	//overloaded constructor
	public Leaving_History(String first_name, String last_name, String emp_id2, String email, String reason) {

		this.first_name = first_name;
		this.last_name = last_name;
		this.emp_id = emp_id2;
		this.email = email;
		this.reason = reason;
	}


	 @Override
	public String getFirst_name() {
		return first_name;
	}


	 @Override
	public String getLast_name() {
		return last_name;
	}


	 @Override
	public String getEmp_id() {
		return emp_id;
	}


	 @Override
	public String getEmail() {
		return email;
	}


	 @Override
	public String getReason() {
		return reason;
	}


	
	
	
}

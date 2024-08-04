<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Details</title>
<link rel="stylesheet" href="deleteEmp.css"> 
</head>
<body>

<%
String f_name=request.getParameter("fname");
String l_name=request.getParameter("lname");
String u_id=request.getParameter("id");
String e_email=request.getParameter("eemail");
String e_reason=request.getParameter("ereason");
%>

<div class="header">
<h1>  Delete Leaving Form Details</h1>
</div>

<form action="delete" method= "post">
<table>
<tr>
<td>Employee First Name</td>
<td> <input type="text" class="form-label"class="form-control" name="fname" value="<%= f_name %>"readonly> </td>
</tr>

<tr>
<td>Employee Last Name</td>
<td> <input type="text" class="form-label"class="form-control" name="lname" value="<%= l_name %>"readonly> </td>
</tr>

<tr>
<td>Employee ID </td>
<td><input type="number" class="form-label" class="form-control"  name="id" value="<%= u_id %>"readonly></td>
 </tr>
 
 <tr>
<td>Employee Email </td>
<td><input type="email"  class="form-label" class="form-control" name="eemail" value="<%= e_email %>"readonly> </td>
</tr>

<tr>
<td>Employee Reason</td>
<td> <input type="text" class="form-label" class="form-control" name="ereason" value="<%= e_reason %>"readonly> </td>
</tr>
</table>
<input type="submit" class="btn-primary"  name="submit" value="Delete Details"> <br>

</form>

</body>
</html>
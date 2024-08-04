<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update details</title>
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
<h1>  Update Leaving Form Details</h1>
</div>

<form action="update" method= "post">
<table>
<tr>
<td>Employee First Name</td>
<td> <input type="text" name="fname" value="<%= f_name %>"> </td>
</tr>

<tr>
<td>Employee Last Name</td>
<td> <input type="text" name="lname" value="<%= l_name %>"> </td>
</tr>

<tr>
<td>Employee ID </td>
<td><input type="number" name="id" value="<%= u_id %>"readonly></td>
 </tr>
 
 <tr>
<td>Employee Email </td>
<td><input type="email" name="eemail" value="<%= e_email %>"> </td>
</tr>

<tr>
<td>Employee Reason</td>
<td> <input type="text" name="ereason" value="<%= e_reason %>"> </td>
</tr>
</table>
<input type="submit" name="submit" value="Edit Details"> <br>

</form>

</body>
</html>
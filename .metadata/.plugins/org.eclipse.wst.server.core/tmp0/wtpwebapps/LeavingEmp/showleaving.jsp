<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="deleteEmp.css"> 

</head>
<body>

<div class="header">
<h1> Show Leaving Form Details</h1>
</div>

<table>
<c:forEach var="emp" items ="${history_details}">

<c:set var="fname" value="${emp.first_name}"/>
<c:set var="lname" value=" ${emp.last_name}"/>
<c:set var="id" value="${emp.emp_id}"/>
<c:set var="eemail" value="${emp.email}"/>
<c:set var="ereason" value="${emp.reason}"/>


<tr>
<td>Employee First Name:</td>
 <td>${emp.first_name} </td>
</tr>

<tr>
<td>Employee Last Name:</td>
<td> ${emp.last_name} </td>
</tr>

<tr>
<td> Employee ID:</td>
<td> ${emp.emp_id} </td>
</tr>

<tr>
<td>Employee Email:</td>
<td>${emp.email} </td>
</tr>

<tr>
<td>Reason for the Leaving:</td>
<td> ${emp.reason} </td>
</tr>

</c:forEach>
</table>

<c:url value="UpdateDetails.jsp" var="empUpdate">
  <c:param name="fname" value="${fname}"/>
  <c:param name="lname" value="${lname}"/>
  <c:param name="id" value="${id}"/>
  <c:param name="eemail" value="${eemail}"/>
  <c:param name="ereason" value="${ereason}"/>
</c:url>

<a href="${empUpdate}">
<input type="button" name="update" value="Edit details">
</a>


<br>
<c:url value="deleteEmp.jsp" var="empDelete">
  <c:param name="fname" value="${fname}"/>
  <c:param name="lname" value="${lname}"/>
  <c:param name="id" value="${id}"/>
  <c:param name="eemail" value="${eemail}"/>
  <c:param name="ereason" value="${ereason}"/>
</c:url>

<a href="${empDelete}">
<input type="button" name="delete" value="Delete Details">
</a>


</body>
</html>

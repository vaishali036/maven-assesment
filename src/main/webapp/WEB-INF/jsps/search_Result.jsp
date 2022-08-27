<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Locations</title>
</head>
<body>
<h2>All Locations</h2>
<a href="show">Add Location</a>
<table>
	<tr>
		<th>Id</th>
		<th>name</th>
		<th>code</th>
		<th>type</th>
		<th>Delete</th>
		<th>Update</th>
	</tr>
	<c:forEach items="${locations }" var="location">
	<tr>
	<td>${location.id}</td>
	<td>${location.name}</td>
	<td>${location.codes}</td>
	<td>${location.type}</td>
	<td><a href="delete?id=${location.id}">Delete</a></td>
	<td><a href="update?id=${location.id}">Update</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
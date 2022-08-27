<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location |  update</title>
</head>
<body>
<h2>Location  |  update Location</h2>
<a href="listall">Get all locations</a>
<a href="show">Add Location</a>
<form action="updateData" method="post">
<pre>
Id<input type="text" name="id" value="${location.id}"/>
Name<input type="text" name="name" value="${location.name}"/>
code<input type="text" name="codes" value="${location.codes}"/>
type:
urban<input type="radio" name="type" value="urban"/>
rural<input type="radio" name="type" value="rural"/>
<input type="submit" value="update"/>
</pre>
</form>
${msg}
</body>
</html>
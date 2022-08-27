<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location |  create</title>
</head>
<body>
<h2>Location  |  Add new Location</h2>
<a href="listall">Get all locations</a>

<form action="saveLocation" method="post">
<pre>
Id<input type="text" name="id"/>
Name<input type="text" name="name"/>
code<input type="text" name="codes"/>
type:
urban<input type="radio" name="type" value="urban"/>
rural<input type="radio" name="type" value="rural"/>
<input type="submit" value="save"/>
</pre>
</form>
</body>
</html>

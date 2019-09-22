<%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body>
	<form action = "editItemServlet" method="post">
		Author: <input type ="text" name = "author" value="${itemToEdit.author}">
		Title: <input type = "text" name = "title" value= "${itemToEdit.title}">
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>
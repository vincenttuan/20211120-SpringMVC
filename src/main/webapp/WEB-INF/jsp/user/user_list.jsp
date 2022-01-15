<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="10" width="50%">
		<thead>
			<tr><th>Name</th><th>Age</th><th>Delete</th><th>Update</th></tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${ users }">
				<tr>
					<td>${ user.name }</td>
					<td>${ user.age }</td>
					<td><input type="button" value="Delete" onclick="window.location.href='./delete/${ user.name }';" /></td>
					<td><input type="button" value="Update" onclick="window.location.href='./get/${ user.name }';" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p />
	<input type="button" value="back" onclick="window.location.href='./input'" /> 
</body>
</html>
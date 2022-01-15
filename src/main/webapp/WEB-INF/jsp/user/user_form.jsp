<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
	<form method="post" action="/springmvc/mvc/user/${ action }">
		<fieldset>
			<legend>User Form</legend>
			User name: <input type="text" id="name" name="name" value="${ user.name }" ${ readonly } placeholder="Please input name" />
			<p />
			User age: <input type="number" id="age" name="age" value="${ user.age }" placeholder="Please input age" />
			<p />
			<input type="submit" value="${ action }" />
			<input type="reset" value="reset" />
			<input type="button" value="read" onclick="window.location.href='/springmvc/mvc/user/read';" />
		</fieldset>
	</form>
</body>
</html>
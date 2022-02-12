<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<title>Lotto Form</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/lotto/add">
		<fieldset>
			<legend>Lotto Form</legend>
			<input type="submit" value="電腦選號" class="pure-button pure-button-primary" />
		</fieldset>
	</form>
</body>
</html>
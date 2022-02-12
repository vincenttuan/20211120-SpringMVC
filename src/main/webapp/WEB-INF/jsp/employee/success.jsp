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
<title>Employee Success</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="get" action="${pageContext.request.contextPath}/mvc/employee/">
		<fieldset>
			<legend>Employee Success</legend>
			${ employee } <!-- attr.addFlashAttribute("employee", employee); -->
			<p />
			<input type="submit" value="回首頁" class="pure-button pure-button-primary" />
		</fieldset>
	</form>
	
</body>
</html>
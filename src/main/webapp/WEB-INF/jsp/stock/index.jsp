<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spform"
	uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<title>Stock Form</title>
<style type="text/css">
	.error {
		color: #FF0000
	}
</style>
</head>
<body style="padding: 20px">
	<spform:form modelAttribute="stock" class="pure-form" method="post"
		action="${pageContext.request.contextPath}/mvc/stock/">
		<fieldset>
			<legend>Stock Form</legend>
			股號:
			<spform:input path="symbol" />
			<spform:errors path="symbol" cssClass="error" />
			<p />
			價格:
			<spform:input path="price" />
			<spform:errors path="price" cssClass="error" />
			<p />
			數量:
			<spform:input path="amount" />
			<spform:errors path="amount" cssClass="error" />
			<p />
			<input type="submit" value="新增"
				class="pure-button pure-button-primary" />
			<p />	
			<spform:errors path="*" cssClass="error" />	
		</fieldset>
	</spform:form>
	<hr />
	${ stocks }
</body>
</html>
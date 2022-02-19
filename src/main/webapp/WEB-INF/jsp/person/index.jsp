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
<title>Person Form</title>
<style type="text/css">
	.error {
		color: #FF0000
	}
</style>
</head>
<body style="padding: 20px">
	<spform:form modelAttribute="person" class="pure-form" method="post"
		action="${pageContext.request.contextPath}/mvc/person/">
		<fieldset>
			<legend>Person Form</legend>
			姓名:
			<spform:input path="name" />
			<spform:errors path="name" cssClass="error" />
			<p />
			年齡:
			<spform:input path="age" />
			<spform:errors path="age" cssClass="error" />
			<p />
			會員:
			<spform:radiobutton path="member" value="true" /> 會員
			<spform:radiobutton path="member" value="false" /> 非會員
			<spform:errors path="member" cssClass="error" />
			<p />
			生日:
			<spform:input type="date" path="birth" />
			<spform:errors path="date" cssClass="error" />
			<p />
			<input type="submit" value="新增"
				class="pure-button pure-button-primary" />
			<p />	
			<spform:errors path="*" cssClass="error" />	
		</fieldset>
	</spform:form>
</body>
</html>
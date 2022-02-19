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
<title>Employee Form</title>
<style type="text/css">
	.error {
		color: #FF0000
	}
</style>
</head>
<body style="padding: 20px">
	<table>
		<tr>
			<!-- Employee From -->
			<td valign="top">
				<%@include file="employee_form.jspf" %>
			</td>
			<!-- Salary Column Chart -->
			<td valign="top"></td>
			<!-- Salary Pie Chart -->
			<td valign="top"></td>
			<!-- Jobs Line Chart -->
			<td valign="top"></td>
		</tr>
		<tr>
			<!-- Employee List -->
			<td valign="top" colspan="4">
				${ employees }			
			</td>
		</tr>
	</table>
	
	
</body>
</html>
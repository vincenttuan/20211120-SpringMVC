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
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
		salaryChart();
		jobsChart();
	}
	
	function salaryChart() {
        var data = google.visualization.arrayToDataTable([
          ['ename', 'salary'],
          <c:forEach var="emp" items="${ employees }">
          	['${ emp.ename }', ${ emp.salary }],
          </c:forEach>
        ]);

        var options = {
          title: 'Salary'
        };
        // 長條圖
        var columnChart = new google.visualization.ColumnChart(document.getElementById('column_chart'));
        columnChart.draw(data, options);
     	// 圓餅圖
        var pieChart = new google.visualization.PieChart(document.getElementById('pie_chart'));
        pieChart.draw(data, options);
	}
	
	function jobsChart() {
		var data = google.visualization.arrayToDataTable([
	          ['ename', 'salary'],
	          <c:forEach var="emp" items="${ employees }">
	       		// 判斷工作數量是否  > 0
	        	<c:if test="${ fn:length(emp.jobs) > 0 }">
	        		// 判斷第一筆工作的 jid 不可以是 null
			        <c:if test="${ emp.jobs[0].jid != null }">
			        	['${ emp.ename }', ${ fn:length(emp.jobs) }],
			        </c:if>
			        <c:if test="${ emp.jobs[0].jid == null }">
			        	['${ emp.ename }', 0],
			        </c:if>	
		        </c:if>
	          </c:forEach>
	        ]);

	        var options = {
	          title: 'Salary'
	        };
	        // 折線圖
	        var lineChart = new google.visualization.LineChart(document.getElementById('line_chart'));
	        lineChart.draw(data, options);
	}
</script>
</head>
<body style="padding: 20px">
	<table>
		<tr>
			<!-- Employee From -->
			<td valign="top"><%@include file="employee_form.jspf"%>
			</td>
			<!-- Salary Column Chart -->
			<td valign="top">
				<div id="column_chart" style="width: 400px; height: 250px;"></div>
			</td>
			<!-- Salary Pie Chart -->
			<td valign="top">
				<div id="pie_chart" style="width: 400px; height: 250px;"></div>
			</td>
			<!-- Jobs Line Chart -->
			<td valign="top">
				<div id="line_chart" style="width: 400px; height: 250px;"></div>
			</td>
		</tr>
		<tr>
			<!-- Employee List -->
			<td valign="top" colspan="4">${ employees }</td>
		</tr>
	</table>


</body>
</html>
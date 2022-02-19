<!-- 小技巧：讓 jsp 可以支援所有 HTTP 方法 -->
<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet"
		href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<meta charset="UTF-8">
	<title>Job Form</title>
	<style type="text/css">
		.error {
			color: #FF0000;
		}
	</style>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
	google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
	    function drawChart() {
	    	var data = google.visualization.arrayToDataTable([
		        ['ename', 'job_count'],
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
				title: 'Jobs'
			};
		
			var chart = new google.visualization.BarChart(document.getElementById('bar_chart'));
			chart.draw(data, options);	    	
	    }
	</script>
</head>
<body style="padding: 15px;">
	<table >
		<tr>
			<!-- Job Form -->
			<td valign="top">
				<spform:form class="pure-form" 
				 method="post" 
				 modelAttribute="job" 
				 action="${ pageContext.request.contextPath }/mvc/lab/job/">
					<fieldset>
						<legend>
							<a href="${ pageContext.request.contextPath }/mvc/lab/emp/">Employee form</a> | Job form
						</legend>
						<input type="hidden" name="_method" id="_method" value="${ _method }"/>
						編號：<spform:input path="jid" readonly="true" /><p />
						名稱：<spform:input path="jname" /><br />
							 <spform:errors path="jname" cssClass="error" /><p />
						員工：<spform:select path="eid"
								items="${ employees }"
								itemLabel="ename"
								itemValue="eid"
							 />
						<p />
						<input type="submit" value="新增"
							class="pure-button pure-button-primary"
							${ _method eq 'PUT'?'disabled':'' } /> 
						<input type="submit"
							value="修改" class="pure-button pure-button-primary"
							${ _method eq 'POST'?'disabled':'' } />	
						<p />
						<spform:errors path="*" cssClass="error" />
					</fieldset>
				</spform:form>
			</td>
			<!-- Job List -->
			<td valign="top" colspan="2">
				<form class="pure-form">
					<fieldset>
						<legend>
							Job List | 
							<a href="${ pageContext.request.contextPath }/mvc/lab/job/page/-1">全部查詢</a> | 
							分頁查詢：
							<c:forEach var="num" begin="1" end="${ count/5 + 1 }">
								<a href="${ pageContext.request.contextPath }/mvc/lab/job/page/${ num }">${ num }</a>&nbsp;
							</c:forEach>
						</legend>
						<table class="pure-table pure-table-bordered" width="700px">
							<thead>
								<tr>
									<th rowspan="2" valign="middle" align="center">編號</th><th rowspan="2" valign="middle" align="center">名稱</th><th colspan="2" align="center">員工資料</th>
								</tr>
								<tr style="border-top: 1px solid lightgray;">
									<th align="center">員編</th><th align="center">姓名</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="job" items="${ jobs }">
									<tr>
										<td>
											<a href="./${ job.jid }" title="按我一下可以修改">
												${ job.jid }
											</a>
										</td>
										<td>${ job.jname }
										</td>
										<td>${ job.employee.eid }</td>
										<td>
											<a href="${ pageContext.request.contextPath }/mvc/lab/emp/${ job.employee.eid }" title="按我一下可以修改員工資料">
												${ job.employee.ename }
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</fieldset>	
				</form>
			</td>
			<!-- Job Bar Chart -->
			<td valign="top">
				<form class="pure-form">
					<fieldset>
						<legend>Job Bar Chart</legend>
						<div id="bar_chart" style="width: 400px; height: 250px"></div>
					</fieldset>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>

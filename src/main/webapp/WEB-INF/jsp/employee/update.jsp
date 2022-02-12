<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<title>Employee Update Form</title>

</head>
<body style="padding: 20px">
	<spform:form modelAttribute="employee" 
				class="pure-form" 
				method="post" 
				action="${pageContext.request.contextPath}/mvc/employee/${ index }">
		<fieldset>
			<legend>Employee Update Form</legend>
			<input type="hidden" name="_method" value="PUT" />
			姓名: <spform:input path="name" /><p />
			年齡: <spform:input path="age" /><p />
			薪資: <spform:input path="salary" /><p />
			生日: <spform:input type="date" path="birth" /><p />
			學歷: <spform:select path="education">
					<spform:option value="">請選擇</spform:option>
					<spform:option value="國中">國中(含)以下</spform:option>
					<spform:option value="高中">高中</spform:option>
					<spform:option value="大學">大學</spform:option>
					<spform:option value="研究所">研究所(含)以上</spform:option>
			     </spform:select> <p />
			性別: <spform:radiobutton path="sex" value="男"/>男性
				 <spform:radiobutton path="sex" value="女"/>女性<p />
			興趣: <spform:checkbox path="interest" value="爬山" />爬山  
				 <spform:checkbox path="interest" value="閱讀" />閱讀
				 <spform:checkbox path="interest" value="打球" />打球
				 <spform:checkbox path="interest" value="飛控" />飛控
				 <p />
			履歷: <spform:textarea path="resume" /><p />
			<input type="submit" value="修改" class="pure-button pure-button-primary" />
		</fieldset>
	</spform:form>
	<p />
	${ employees }
</body>
</html>
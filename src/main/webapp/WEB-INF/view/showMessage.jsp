<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<h2>${message}</h2>
	<br />
	<h2>${messageDetail}</h2>
	<br />
	<h2>${messageCheckBox}</h2>
	<br />
	<h2>${messageRadio}</h2>
	<br />
	<h2>${messageSex}</h2>
	<form:form modelAttribute="testForm"
		action="${pageContext.request.contextPath}/show">
		<form:input path="id" />
		<form:input path="name" />
		<table>
			<tr>
				<td><form:input path="details[0].seq" /></td>
				<td><form:input path="details[0].productName" /></td>
			</tr>
			<tr>
				<td><form:input path="details[1].seq" /></td>
				<td><form:input path="details[1].productName" /></td>
			</tr>
		</table>
		<br />
		<form:checkboxes path="employees" items="${checkEmployees}"
			delimiter="/" />
		<br />
		<br />
		<form:radiobuttons path="radio" items="${checkRadioEmployees}" />
		<form:radiobuttons path="sex" items="${sexoption}" itemValue="key"
			itemLabel="value" />
		<input type="submit">
	</form:form>
</body>
</html>
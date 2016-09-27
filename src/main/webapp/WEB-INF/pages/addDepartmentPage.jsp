<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Добавление департамента</title>
</head>
<body>
	<h1>Добавление нового департамента</h1>
	<c:url var="saveUrl"
		value="/dep/add?id=${departmentAttribute.store.id}" />
	<form:form modelAttribute="departmentAttribute" method="POST"
		action="${saveUrl}">
		<table>

			<tr>
				<td><form:label path="store.id"></form:label></td>
				<td style="display: none"><form:input path="store.id"
						disabled="true" /></td>
			</tr>

			<tr>
				<td><form:label path="nameDepartment">Отдел:</form:label></td>
				<td><form:input path="nameDepartment" /></td>
			</tr>

			<tr>
				<td><form:label path="post">Должность:</form:label></td>
				<td><form:input path="post" /></td>
			</tr>
			<tr>
				<td><form:label path="email">E-mail:</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">Телефон:</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>
		</table>

		<input type="submit" value="Save" />
	</form:form>


</body>
</html>
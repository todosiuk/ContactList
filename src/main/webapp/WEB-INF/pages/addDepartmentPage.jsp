<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Добавление департамента</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<h1>Добавление нового департамента</h1>
		<c:url var="saveUrl"
			value="/dep/add?id=${departmentAttribute.store.id}" />
		<form:form class="form-horizontal"
			modelAttribute="departmentAttribute" method="POST"
			action="${saveUrl}">
			<table>

				<tr>
					<td><form:label class="control-label" path="store.id"></form:label></td>
					<td style="display: none"><form:input path="store.id"
							disabled="true" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="nameDepartment">Отдел:</form:label></td>
					<td><form:input placeholder="Введите № отдела"
							path="nameDepartment" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="post">Должность:</form:label></td>
					<td><form:input placeholder="Введите должность" path="post" /></td>
				</tr>
				<tr>
					<td><form:label class="control-label" path="email">E-mail:</form:label></td>
					<td><form:input placeholder="Введите e-mail" path="email" /></td>
				</tr>
				<tr>
					<td><form:label class="control-label" path="phone">Телефон:</form:label></td>
					<td><form:input placeholder="Введите номер телефона "
							path="phone" /></td>
				</tr>
			</table>
			<br>
			<input value="Сохранить" input type="submit" class="btn btn-primary" />
		</form:form>

	</div>
</body>
</html>
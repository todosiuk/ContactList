<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Новый департамент</title>
</head>
<body>
	<h1>Добавить данные</h1>
	<form:form method="post" action="createdepartment">
		<table>
			<tr>
				<td>Маркет</td>
				<td><form:input path="store" /></td>
			</tr>
			<tr>
				<td>Отдел</td>
				<td><form:input path="nameDepartment" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Должность</td>
				<td><form:input path="post" /></td>
			</tr>
			<tr>
				<td>Телефон</td>
				<td><form:input path="phone" /></td>
			</tr>
			<td></td>
			<td><input type="submit" value="Сохранить" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
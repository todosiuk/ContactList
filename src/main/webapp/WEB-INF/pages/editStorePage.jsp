<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Редактирование магазина</title>
</head>
<body>
	<h1>Обновление магазина</h1>
	<c:url var="saveUrl" value="edit?id=${storeAttribute.id}" />
	<form:form modelAttribute="storeAttribute" method="POST"
		action="${saveUrl}">
		<table>
			<tr>
				<td><form:label path="id">Id:</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
			</tr>
			<tr>
				<td><form:label path="city">Город:</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
		</table>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>
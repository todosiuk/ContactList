<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Создание нового магазина</h1>
	<c:url var="saveUrl" value="/store/stores/add" />
	<form:form modelAttribute="storeAttribute" method="POST"
		action="${saveUrl}">
		<table>
			<tr>
				<td><form:label path="city">Город:</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
		</table>
		<input type="submit" value="save" />
	</form:form>
</body>
</html>
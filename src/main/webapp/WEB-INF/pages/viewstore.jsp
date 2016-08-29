<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Список магазинов</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Маркет</th>
		</tr>
		<c:forEach var="store" items="${list}">
			<tr>
				<td>${store.id }</td>
				<td><a href="viewdep">${store.city}</a></td>
				<td><a href="editstore/${store.id}">Обновить</a></td>
				<td><a href="deletestore/${store.id}">Удалить</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="storeform">Добавить магазин</a>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List</title>
</head>
<body>
	<div align="center">
		<h1>Contact List</h1>
		<table border="1">
			<th>Маркет</th>
			<th>Отдел</th>
			<th>e-mail</th>
			<th>Должность</th>
			<th>Телефон</th>
			<c:forEach var="dept" items="${Department}">
				<tr>

					<td>$(dept.nameDepartment)</td>
					<td>${dept.post}</td>
					<td>${dept.email}</td>
				</tr>
			</c:forEach>


		</table>
	</div>
</body>
</html>
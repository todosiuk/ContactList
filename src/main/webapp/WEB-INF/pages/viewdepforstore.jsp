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
	<h1>Список департаментов маркета</h1>
	<tr>
		<th>Отдел</th>
		<th>Должность</th>
		<th>Телефон</th>
		<th>E-mail</th>
	</tr>
	<c:forEach var="department" items=${departList }>
		<tr>
			<td>${department.name }</td>
			<td>${department.post }</td>
			<td>${department.phone }</td>
			<td>${department.email }</td>
		</tr>
	</c:forEach>
</body>
</html>
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
	<h1>Список контактов магазина</h1>

	<table border="2" width="70%" cellpadding="2">
		<tr>			
			<th>Отдел</th>
			<th>Должность</th>
			<th>E-mail</th>
			<th>Телефон</th>
		</tr>
		<c:forEach var="department" items="${depList}">
			<tr>
				</h1>
				<td>${department.nameDepartment}</td>
				<td>${department.post}</td>
				<td>${department.email}</td>
				<td>${department.phone}</td>

			</tr>
		</c:forEach>
		<a href = "/ContactList/index.jsp">На главную</a> 



	</table>



</body>
</html>
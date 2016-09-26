<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Магазины</h1>
	<c:url var="addUrl" value="/store/stores/add" />
	<h3>
		<a href="${addUrl}">Добавить магазин</a>
	</h3>
	<p>
	<table style="border: 1px solid; width: 500px; text-align: center">
		<thead style="background: #fcf">
			<tr>
				<th>Город</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stores}" var="store">
				<c:url var="addDepUrl" value="/dep/add?id=${store.id}" />
				<c:url var="editUrl" value="/store/stores/edit?id=${store.id}" />
				<c:url var="deleteUrl" value="/store/stores/delete?id=${store.id}" />
				<c:url var="getDep" value="/store/stores/record?id=${store.id}" />
				<tr>
					<td><a href="${getDep}"><c:out value="${store.city}" /></a></td>
					<td><a href="${editUrl}">Редактировать</a></td>
					<td><a href="${deleteUrl}">Удалить</a></td>
					<td><a href="${addDepUrl}">Добавить департамент</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${empty stores}">
There are currently no stores in the list. <a href="${addUrl}">Add</a> a store.
</c:if>
</body>
</html>
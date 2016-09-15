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
	<table style="border: 1px solid; width: 500px; text-align: center">
		<thead style="background: #fcf">
			<tr>
				<th>Город</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stores}" var="store">
				<c:url var="editUrl" value="/store/stores/edit?id=${store.id}" />
				<c:url var="deleteUrl" value="/store/stores/delete?id=${store.id}" />
				<tr>
					<td><c:out value="${store.city}" /></td>
					<td><a href="${editUrl}">Edit</a></td>
					<td><a href="${deleteUrl}">Delete</a></td>
					<td><a href="${addUrl}">Add</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${empty stores}">
There are currently no stores in the list. <a href="${addUrl}">Add</a> a store.
</c:if>
</body>
</html>
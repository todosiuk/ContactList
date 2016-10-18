<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<title>Магазины</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<h1>Магазины</h1>
		<c:url var="addUrl" value="/store/stores/add" />
		<h3>
			<a href="${addUrl}" input type="submit" class="btn btn-primary" />Добавить
			магазин</a>
		</h3>
		<p>
		<table style="border: 1px solid; width: 500px; text-align: center"
			class="table">
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
						<td><h4>
								<a href="${getDep}"><c:out value="${store.city}" /></a>
							</h4></td>
						<td><a href="${editUrl}" input type="submit"
							class="btn btn-primary btn-xs">Редактировать</a></td>
						<td><a href="${deleteUrl}" input type="submit"
							class="btn btn-primary btn-xs">Удалить</a></td>
						<td><a href="${addDepUrl}" input type="submit"
							class="btn btn-primary btn-xs">Добавить департамент</a></td>
					</tr>
				</c:forEach>
			</tbody>


		</table>
		<c:if test="${empty stores}">
На данный момент в списке нет магазинов. <a href="${addUrl}">Добавить</a> магазин.
</c:if>
	</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Департаменты</title>
</head>
<body>
	<h1>Список департаментов магазина</h1>
	<table style="border: 1px solid; width: 100%; text-align: center">
		<thead style="background: #d3dce3">
			<tr>
				<th style="display: none"></th>
				<th>Отдел</th>
				<th>Должность</th>
				<th>Телефон</th>
				<th>E-mail</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody style="background: #ccc">
			<c:forEach items="${stores}" var="store">
				<c:forEach items="${store.depList}" var="depsList">
					<c:url var="editUrl"
						value="/dep/edit?storeId=${depsList.store.id}&depId=${depsList.id}" />
					<c:url var="deleteUrl" value="/dep/delete?id=${depsList.id}" />
					<tr>

						<td><c:out value="${depsList.nameDepartment}" /></td>
						<td><c:out value="${depsList.post}" /></td>
						<td><c:out value="${depsList.phone}" /></td>
						<td><c:out value="${depsList.email}" /></td>
						<td><a href="${editUrl}">Редактировать</a></td>
						<td><a href="${deleteUrl}">Удалить</a></td>
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
	<c:url var="mainUrl" value="/store/stores" />
	<p>
		<a href="${mainUrl}">Список магазинов</a>
	</p>
</body>
</html>
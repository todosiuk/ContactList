<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Магазин удален</title>
</head>
<body>
	<div class="container-fluid" align="center">

		<h1>
			<p>Вы удалили магазин ${city}</p>
		</h1>

		<c:url var="mainUrl" value="/store/stores" />
		<p>
			<a href="${mainUrl}" input type="submit" class="btn btn-primary">Главный
				Список</a>
		</p>
	</div>
</body>
</html>
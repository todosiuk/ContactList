<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Департамент удален</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<h1>Департамент удален</h1>
		<c:url var="mainUrl" value="/store/stores" />
		<p>
			<a href="${mainUrl}" input type="submit" class="btn btn-primary" />Назад</a>
		</p>
	</div>
</body>
</html>
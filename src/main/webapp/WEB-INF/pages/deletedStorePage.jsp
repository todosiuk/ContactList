<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Магазины</h1>
	<p>
		Вы удалили магазин ${city} 
		<%=new java.util.Date()%></p>

	<c:url var="mainUrl" value="/store/stores" />
	<p>
		Назад на<a href="${mainUrl}">Главный Список</a>
	</p>

</body>
</html>
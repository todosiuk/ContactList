<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Магазин добавлен</title>
</head>
<body>
	<h1>Магазины</h1>
	<p>
		Вы добавили новый магазин
	</p>
	<c:url var="mainUrl" value="/store/stores" />
	<p>
		Назад на <a href="${mainUrl}">Главный Список</a>
	</p>
</body>
</html>
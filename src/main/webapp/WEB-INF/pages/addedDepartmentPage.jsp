<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Департамент добавлен</title>
</head>
<body>
	<p>
	<h1>Вы добавили новый департамент</h1>
	</p>
	<c:url var="mainUrl" value="/store/stores" />
	<p>
		<a href="${mainUrl}">Назад</a>
	</p>

</body>
</html>
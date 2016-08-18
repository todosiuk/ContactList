
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Новый магазин</title>
</head>
<body>
	<form:form method="post" action="createStore">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<th bgcolor="#CCCCFF" colspan=2><font size=5>Новый
						магазин</font></th>
				<tr bgcolor="#c8d8f8">
					<td valign=top>Город* <form:input path="city"/>
						size=15 maxlenght=30></td>
				</tr>
				<tr bgcolor="#c8d8f8">
					<td align=center colspan=2><input type="submit"
						value="Добавить"></td>
				</tr>
			</table>
		</center>
	</form:form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department List</title>
</head>
<body>
	<div align="center">
		<h1>Department List</h1>
		<table border="1">
			<th>No</th>
			<th>Dept No</th>
			<th>Dept Name</th>
			<th>Location</th>

			<c:forEach var="dept" items="${departments}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${dept.deptNo}</td>
					<td>${dept.deptName}</td>
					<td>${dept.location}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
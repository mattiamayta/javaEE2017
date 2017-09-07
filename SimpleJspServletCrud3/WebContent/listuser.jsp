<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>
<body>

	<table border=1>
		<thead>
			<tr>
				<th>User Name</th>
				<th>Email</th>
				<th>Registration Date</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
			<form action="userModify" method="post">
			<input type="hidden" name="userId" value="<c:out value="${user.uname}" />" />
				<tr>
					<td><c:out value="${user.uname}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${user.registeredon}" /></td>
					<td><input type="submit" name="action" value="Update" /></td>
					<td><input type="submit" name="action" value="Delete" /></td>
				</tr>
				</form>
			</c:forEach>
		</tbody>
	</table>
	<form action="userModify" method="post">
	<p>
		<input type="submit" name="action" value="Add new User" />
	</p>
	</form>
</body>
</html>
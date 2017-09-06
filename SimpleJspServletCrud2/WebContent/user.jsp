<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user</title>
</head>
<body>
	<form method="POST" action='UserController' name="frmAddUser">
		<%
			String action = request.getParameter("action");
			System.out.println(action);
		%>
		<%
			if (action.equalsIgnoreCase("update")) {
		%>
		User Name : <input type="text" name="uname"
			value="<c:out value="${user.uname}" />" readonly="readonly" /> (You
		Can't Change this)<br />
		<%
			} else {
		%>
		User Name : <input type="text" name="uname"
			value="<c:out value="${user.uname}" />" /> <br />
		<%
			}
		%>
		Password : <input type="password" name="pass"
			value="<c:out value="${user.password}" />" /> <br /> Email : <input
			type="text" name="email" value="<c:out value="${user.email}" />" />
		<br />

		<%
			if (action.equalsIgnoreCase("update")) {
		%>
		Registration : <input type="text" name="dob"
			value="<fmt:formatDate pattern="dd/mm/yyyy" value="${user.registeredon}" />"
			readonly="readonly" />(You Can't Change this) <br />
		<%
			} else {
		%>
		Registration : <input type="date" name="dob" value="${user.registeredon}" /> (dd/mm/yyyy)
		<br />
		<%
			}
		%>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
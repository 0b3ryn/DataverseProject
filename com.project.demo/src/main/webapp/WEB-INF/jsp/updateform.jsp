<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <div id="wrapper">
		<div id="header">
			<h2>CRM - User Registration</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action='updateUser' modelAttribute='user' method='POST'>

			<!-- need to associate this data with user id -->
			<form:hidden path='id' />
			<form:hidden path='password' />

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path='firstName' /></td>
						<td><span style="color:red"><c:out value='${errorFirstName}' /><span><td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path='lastName' /></td>
						<td><span style="color:red"><c:out value='${errorLastName}' /><span><td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path='email' /></td>
						<td><span style="color:red"><c:out value='${errorEmail}' /><span><td>
					</tr>

					<tr>
                        <td><label>Company:</label></td>
                        <td><form:input path='company' /></td>
                    </tr>





					<tr>
						<td><label></label></td>
						<td><input type='submit' value='Save' class='save' /></td>
					</tr>


				</tbody>
			</table>
			</form:form>

			<a href="<c:url value='/users/login' />">Login</a>

</body>
</html>
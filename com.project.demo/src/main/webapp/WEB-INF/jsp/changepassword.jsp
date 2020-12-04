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

		<form:form action='updatePassword' modelAttribute='user' method='POST'>

			<!-- need to associate this data with user id -->
			<form:hidden path='id' />
			<form:hidden path='lastName' />
			<form:hidden path='firstName' />
			<form:hidden path='company' />
			<form:hidden path='email' />

			<table>
				<tbody>
					<tr>
                     <td><label>Password:</label></td>
                    <td><form:input path='password' /></td>
                    <td><span style="color:red"><c:out value='${errorPassword}'/></span><td>
                </tr>

                <tr>
                    <td><label>Confirm Password:</label></td>
                    <td><form:input path='confirmPassword' /></td>

                </tr>



					<tr>
						<td><label></label></td>
						<td><input type='submit' value='Save' class='save' /></td>
					</tr>


				</tbody>
			</table>
			</form:form>

			<a href="<c:url value='/users/login' />">Login</a>
			<a href="<c:url value='/users/home' />">Return home</a>

</body>
</html>
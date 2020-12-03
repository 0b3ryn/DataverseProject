<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

		<form:form action='saveUser' modelAttribute='user' method='POST'>

			<!-- need to associate this data with user id -->
			<form:hidden path='id' />

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path='firstName' /></td>
						<td><form:errors path="firstName" cssClass="error" /><td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path='lastName' /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path='email' /></td>
					</tr>

					<tr>
                        <td><label>Company:</label></td>
                        <td><form:input path='company' /></td>
                    </tr>

                    <tr>
                        <td><label>Password:</label></td>
                        <td><form:input path='password' /></td>
                    </tr>

					<tr>
						<td><label></label></td>
						<td><input type='submit' value='Save' class='save' /></td>
					</tr>


				</tbody>
			</table>
			</form:form>

</body>
</html>
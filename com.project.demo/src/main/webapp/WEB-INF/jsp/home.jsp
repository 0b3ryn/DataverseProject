<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <div id="wrapper">
		<div id="header">
			<h2>Welcome</h2>
		</div>
	</div>
	<table>
    				<tbody>
    					<tr>
    						<td><label>First name:</label></td>
    						<td><span><c:out value='${user.getFirstName()}' /></td>
    					</tr>

    					<tr>
    						<td><label>Last name:</label></td>
    						<td><c:out value='${user.getLastName()}' /></td>
    					</tr>

    					<tr>
    						<td><label>Email:</label></td>
    						<td><c:out value='${user.getEmail()}' /></td>
    					</tr>

    					<tr>
                            <td><label>Company:</label></td>
                            <td><c:out value='${user.getCompany()}' /></td>
                        </tr>

    				</tbody>
    			</table>
    			<br><br>

    			<c:url var="updateLink" value="/users/updateForm">
                    <c:param name="user" value="${user.getEmail()}" />
                </c:url>
               <a href="${updateLink}">Update</a>
               <c:url var="updatePassword" value="/users/updatePasswordForm">
                   <c:param name="user" value="${user.getEmail()}" />
               </c:url>
               <a href="${updatePassword}">Change Password</a>


	<br><br>
    <a href="<c:url value='/logout' />">Logout</a>


</body>
</html>
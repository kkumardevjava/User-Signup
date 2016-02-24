<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>User Login</title>
</head>
<style>
    .error {
        color: red; font-weight: bold;
    }
     .field {
        color: Teal; font-weight: bold;
    }
</style>
<body>

<h3 class="field">login page</h3>
 

<form:form method="POST" action="/signup/checkUserName" modelAttribute="userForm">
<form:errors path="*" cssClass="error" element="div" />
   <table>
    <tr> 
        <td> <form:label path="dob">User Name</form:label>  <strong  class="error">*</strong></td>
        <td><form:input path="userName" /> </td>
         <td> <form:errors path="userName" cssClass="error"/></td>  
    </tr> 
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
 
</body>
</html>
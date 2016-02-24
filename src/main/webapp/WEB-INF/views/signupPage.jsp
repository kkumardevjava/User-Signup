<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<style>
	.header {
        color: Olive; font-weight: bold;
    }
    .error {
        color: red; font-weight: bold;
    }
     .field {
        color: Teal; font-weight: bold;
    }
</style>
<body>

<h3 class="field">User signUp Form</h3>

<form:form method="POST" action="/signup/addUser" modelAttribute="userForm">
<form:errors path="*" cssClass="error" element="div" />
   <table>
    <tr> 
        <td> <form:label path="userName"    >User Name</form:label>  <strong  class="error">*</strong></td>
        <td><form:input path="userName" /> </td>
         <td> <form:errors path="userName" cssClass="error"/></td>  
    </tr>
    <tr>
        <td><form:label path="dob"   >Date of Birth</form:label><strong  class="error">*</strong> </td>
        <td><form:input   path="dob" placeholder="MM/dd/yyyy"  /> </td>
       <td> <form:errors path="dob" cssClass="error"/></td> 
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
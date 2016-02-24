<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Main</title>
</head>
<style>
	 
     .field {
        color: Teal; font-weight: bold;
    }
</style>
<body>
<h3 class="field">
	
	<spring:message code="mainPage.header" text="default text" />
</h3>   

<form:form  action="/signup/signupPage"  method="GET">
   <table> 
    <tr>
        <td colspan="2">
       <spring:message code="mainPage.newuser" text="default text" />    <input type="submit" value="SignUp"/>
        </td>
    </tr>
</table>  
</form:form> 
<c:choose>
    <c:when test="${sessionScope.signUpSuccess == 'true'}">
      <h4 class="field">  New User : " ${sessionScope.userName} "  signUp done Successfully, Now you can signIn </h4> 
    </c:when> 
</c:choose>

<form:form  action="/signup/signinPage"  method="GET">
   <table> 
    <tr>
        <td colspan="2">
        <spring:message code="mainPage.existinUser" text="default text" /> <input type="submit" value="SingIn"/>
        </td>
    </tr>
</table>  
</form:form>

</body>
</html>

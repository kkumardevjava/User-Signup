<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Spring MVC Form Handling</title>
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

<h3 class="field"> Security Question page</h3>
 
  
 <!-- 
 <form action="/signup/checkSecurityQuestion" method="POST">  
${sessionScope.randomQuestion} :<input type="text" name="randomQuestion"/><br/><br/>   
<input type="submit" value="Login"/>  
</form>   
 -->
 
<form:form method="POST" action="/signup/checkSecurityQuestion"  modelAttribute="securityQuestionsForm">
<form:errors path="*" cssClass="error" element="div" />
   <table>
    <tr> 
        <td>${sessionScope.randomQuestion} : <strong  class="error">*</strong></td>
        <td><form:input path="randomAnswer" /> </td>  
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
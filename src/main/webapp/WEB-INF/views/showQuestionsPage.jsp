<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" %>
<%@ page session="true" %>
<html>
<head>
	<title>Security Questions</title>
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
<h3 class="field">
Security Questions 
</h3>
<!--
User Name : ${sessionScope.userName} <br/>
DOB       : ${sessionScope.dob}
  -->
<form:form method="POST" action="/signup/saveSecurityQuestions"  modelAttribute="securityQuestionsForm">
		<form:errors path="*" cssClass="error" element="div" />
		<table>

			<tr>
				<td>Security Question 01 :</td>
				<td><form:select path="securityQuestion_01">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${securityQuestionsList_01}" />
				       </form:select>
                                </td>
				<td><form:errors path="securityQuestion_01" cssClass="error" /></td>
			</tr>
			
			 <tr>
		        <td><form:label path="securityAnswer_01">Answer :</form:label></td>
		        <td><form:input path="securityAnswer_01" /> </td>
	        	 <td> <form:errors path="securityAnswer_01" cssClass="error"/></td> 
   			 </tr>
   			 
   			 <tr>
				<td>Security Question 02 :</td>
				<td><form:select path="securityQuestion_02">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${securityQuestionsList_02}" />
				       </form:select>
                                </td>
				<td><form:errors path="securityQuestion_02" cssClass="error" /></td>
			</tr>
			
			 <tr>
		        <td><form:label path="securityAnswer_02">Answer :</form:label></td>
		        <td><form:input path="securityAnswer_02" /> </td>
	        	 <td> <form:errors path="securityAnswer_02" cssClass="error"/></td> 
   			 </tr>
   			 
   			 
   			 <tr>
				<td>Security Question 03 :</td>
				<td><form:select path="securityQuestion_03">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${securityQuestionsList_03}" />
				       </form:select>
                                </td>
				<td><form:errors path="securityQuestion_03" cssClass="error" /></td>
			</tr>
			
			 <tr>
		        <td><form:label path="securityAnswer_03">Answer :</form:label></td>
		        <td><form:input path="securityAnswer_03" /> </td>
	        	 <td> <form:errors path="securityAnswer_03" cssClass="error"/></td> 
   			 </tr>
			 
			<tr>
				<td colspan="3"><input type="submit" value="submit"/></td>
			</tr>
		</table>
	</form:form>
</body>


</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Home</title>
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
<h1 class="field">
	Login Success full.
</h1>   
Your Details: <br/>
  
 User Name : ${sessionScope.userName} <br/>
 DOB       : ${sessionScope.dob} <br/> <br/> <br/>
 
 security Question 01 :  ${sessionScope.securityQuestion_01} <br/>
 security Answer 01 :    ${sessionScope.securityAnswer_01} <br/> <br/>
 
 security Question 02 :  ${sessionScope.securityQuestion_02} <br/>
 security Answer 02 :   ${sessionScope.securityAnswer_02} <br/> <br/>
 
 security Question 03 :  ${sessionScope.securityQuestion_03} <br/>
 security Answer 03 :  ${sessionScope.securityAnswer_03} <br/> <br/>
 
   
 
 

</body>
</html>

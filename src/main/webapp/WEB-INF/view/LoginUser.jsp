<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
Welcome to Employee Information System
</h3>
<h4>Please Enter Login Details</h4>
<form:form action="LoginUser" method="post" modelAttribute="LoginForm">
            <table border="1">
                <tr>
                    <td>User name :</td>
                    <td><form:input path="login_user" /></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:input path="login_password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login" /></td>
                </tr>
            </table>
         </form:form>
         
          <h5><%=request.getAttribute("LoginError") %></h5>
</body>
</html>
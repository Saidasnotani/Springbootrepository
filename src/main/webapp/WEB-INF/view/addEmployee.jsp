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
 <form:form action="saveEmpl" method="post" modelAttribute="EmpForm">
            <table border="1">
                <tr>
                    <td colspan="2" align="center"><h2>Save Employee details</h2></td>
                </tr>
                <tr>
                    <td>Employee Name:</td>
                    <td><form:input path="emp_name" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save details" /></td>
                </tr>
            </table>
 </form:form>
</body>
</html>
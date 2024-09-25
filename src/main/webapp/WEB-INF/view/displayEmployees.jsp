<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <%@ page import="com.example.demo.Model.Employee" %>
 <%@ page import="java.util.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function calldel(id)
{
alert(id);
document.getElementById("form1").action = "/demoEmpApp/EmpInfo/delEmpl?empid="+id;
document.getElementById("form1").submit();
}
function addnewEmp()
{
document.getElementById("form1").action = "/demoEmpApp/EmpInfo/addnewEmpl";
document.getElementById("form1").submit();
}

</script>

</head>
<body>
<table><tr>
<td bgcolor="lightblue" bordercolor="black"><font size="10">Welcome to Employee Information System</font></td>
</tr> 
</table><br><br>
<input type="button" value= "Add New Employee" onclick="addnewEmp()">  
<form name="f1" id="form1" method="POST" >
<table border="1" style="border-width: 2">
<tr>
<td>Employee ID</td><td>Employee name</td>
</tr>
 	<c:forEach var="emplist" items="${list}" >
<tr>     
    <td width="15"><c:out value = "${emplist.emp_id}"/></td>
     <td width="32"><c:out value = "${emplist.emp_name}"/></td>
     <c:set var="tempempid_todel" value="${emplist.emp_id}" />
<td>
<input type="button" id="${emplist.emp_id}" value="Delete" onclick="calldel(<%=pageContext.getAttribute("tempempid_todel")%>)">
</td>
</tr>        
 </c:forEach>
 </table>
 </form>
</body>
</html>
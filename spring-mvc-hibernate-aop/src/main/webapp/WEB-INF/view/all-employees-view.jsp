<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC + Hibernate + AOP</title>
</head>

<style><%@include file="css/styles.css"%></style>

<body class="body">

<br>
<h1 class="header__title">All Employees</h1>
<br>
<br>
<table class="table">
    <tr class="tr__head">
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>

    <c:forEach var="employee" items="${allEmployees}">

        <c:url var="editButton" value="editEmployee">
            <c:param name="employeeId" value="${employee.id}"/>
        </c:url>

        <c:url var="deleteButton" value="deleteEmployee">
            <c:param name="employeeId" value="${employee.id}"/>
        </c:url>

        <tr class="tr__body">
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <input class="button_edit" type="button" value="Edit"
                       onclick="window.location.href='${editButton}'"/>
                <input class="button_delete" type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<input class="button_add " type="button" value="Add Employee"
       onclick="window.location.href='addNewEmployee'">
</body>


</html>

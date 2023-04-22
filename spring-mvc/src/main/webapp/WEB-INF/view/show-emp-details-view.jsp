<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC</title>
</head>

<body>

<h1>Information entered</h1>
<br>
<form:form action="askDetails"
           cssStyle="font-family:Helvetica,sans-serif; font-size: 14px">
    Name: ${employee.name} <br>
    Surname: ${employee.surname} <br>
    Phone number: ${employee.phoneNumber} <br>
    Phone number: ${employee.email} <br>
    Department: ${employee.department} <br>
    Salary: ${employee.salary} <br>
    Favorite car brand: ${employee.carBrand} <br>
    Language(s):
    <ul>
        <c:forEach var="lang" items="${employee.languages}">
            <li>${lang}</li>
        </c:forEach>
    </ul>
    <br><br>
    <input type="submit" value="Back">
</form:form>
</body>

</html>

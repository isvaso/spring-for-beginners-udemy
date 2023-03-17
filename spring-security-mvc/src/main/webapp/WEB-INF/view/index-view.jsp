<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity6">
<head>
    <title>Title</title>
</head>
<body>

<h1>Page for all employees</h1>

<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary"
onclick="window.location.href = 'hr_info'">
Only for HR stuff
</security:authorize>

<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance"
       onclick="window.location.href = 'managers_info'">
Only for managers
</security:authorize>


</body>
</html>

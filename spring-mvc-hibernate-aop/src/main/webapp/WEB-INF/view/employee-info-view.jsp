<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ilyabiryukov
  Date: 13.03.2023
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC + Hibernate + AOP</title>
</head>

<style><%@include file="css/styles.css"%></style>

<body class="body">

<br>
<h1 class="header__title">Employee Info</h1>
<br>

<form:form action="saveEmployee" modelAttribute="employee" cssClass="table">

    <form:hidden path="id"/>

    <br><br>Name<br>
    <form:input cssClass="employee_field" path="name"/>
    <br><br>Surname<br>
    <form:input cssClass="employee_field" path="surname"/>
    <br><br>Department<br>
    <form:input cssClass="employee_field" path="department"/>
    <br><br>Salary <br>
    <form:input cssClass="employee_field" path="salary"/>
    <br><br><br>
    <input class="button_ok" type="submit" value="OK"/>
</form:form>

</body>
</html>

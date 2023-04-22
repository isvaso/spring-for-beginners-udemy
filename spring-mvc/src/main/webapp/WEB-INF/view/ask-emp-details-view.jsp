<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC</title>
</head>

<body>

<h1>Please enter your information</h1>
<form:form action="showDetails" modelAttribute="employee"
           cssStyle="font-family:Helvetica, serif; font-size: 13px;">

    <br>Name
    <form:errors path="name" cssStyle="height: 0px; font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:input path="name" cssStyle="height: 12px; width: 160px; margin-top: 2px; margin-bottom: 8px"/>

    <br>Surname
    <form:errors path="surname" cssStyle="font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:input path="surname" cssStyle="height: 12px; width: 160px; margin-top: 2px; margin-bottom: 8px"/>

    <br>Department
    <form:errors path="department" cssStyle="font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:select path="department" items="${departments}" cssStyle="height: 12px; width: 164px; margin-top: 2px; margin-bottom: 8px"/>

    <br>Phone number
    <form:errors path="phoneNumber" cssStyle="font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:input path="phoneNumber" cssStyle="height: 12px; width: 160px; margin-top: 2px; margin-bottom: 8px"/>

    <br>Email
    <form:errors path="email" cssStyle="font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:input path="email" cssStyle="height: 12px; width: 160px; margin-top: 2px; margin-bottom: 8px"/>

    <br>Salary
    <form:errors path="salary" cssStyle="font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:input path="salary" cssStyle="height: 12px; width: 160px; margin-top: 2px; margin-bottom: 8px"/>

    <br>Favorite car brand
    <form:errors path="carBrand" cssStyle="font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:radiobuttons path="carBrand" items="${carBrands}" cssStyle="height: 12px; margin: 2px 0px 8px 0px"/>

    <br>Select foreign language(s)
    <form:errors path="languages" cssStyle="font-size: 9px; color: crimson; padding: 2px;"/>
    <br>
    <form:checkboxes path="languages" items="${languages}" cssStyle="height: 12px; margin: 2px 0px 8px 0px"/>

    <br><br>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>

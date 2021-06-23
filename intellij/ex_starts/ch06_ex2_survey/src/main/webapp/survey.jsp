<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
    <h1>Thanks for taking our suurvey!</h1>
    <p>Here is the information that you entered</p>

    <label class="pad_top">Email:</label>
    <span>${user.firstName}</span><br>

    <label class="pad_top">First Name:</label>
    <span>${user.lastName}</span><br>

    <label class="pad_top">Last Name:</label>
    <span>${user.email}</span><br>

    <label class="pad_top">Heard From:</label>
    <span>${user.heardFrom}</span><br>

    <label class="pad_top">Updates:</label>
    <span>${user.wantsUpdates}</span><br>

    <c:if test="${user.wantsUpdates == 'Yes'}">
        <label class="pad_top">Contact Via:</label>
        <span>${user.contactVia}</span><br>
    </c:if>

</body>
</html>

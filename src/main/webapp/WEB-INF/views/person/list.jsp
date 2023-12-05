<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 05.12.2023
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/person/add"/>">add person</a>
<table>
    <tr>
        <td>id</td>
        <td>login</td>
        <td>email</td>
        <td>password</td>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.login}</td>
            <td>${person.email}</td>
            <td>${person.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

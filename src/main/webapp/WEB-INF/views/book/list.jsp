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
<a href="<c:url value="/book-form/add"/>">add book</a>
<table>
    <tr>
        <td>id</td>
        <td>title</td>
        <td>rating</td>
        <td>publisher</td>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

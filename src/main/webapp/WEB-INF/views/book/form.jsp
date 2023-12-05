<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:input path="title"/>
<form:input path="rating"/>
<form:select path="publisher.id" items="${publishers}"
             itemLabel="name" itemValue="id"/>
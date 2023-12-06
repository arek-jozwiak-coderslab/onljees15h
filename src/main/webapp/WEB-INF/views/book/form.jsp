<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

title
<br/>
<form:input path="title"/>
<form:errors path="title"/>

<br/>
rating
<br/>
<form:input path="rating"/>
<form:errors path="rating"/>
<br/>
<br/>
pages
<br/>
<form:input path="pages"/>
<form:errors path="pages"/>
<br/>
<form:select path="publisher.id" items="${publishers}"
             itemLabel="name" itemValue="id"/>
<br/>
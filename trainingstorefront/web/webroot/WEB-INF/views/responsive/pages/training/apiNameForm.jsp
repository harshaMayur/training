<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<html>
<head>
    <title>ApiNameForm</title>
</head>
<body>
<template:page pageTitle="${pageTitle}">
<center>
    <h2>API NAME FORM</h2>
    <c:url value="https://powertools.local:9002/trainingstorefront/powertools/en/USD/nameForm/getDetails" var="save"/>
    
    <%--@elvariable id="nameApiForm" type="com"--%>
    <form:form action="${save}" method="post" modelAttribute="nameApiForm">

        <form:label path="name"/>Name:
        <form:input path="name"/>

        <input type="submit" name="button1" value="Get Details"/>

    </form:form>
</center>
</template:page>
</body>
</html>

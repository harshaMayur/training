<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NameAPI</title>
</head>
<body>
<template:page pageTitle="${pageTitle}">

    <table border="1" cellpadding="5">
        <tr>
            <td><b>Name</b></td>
            <td><b>Age</b></td>
            <td><b>Count</b></td>
        </tr>
        <tr>
            <td>${nameDetails.name}</td>
            <td>${nameDetails.age}</td>
            <td>${nameDetails.count}</td>
        </tr>
    </table>
</template:page>
</body>
</html>

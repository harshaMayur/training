<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>


<html>
<head>
    <title>Activity</title>
</head>
<body>
${"error"}
<template:page pageTitle="${pageTitle}">

    <table border="1" cellpadding="5">
        <tr>
            <td><b>Activity</b></td>
            <td><b>Type</b></td>
            <td><b>Participants</b></td>
            <td><b>Price</b></td>
            <td><b>Link</b></td>
            <td><b>Key</b></td>
            <td><b>Accessibility</b></td>
        </tr>
        <tr>
            <td>${activityDetails.activity}</td>
            <td>${activityDetails.type}</td>
            <td>${activityDetails.participants}</td>
            <td>${activityDetails.price}</td>
            <td>${activityDetails.link}</td>
            <td>${activityDetails.key}</td>
            <td>${activityDetails.accessibility}</td>
        </tr>
    </table>
</template:page>
</body>
</html>

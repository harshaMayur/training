<%--
  Created by IntelliJ IDEA.
  User: harsha
  Date: 1/28/2022
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>order details</title>
</head>

<body>
<%--<template:page pageTitle="${pageTitle}">--%>
<h1 align="center"> ORDERS DETAILS</h1>

<h3>Ordered on: ${CreationDate}</h3>

<table border="1" cellpadding="5">
    <tr>
        <th>Product Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Sub Total</th>
    </tr>
    <c:forEach var="orderEntryDetail" items="${orderEntryDetail}">
        <tr>
            <td><img src="${orderEntryDetail.product.images[0].url}"/></td>
            <td>${orderEntryDetail.product.name}</td>
            <td>${orderEntryDetail.basePrice.value}</td>
            <td>${orderEntryDetail.quantity}</td>
            <td>${orderEntryDetail.totalPrice.value}</td>
        </tr>
    </c:forEach>
</table>

<h3>ORDER TOTAL: ${order.totalPrice.value} </h3>
<%--</template:page>--%>
</body>
</html>

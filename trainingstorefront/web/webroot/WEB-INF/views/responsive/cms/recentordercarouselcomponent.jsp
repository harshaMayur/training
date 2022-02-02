<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>

<body>

    <h1 align="center"> RECENT ORDERS </h1>
    <table border="1" cellpadding="5">
        <tr>
            <th align="center">Order Id</th>
            <th align="center">Order Total</th>
        </tr>
        <c:forEach var="recentOrders" items="${recentOrders}">
            <tr>
                <td><a href="/trainingstorefront/powertools/en/USD/orderDetails/${recentOrders.code}">${recentOrders.code}</a></td>
                <td>$${recentOrders.total.value}</td>
            </tr>
        </c:forEach>
    </table>
</body>
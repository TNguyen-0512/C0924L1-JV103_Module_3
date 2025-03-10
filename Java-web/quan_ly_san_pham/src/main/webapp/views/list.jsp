<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 09/03/2025
  Time: 23:28:PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<form action="//products?action" method="get">
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Tên sản phẩm</th>
            <th>Giá sản phẩm</th>
            <th>Mô tả</th>
            <th>Nhà sản xuất</th>
        </tr>
        <c:forEach items="${products}" var="product" varStatus="status">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}VND</td>
                <td>${product.description}</td>
                <td>${product.manufacturer}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 11/03/2025
  Time: 04:12:AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
  <c:import url="../layout/labrary.jsp"/>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<table class="table table-bordered">
    <tr>
        <th>Id</th>
        <th>Tên sản phẩm</th>
        <th>Giá sản phẩm</th>
        <th>Mô tả</th>
        <th>Nhà sản xuất</th>
        <th>Sửa</th>
        <th>Xóa</th>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="status">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}VND</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td><button>Sửa</button></td>
            <td><button>Xóa</button></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/products?action=create">Thêm mới</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 10/03/2025
  Time: 19:22:PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Mới</title>
</head>
<body>
<h1>Thêm mới</h1>
<form method="post" action="${pageContext.request.contextPath}/products?action=add">
    <input type="number" name="id" placeholder="Nhập ID">
    <input type="text" name="name" placeholder="Nhập tên">
    <input type="number" name="price" placeholder="Nhập giá">
    <input type="text" name="description" placeholder="Nhập mô tả">
    <input type="text" name="manufacturer" placeholder="Nhập nhà sản xuất">
    <button type="submit">Lưu</button>
</form>
</body>
</html>

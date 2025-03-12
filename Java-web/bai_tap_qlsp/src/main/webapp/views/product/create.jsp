<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 12/03/2025
  Time: 19:13:PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới</h1>
<form action="${pageContext.request.contextPath}/products?action=create" method="post">
    <label>
        <input type="number" name="id" placeholder="Nhập ID">
    </label>
    <label>
        <input type="text" name="name" placeholder="Nhập tên">
    </label>
    <label>
        <input type="number" name="price" min ="0" step="0.1" placeholder="Nhập giá">
    </label>
    <label>
        <input type="text" name="description" placeholder="Nhập mô tả">
    </label>
    <label>
        <input type="text" name="manufacturer" placeholder="Nhập nhà sản xuất">
    </label>
    <button type="submit">Lưu</button>
</form>
</body>
</html>

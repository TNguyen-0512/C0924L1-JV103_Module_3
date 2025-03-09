<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 09/03/2025
  Time: 18:44:PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Khách Hàng</title>
</head>
<body>
<h1>DANH SÁCH KHÁCH HÀNG</h1>
<table border="1">
  <tr>
    <th>Họ và tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach items="${clients}" var="client" varStatus="status">
    <tr>
      <td>${client.name}</td>
      <td>${client.birthday}</td>
      <td>${client.address}</td>
      <td>
        <img src="${client.image}" width="200" height="auto">
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

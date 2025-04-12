<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 12/03/2025
  Time: 19:10:PM
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
<div class="d-flex bg-info text-dark justify-content-center">
  <h1><a href="/products?action" style="text-decoration: none;">Danh sách sản phẩm</a></h1>
</div>

<h3 style="color: red">${param.mess}</h3>
<form action="/products" method="get" class="d-flex justify-content-end">
  <input hidden="hidden" name="action" value="search">
  <input value="${searchName}" class="form-control form-control-sm w-25" name="searchName" placeholder="Nhập tên cần tìm kếm">
  <button class="btn btn-primary btn-sm">Tìm kiếm</button>
</form>
<table class="table table-striped table-bordered">
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
      <td><input type="text" value="${product.name}"></td>
      <td><input type="number" value="${product.price}"></td>
      <td><input type="text" value="${product.description}"></td>
      <td><input type="text" value="${product.manufacturer}"></td>
      <td><button onclick="del(`${product.getId()}`,`${product.getName()}`)" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">Xóa</button></td>
      <td><button type="submit" class="btn btn-primary btn-sm">Sửa</button></td>
    </tr>
  </c:forEach>
</table>
<a href="/products?action=create">Thêm mới</a>
<!-- Modal Xoá-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <form action="/products" method="get">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Xóa sản phẩm</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <input hidden="hidden" name="action" value="delete">
          <input hidden="hidden" id="deleteId" name="deleteId">
          <span>Bạn có muốn xoá sản phẩm có tên </span><span id="deleteName"></span>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
          <button type="submit" class="btn btn-danger">Xoá</button>
        </div>
      </div>
    </form>

  </div>
</div>

<script>
  function del(id,name){
    document.getElementById("deleteId").value = id;
    document.getElementById("deleteName").innerText = name;
  }
</script>
</body>
</html>
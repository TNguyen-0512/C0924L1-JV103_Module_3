<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <c:import url="../layout/labrary.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
<div class="container-fluid mt-3">
    <div class="d-flex bg-info text-white justify-content-center p-3 mb-4">
        <h1><a href="/khachhang?action" class="text-white text-decoration-none">Danh sách khách hàng</a></h1>
    </div>

    <!-- Thông báo -->
    <c:if test="${param.mess != null}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${param.mess}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    </c:if>
<div class="row mb-3">
    <div class="col-md-6">
        <a href="/khachhang?action=create" class="btn btn-success mb-2">
            <i class="fas fa-plus-circle"></i> Thêm mới khách hàng
        </a>
    </div>
    <div class="col-md-6">
        <form action="/khachhang" method="get" class="d-flex justify-content-end">
            <input hidden="hidden" name="action" value="search">
            <div class="input-group">
                <input type="text" class="form-control" name="searchName" value="${searchName}" placeholder="Tìm kiếm theo tên...">
                <button class="btn btn-primary" type="submit">
                    <i class="fas fa-search"></i> Tìm kiếm
                </button>
            </div>
        </form>
    </div>
</div>
<table class="table table-bordered table-striped table-hover">
    <thead class="thead-dark">
    <tr>
        <th>STT</th>
        <th>Mã khách hàng</th>
        <th>Họ tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Số CMND</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Loại khách</th>
        <th colspan="2">Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="khachHang" items="${khachHangList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${khachHang.maKhachHang}</td>
            <td>${khachHang.hoTen}</td>
            <td>${khachHang.ngaySinh}</td>
            <td>
                <c:if test="${khachHang.gioiTinh}">Nam</c:if>
                <c:if test="${!khachHang.gioiTinh}">Nữ</c:if>
            </td>
            <td>${khachHang.soCMND}</td>
            <td>${khachHang.soDienThoai}</td>
            <td>${khachHang.email}</td>
            <td>${khachHang.diaChi}</td>
            <td>
                <c:choose>
                    <c:when test="${khachHang.maLoaiKhach == 1}">Diamond</c:when>
                    <c:when test="${khachHang.maLoaiKhach == 2}">Platinum</c:when>
                    <c:when test="${khachHang.maLoaiKhach == 3}">Gold</c:when>
                    <c:when test="${khachHang.maLoaiKhach == 4}">Silver</c:when>
                    <c:when test="${khachHang.maLoaiKhach == 5}">Member</c:when>
                    <c:otherwise>Không xác định</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="/khachhang?action=edit&id=${khachHang.maKhachHang}" class="btn btn-warning btn-sm">Sửa</a>
            </td>
            <td>
                <button onclick="del('${khachHang.maKhachHang}','${khachHang.hoTen}')"
                        type="button"
                        class="btn btn-danger btn-sm"
                        data-bs-toggle="modal"
                        data-bs-target="#exampleModal">
                    Xóa
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach begin="1" end="${endP}" var="i" >
    <a href="#">${i}</a>
    </c:forEach>
<!-- Modal xác nhận xóa -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/khachhang" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xóa khách hàng</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" name="action" value="delete">
                    <input hidden="hidden" id="deleteId" name="id">
                    <span>Bạn có muốn xóa khách hàng có tên </span><span id="deleteName"></span><span>?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-danger">Xóa</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function del(maKhachHang, tenKhachHang) {
        document.getElementById("deleteId").value = maKhachHang;
        document.getElementById("deleteName").textContent = tenKhachHang;
    }
</script>
</body>
</html>
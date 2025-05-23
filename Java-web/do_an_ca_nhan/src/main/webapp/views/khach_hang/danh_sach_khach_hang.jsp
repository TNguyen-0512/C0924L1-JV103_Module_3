<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <c:import url="../layout/labrary.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
<div class="container mt-4">
    <div class="text-center bg-primary text-white p-3 rounded shadow-sm mb-4">
        <h2 class="mb-0">
            <a href="/khachhang" class="text-white text-decoration-none">
                <i class="fas fa-users"></i> Danh sách khách hàng
            </a>
        </h2>
    </div>

    <!-- Thông báo -->
    <c:if test="${param.mess != null}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${param.mess}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <div class="row mb-3 align-items-center">
        <div class="col-md-6">
            <a href="/khachhang?action=create" class="btn btn-success">
                <i class="fas fa-plus-circle"></i> Thêm khách hàng
            </a>
        </div>
        <div class="col-md-6">
            <form action="/khachhang" method="get" class="d-flex justify-content-end">
                <input type="hidden" name="action" value="search">
                <div class="input-group">
                    <input type="text" class="form-control" name="searchName" value="${searchName}" placeholder="Tìm kiếm theo tên...">
                    <button class="btn btn-outline-primary" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>

    <div class="table-responsive shadow-sm rounded">
        <table class="table table-bordered table-hover align-middle text-center">
            <thead class="table-dark">
            <tr>
                <th>Mã KH</th>
                <th>Họ tên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>CMND</th>
                <th>SĐT</th>
                <th>Email</th>
                <th>Địa chỉ</th>
                <th>Loại khách</th>
                <th colspan="2">Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="khachHang" items="${khachHangList}" varStatus="loop">
                <tr>
                    <td>${khachHang.maKhachHang}</td>
                    <td>${khachHang.hoTen}</td>
                    <td>${khachHang.ngaySinh}</td>
                    <td><c:out value="${khachHang.gioiTinh ? 'Nam' : 'Nữ'}"/></td>
                    <td>${khachHang.soCMND}</td>
                    <td>${khachHang.soDienThoai}</td>
                    <td>${khachHang.email}</td>
                    <td>${khachHang.diaChi}</td>
                    <td>${khachHang.loaiKhach}</td>
                    <td>
                        <a href="/khachhang?action=edit&id=${khachHang.maKhachHang}" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i>
                        </a>
                    </td>
                    <td>
                        <button onclick="del('${khachHang.maKhachHang}','${khachHang.hoTen}')"
                                class="btn btn-danger btn-sm"
                                data-bs-toggle="modal"
                                data-bs-target="#deleteModal">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="mt-3 d-flex justify-content-between align-items-center">
        <a class="btn btn-secondary" href="/home"><i class="fas fa-arrow-left"></i> Quay về</a>
        <nav>
            <ul class="pagination pagination-sm mb-0">
                <c:forEach begin="1" end="${endP}" var="i">
                    <li class="page-item ${i == currentPage ? 'active' : ''}">
                        <a class="page-link" href="/khachhang?page=${i}">${i}</a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>

    <!-- Modal xác nhận xóa -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/khachhang" method="get">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" id="deleteId" name="id">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Xác nhận xóa</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body text-center">
                        <p>Bạn có chắc chắn muốn xóa khách hàng <strong id="deleteName"></strong> không?</p>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-danger">Xóa</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- Script xử lý xóa -->
    <script>
        function del(maKH, tenKH) {
            document.getElementById("deleteId").value = maKH;
            document.getElementById("deleteName").textContent = tenKH;
        }
    </script>
</div>
</body>
</html>

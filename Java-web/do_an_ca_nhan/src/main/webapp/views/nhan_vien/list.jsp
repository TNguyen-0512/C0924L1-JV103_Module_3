<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
    <c:import url="../layout/labrary.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
<div class="container mt-4">
    <div class="text-center bg-primary text-white p-3 rounded shadow-sm mb-4">
        <h2 class="mb-0">
            <a href="/nhanvien" class="text-white text-decoration-none">
                <i class="fas fa-users"></i> Danh sách nhân viên
            </a>
        </h2>
    </div>
    <c:if test="${param.mess != null}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${param.mess}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <div class="row mb-3 align-items-center">
        <div class="col-md-6">
            <a href="/nhanvien?action=create" class="btn btn-success">
                <i class="fas fa-plus-circle"></i> Thêm nhân viên
            </a>
        </div>
        <div class="col-md-6">
            <form action="/nhanvien" method="get" class="d-flex justify-content-end">
                <input type="hidden" name="action" value="search">
                <div class="input-group">
                    <input type="text" name="searchName" value="${searchName}" class="form-control"
                           placeholder="Tìm theo tên...">
                    <button type="submit" class="btn btn-outline-primary">
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
                <th>Mã NV</th>
                <th>Họ tên</th>
                <th>Ngày sinh</th>
                <th>CMND</th>
                <th>Lương</th>
                <th>SĐT</th>
                <th>Email</th>
                <th>Địa chỉ</th>
                <th>Vị trí</th>
                <th>Trình độ</th>
                <th>Bộ phận</th>
                <th colspan="2">Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="nv" items="${nhanVienList}" varStatus="loop">
                <tr>
                    <td>${nv.maNhanVien}</td>
                    <td>${nv.hoTen}</td>
                    <td><fmt:formatDate value="${nv.ngaySinh}" pattern="dd/MM/yyyy"/></td>
                    <td>${nv.soCMND}</td>
                    <td>
                        <fmt:formatNumber value="${nv.luong}" type="currency" currencySymbol="₫" groupingUsed="true"/>
                    </td>

                    <td>${nv.soDienThoai}</td>
                    <td>${nv.email}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.tenViTri}</td>
                    <td>${nv.tenTrinhDo}</td>
                    <td>${nv.tenBoPhan}</td>
                    <td>
                        <a href="/nhanvien?action=edit&id=${nv.maNhanVien}" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i>
                        </a>
                    </td>
                    <td>
                        <button type="button"
                                class="btn btn-danger btn-sm"
                                data-bs-toggle="modal"
                                data-bs-target="#deleteModal"
                                onclick="del('${nv.maNhanVien}','${nv.hoTen}')">
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
                        <a class="page-link" href="/nhanvien?page=${i}">${i}</a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>

    <!-- Modal xác nhận xóa -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/nhanvien" method="get">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" id="deleteId" name="id">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Xác nhận xóa</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body text-center">
                        <p>Bạn có chắc chắn muốn xóa nhân viên <strong id="deleteName"></strong> không?</p>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-danger">Xóa</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script>
        function del(maNV, tenNV) {
            document.getElementById("deleteId").value = maNV;
            document.getElementById("deleteName").textContent = tenNV;
        }
    </script>
</div>
</body>
</html>

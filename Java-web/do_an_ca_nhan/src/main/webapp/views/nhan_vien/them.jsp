<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm nhân viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container py-5">
    <h2 class="text-center mb-4">Thêm mới nhân viên</h2>
    <form action="/nhanvien" method="post" class="bg-white p-4 rounded shadow-sm">
        <input type="hidden" name="action" value="create">

        <div class="mb-3">
            <label class="form-label">Họ tên</label>
            <input type="text" name="hoTen" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày sinh</label>
            <input type="date" name="ngaySinh" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">CMND</label>
            <input type="text" name="soCMND" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Lương</label>
            <input type="number" step="0.01" name="luong" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" name="soDienThoai" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" name="diaChi" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Vị trí</label>
            <select name="maViTri" class="form-select" required>
                <c:forEach var="vt" items="${viTriList}">
                    <option value="${vt.maViTri}">${vt.tenViTri}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Trình độ</label>
            <select name="maTrinhDo" class="form-select" required>
                <c:forEach var="td" items="${trinhDoList}">
                    <option value="${td.maTrinhDo}">${td.tenTrinhDo}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Bộ phận</label>
            <select name="maBoPhan" class="form-select" required>
                <c:forEach var="bp" items="${boPhanList}">
                    <option value="${bp.maBoPhan}">${bp.tenBoPhan}</option>
                </c:forEach>
            </select>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-success">Thêm mới</button>
            <a href="/nhanvien" class="btn btn-secondary">Hủy</a>
        </div>
    </form>
</div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sửa dịch vụ</title>
    <c:import url="../layout/labrary.jsp"/>
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center mb-4">Sửa dịch vụ</h2>
    <form method="post" action="/dichvu?action=update">
        <input type="hidden" name="maDichVu" value="${dichVu.maDichVu}">

        <div class="mb-3">
            <label for="tenDichVu" class="form-label">Tên dịch vụ</label>
            <input type="text" class="form-control" id="tenDichVu" name="tenDichVu" value="${dichVu.tenDichVu}" required>
        </div>
        <div class="mb-3">
            <label for="dienTich" class="form-label">Diện tích</label>
            <input type="number" class="form-control" id="dienTich" name="dienTich" value="${dichVu.dienTich}" required>
        </div>
        <div class="mb-3">
            <label for="chiPhiThue" class="form-label">Chi phí thuê</label>
            <input type="number" class="form-control" id="chiPhiThue" name="chiPhiThue" value="${dichVu.chiPhiThue}" required>
        </div>
        <div class="mb-3">
            <label for="soNguoiToiDa" class="form-label">Số người tối đa</label>
            <input type="number" class="form-control" id="soNguoiToiDa" name="soNguoiToiDa" value="${dichVu.soNguoiToiDa}" required>
        </div>
        <div class="mb-3">
            <label for="maKieuThue" class="form-label">Kiểu thuê</label>
            <select name="maKieuThue" class="form-select" required>
                <c:forEach var="kt" items="${kieuThueList}">
                    <option value="${kt.maKieuThue}" ${kt.maKieuThue == dichVu.maKieuThue ? 'selected' : ''}>${kt.tenKieuThue}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="maLoaiDichVu" class="form-label">Loại dịch vụ</label>
            <select name="maLoaiDichVu" class="form-select" required>
                <c:forEach var="ldv" items="${loaiDichVuList}">
                    <option value="${ldv.maLoaiDichVu}" ${ldv.maLoaiDichVu == dichVu.maLoaiDichVu ? 'selected' : ''}>${ldv.tenLoaiDichVu}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
        <a href="/dichvu" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>

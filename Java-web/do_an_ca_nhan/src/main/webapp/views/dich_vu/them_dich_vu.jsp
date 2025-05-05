<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Thêm mới dịch vụ</title>
  <c:import url="../layout/labrary.jsp"/>
</head>
<body>
<div class="container mt-5">
  <h2 class="text-center mb-4 text-primary">Thêm mới dịch vụ</h2>
  <form action="/dichvu?action=create" method="post">
    <div class="mb-3">
      <label class="form-label">Tên dịch vụ</label>
      <input type="text" class="form-control" name="tenDichVu" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Diện tích</label>
      <input type="number" class="form-control" name="dienTich" min="1" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Chi phí thuê</label>
      <input type="number" class="form-control" name="chiPhiThue" min="0" step="1000" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Số người tối đa</label>
      <input type="number" class="form-control" name="soNguoiToiDa" min="1" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Loại dịch vụ</label>
      <select class="form-select" name="maLoaiDichVu" required>
        <c:forEach var="loai" items="${loaiDichVuList}">
          <option value="${loai.maLoaiDichVu}">${loai.tenLoaiDichVu}</option>
        </c:forEach>
      </select>
    </div>

    <div class="mb-3">
      <label class="form-label">Kiểu thuê</label>
      <select class="form-select" name="maKieuThue" required>
        <c:forEach var="kieu" items="${kieuThueList}">
          <option value="${kieu.maKieuThue}">${kieu.tenKieuThue}</option>
        </c:forEach>
      </select>
    </div>

    <div class="mb-3">
      <label class="form-label">Tiêu chuẩn phòng</label>
      <input type="text" class="form-control" name="tieuChuanPhong">
    </div>

    <div class="mb-3">
      <label class="form-label">Mô tả tiện nghi khác</label>
      <input type="text" class="form-control" name="moTaTienNghiKhac">
    </div>

    <div class="mb-3">
      <label class="form-label">Diện tích hồ bơi (nếu có)</label>
      <input type="number" class="form-control" name="dienTichHoBoi" min="0" step="0.1">
    </div>

    <div class="mb-3">
      <label class="form-label">Số tầng (nếu có)</label>
      <input type="number" class="form-control" name="soTang" min="0">
    </div>

    <div class="text-end">
      <button type="submit" class="btn btn-success">Thêm mới</button>
      <a href="/dichvu" class="btn btn-secondary">Quay lại</a>
    </div>
  </form>
</div>
</body>
</html>

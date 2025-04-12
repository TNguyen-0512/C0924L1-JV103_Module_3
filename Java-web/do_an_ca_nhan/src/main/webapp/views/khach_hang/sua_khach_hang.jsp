<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Chỉnh sửa khách hàng</title>
  <c:import url="../layout/labrary.jsp"/>
</head>
<body>
<div class="d-flex bg-info text-dark justify-content-center">
  <h1>Chỉnh sửa thông tin khách hàng</h1>
</div>

<div class="container mt-4">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <form action="/khachhang?action=update" method="post">
        <input type="hidden" name="maKhachHang" value="${khachHangEdit.maKhachHang}">

        <div class="form-group row">
          <label for="hoTen" class="col-sm-3 col-form-label">Họ tên:</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="hoTen" name="hoTen" value="${khachHangEdit.hoTen}" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="ngaySinh" class="col-sm-3 col-form-label">Ngày sinh:</label>
          <div class="col-sm-9">
            <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="${khachHangEdit.ngaySinh}" required>
          </div>
        </div>

        <div class="form-group row">
          <label class="col-sm-3 col-form-label">Giới tính:</label>
          <div class="col-sm-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="gioiTinh" id="nam" value="true" ${khachHangEdit.gioiTinh ? 'checked' : ''}>
              <label class="form-check-label" for="nam">Nam</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="gioiTinh" id="nu" value="false" ${!khachHangEdit.gioiTinh ? 'checked' : ''}>
              <label class="form-check-label" for="nu">Nữ</label>
            </div>
          </div>
        </div>

        <div class="form-group row">
          <label for="soCMND" class="col-sm-3 col-form-label">Số CMND:</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="soCMND" name="soCMND" value="${khachHangEdit.soCMND}" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="soDienThoai" class="col-sm-3 col-form-label">Số điện thoại:</label>
          <div class="col-sm-9">
            <input type="tel" class="form-control" id="soDienThoai" name="soDienThoai" value="${khachHangEdit.soDienThoai}" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="email" class="col-sm-3 col-form-label">Email:</label>
          <div class="col-sm-9">
            <input type="email" class="form-control" id="email" name="email" value="${khachHangEdit.email}" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="diaChi" class="col-sm-3 col-form-label">Địa chỉ:</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="diaChi" name="diaChi" value="${khachHangEdit.diaChi}" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="maLoaiKhach" class="col-sm-3 col-form-label">Loại khách:</label>
          <div class="col-sm-9">
            <select class="form-control" id="maLoaiKhach" name="maLoaiKhach" required>
              <option value="1" ${khachHangEdit.maLoaiKhach == 1 ? 'selected' : ''}>Diamond</option>
              <option value="2" ${khachHangEdit.maLoaiKhach == 2 ? 'selected' : ''}>Platinum</option>
              <option value="3" ${khachHangEdit.maLoaiKhach == 3 ? 'selected' : ''}>Gold</option>
              <option value="4" ${khachHangEdit.maLoaiKhach == 4 ? 'selected' : ''}>Silver</option>
              <option value="5" ${khachHangEdit.maLoaiKhach == 5 ? 'selected' : ''}>Member</option>
            </select>
          </div>
        </div>

        <div class="form-group row">
          <div class="col-sm-9 offset-sm-3">
            <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
            <a href="/khachhang" class="btn btn-secondary">Hủy</a>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
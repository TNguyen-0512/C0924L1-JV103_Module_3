<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Thêm khách hàng</title>
  <c:import url="../layout/labrary.jsp"/>
</head>
<body>
<div class="d-flex bg-success text-white justify-content-center">
  <h1>Thêm khách hàng mới</h1>
</div>

<div class="container mt-4">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <form action="/khachhang?action=create" method="post">
        <div class="form-group row">
          <label for="hoTen" class="col-sm-3 col-form-label">Họ tên:</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="hoTen" name="hoTen" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="ngaySinh" class="col-sm-3 col-form-label">Ngày sinh:</label>
          <div class="col-sm-9">
            <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" required>
          </div>
        </div>

        <div class="form-group row">
          <label class="col-sm-3 col-form-label">Giới tính:</label>
          <div class="col-sm-9">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="gioiTinh" id="nam" value="true" checked>
              <label class="form-check-label" for="nam">Nam</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="gioiTinh" id="nu" value="false">
              <label class="form-check-label" for="nu">Nữ</label>
            </div>
          </div>
        </div>

        <div class="form-group row">
          <label for="soCMND" class="col-sm-3 col-form-label">Số CMND:</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="soCMND" name="soCMND" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="soDienThoai" class="col-sm-3 col-form-label">Số điện thoại:</label>
          <div class="col-sm-9">
            <input type="tel" class="form-control" id="soDienThoai" name="soDienThoai" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="email" class="col-sm-3 col-form-label">Email:</label>
          <div class="col-sm-9">
            <input type="email" class="form-control" id="email" name="email" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="diaChi" class="col-sm-3 col-form-label">Địa chỉ:</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="diaChi" name="diaChi" required>
          </div>
        </div>

        <div class="form-group row">
          <label for="loaiKhach" class="col-sm-3 col-form-label">Loại khách:</label>
          <div class="col-sm-9">
            <select class="form-control" id="loaiKhach" name="loaiKhach" required>
              <c:forEach var="lk" items="${loaiKhachList}">
                <option value="${lk.tenLoaiKhach}">${lk.tenLoaiKhach}</option>
              </c:forEach>
            </select>
          </div>
        </div>

        <div class="form-group row">
          <div class="col-sm-9 offset-sm-3">
            <button type="submit" class="btn btn-success">Thêm khách hàng</button>
            <a href="/khachhang" class="btn btn-secondary">Hủy</a>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>

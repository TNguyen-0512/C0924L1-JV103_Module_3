<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Chỉnh sửa nhân viên</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container py-5">
  <h2 class="text-center mb-4">Chỉnh sửa thông tin nhân viên</h2>
  <form action="/nhanvien" method="post" class="bg-white p-4 rounded shadow-sm">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${nhanVien.maNhanVien}">

    <div class="mb-3">
      <label class="form-label">Họ tên</label>
      <input type="text" name="hoTen" class="form-control" value="${nhanVien.hoTen}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Ngày sinh</label>
      <input type="date" name="ngaySinh" class="form-control" value="${nhanVien.ngaySinh}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">CMND</label>
      <input type="text" name="soCMND" class="form-control" value="${nhanVien.soCMND}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Lương</label>
      <input type="number" step="0.01" name="luong" class="form-control" value="${nhanVien.luong}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Số điện thoại</label>
      <input type="text" name="soDienThoai" class="form-control" value="${nhanVien.soDienThoai}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Email</label>
      <input type="email" name="email" class="form-control" value="${nhanVien.email}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Địa chỉ</label>
      <input type="text" name="diaChi" class="form-control" value="${nhanVien.diaChi}" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Vị trí</label>
      <select name="maViTri" class="form-select" required>
        <c:forEach var="vt" items="${viTriList}">
          <option value="${vt.maViTri}"
                  <c:if test="${vt.maViTri == nhanVien.maViTri}">selected</c:if>>
              ${vt.tenViTri}
          </option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3">
      <label class="form-label">Trình độ</label>
      <select name="maTrinhDo" class="form-select" required>
        <c:forEach var="td" items="${trinhDoList}">
          <option value="${td.maTrinhDo}" <c:if test="${td.maTrinhDo == nhanVien.maTrinhDo}">selected</c:if>>${td.tenTrinhDo}</option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3">
      <label class="form-label">Bộ phận</label>
      <select name="maBoPhan" class="form-select" required>
        <c:forEach var="bp" items="${boPhanList}">
          <option value="${bp.maBoPhan}" <c:if test="${bp.maBoPhan == nhanVien.maBoPhan}">selected</c:if>>${bp.tenBoPhan}</option>
        </c:forEach>
      </select>
    </div>
    <div class="text-center">
      <button type="submit" class="btn btn-primary">Cập nhật</button>
      <a href="/nhanvien" class="btn btn-secondary">Hủy</a>
    </div>
  </form>
</div>
</body>
</html>
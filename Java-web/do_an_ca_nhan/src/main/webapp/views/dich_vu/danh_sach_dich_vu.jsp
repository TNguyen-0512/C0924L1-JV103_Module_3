<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách dịch vụ</title>
    <c:import url="../layout/labrary.jsp"/>
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center mb-4">Danh sách dịch vụ</h2>
    <a href="/dichvu?action=create" class="btn btn-success mb-3">Thêm mới dịch vụ</a>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Diện tích</th>
            <th>Chi phí thuê</th>
            <th>Số người tối đa</th>
            <th>Kiểu thuê</th>
            <th>Loại dịch vụ</th>
            <th>Chức năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dv" items="${dichVuList}">
            <tr>
                <td>${dv.maDichVu}</td>
                <td>${dv.tenDichVu}</td>
                <td>${dv.dienTich}</td>
                <td>${dv.chiPhiThue}</td>
                <td>${dv.soNguoiToiDa}</td>
                <td>${dv.tenKieuThue}</td>
                <td>${dv.tenLoaiDichVu}</td>
                <td>
                    <a href="/dichvu?action=edit&id=${dv.maDichVu}" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="/dichvu?action=delete&id=${dv.maDichVu}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

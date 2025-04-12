<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Sản phẩm</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/11.0.5/swiper-bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container my-5">
    <h2 class="text-center mb-4">Danh sách Sản phẩm</h2>

    <!-- Hiển thị thông báo nếu không có sản phẩm -->
    <c:if test="${empty bookList}">
        <p class="text-danger text-center">Không có sản phẩm nào.</p>
    </c:if>

    <!-- Kiểm tra nếu danh sách có sản phẩm -->
    <c:if test="${not empty bookList}">
        <table class="table table-bordered text-center">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Mô tả</th>
                <th>Danh mục</th>
                <th>Nhà cung cấp</th>
                <th>Ảnh</th>
                <th>Tác giả</th>
                <th>Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.productId}</td>
                    <td>${book.name}</td>
                    <td>${book.price} VNĐ</td>
                    <td>${book.stock}</td>
                    <td>${book.description}</td>
                    <td>${book.categoryName}</td>
                    <td>${book.supplierName}</td>
                    <td>
                        <img src="${book.imageUrl}" width="50" height="50" alt="Ảnh sản phẩm">
                    </td>
                    <td>${book.author}</td>
                    <td>
                        <a href="/productmanagement?action=update&id=${book.productId}" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i> Sửa
                        </a>
                    </td>
                    <td>
                        <a href="/productmanagement?action=delete&id=${book.productId}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')">
                            <i class="fas fa-trash-alt"></i> Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Hệ thống Quản lý</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:import url="views/layout/labrary.jsp" />
    <link rel="stylesheet" href="css/index_css.css">
</head>
<body>
<div class="header">
    <div class="logo-container">
        <img src="views/images/furama-logo.png" alt="Logo" class="logo">
        <span class="logo-text">Furama</span>
    </div>
    <div class="user-login">Xin chào, ${sessionScope.userLoggedIn.hoTen}</div>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Quản lý</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navMenu">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/nhanvien">Nhân Viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/khachhang">Khách Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dichvu">Dịch Vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Hợp Đồng</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control" type="search" placeholder="Tìm kiếm">
            </form>
        </div>
    </div>
</nav>

<div class="content-wrapper">
    <div class="sidebar">
        <ul>
            <li><a href="#">➕ Thêm nhân viên</a></li>
            <li><a href="#">➕ Thêm khách hàng</a></li>
            <li><a href="#">➕ Thêm dịch vụ</a></li>
        </ul>
    </div>
    <div class="main-content">
        <h3 class="text-center text-secondary">Chào mừng đến với hệ thống quản lý Furama</h3>
    </div>
</div>

<div class="footer">
<%--    <img src="batman.gif" alt="batman" class="batman">--%>
    © 2025 - Bùi Trung Nguyên - Hệ thống Quản lý Furama
</div>

</body>
</html>

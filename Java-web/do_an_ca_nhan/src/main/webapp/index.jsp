<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Hệ thống Quản lý Nhân viên</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:import url="views/layout/labrary.jsp" />

    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
        }

        .header {
            background-color: #fff;
            padding: 15px 30px;
            border-bottom: 1px solid #dee2e6;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo-container {
            display: flex;
            align-items: center;
        }

        .logo {
            height: 45px;
            margin-right: 10px;
        }

        .logo-text {
            font-size: 20px;
            font-weight: bold;
            color: #343a40;
        }

        .user-login {
            font-size: 16px;
            color: #495057;
        }

        .sidebar {
            width: 200px;
            background-color: #ffffff;
            border-right: 1px solid #dee2e6;
            padding-top: 20px;
            height: 100vh;
        }

        .sidebar ul {
            list-style: none;
            padding-left: 20px;
        }

        .sidebar li {
            margin-bottom: 15px;
        }

        .sidebar a {
            text-decoration: none;
            color: #495057;
            font-weight: 500;
        }

        .sidebar a:hover {
            color: #007bff;
        }

        .main-content {
            flex: 1;
            padding: 30px;
            background-color: #f1f3f5;
        }

        .footer {
            background-color: #fff;
            text-align: center;
            padding: 10px 0;
            border-top: 1px solid #dee2e6;
            font-size: 14px;
            color: #6c757d;
        }

        .content-wrapper {
            display: flex;
            min-height: calc(100vh - 110px); /* trừ header và footer */
        }

        .navbar .nav-link {
            font-weight: 500;
        }

        .navbar .nav-link:hover {
            color: #0056b3;
        }
    </style>
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
                    <a class="nav-link" href="#">Dịch Vụ</a>
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
    © 2025 - Bùi Trung Nguyên - Hệ thống Quản lý Furama
</div>

</body>
</html>

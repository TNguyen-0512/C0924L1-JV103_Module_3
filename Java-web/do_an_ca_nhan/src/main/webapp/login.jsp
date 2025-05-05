<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 19/04/2025
  Time: 03:44:AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập</title>
    <c:import url="views/layout/labrary.jsp" />
    <link rel="stylesheet" type="text/css" href="css/login_css.css" />
</head>
<body>
<form method="POST" action="/login">
    <div class="box">
        <div class="container">
            <span>Khu nghỉ dưỡng Furama</span>
            <header>Đăng Nhập</header>
        </div>
        <div class="input-field">
            <input type="text" class="input" name="email" placeholder="Email hoặc SDT" required>
            <i class="bx bx-user"></i>
        </div>
        <div class="input-field">
            <input type="password" class="input" name="password" placeholder="Mật khẩu" required>
            <i class="bx bx-lock-alt"></i>
        </div>
        <div class="input-field">
            <input type="submit" class="submit" value="Đăng nhập">
        </div>
        <div class="bottom">
            <div class="left">
                <input type="checkbox" id="check">
                <label for="check">Nhớ mật khẩu</label>
            </div>
            <div class="right">
                <label><a href="#">Quên mật khẩu</a></label>
            </div>
        </div>
    </div>
</form>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Product Discount Calculator" %></h1>
<form action="discount" method="post">
    <label for="product_description">Product Description</label>
    <input type="text" id="product_description" name="product_description" required placeholder="Enter product name">

    <label for="list_price">List Price</label>
    <input type="number" id="list_price" name="list_price" required min="0" step="0.01" placeholder="Enter price">

    <label for="discount_percent">Discount Percent</label>
    <input type="number" id="discount_percent" name="discount_percent" required min="0" max="100" step="0.1" placeholder="Enter discount %">

    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>
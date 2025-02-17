-- tạo database--
create database if not exists ss5_view_index_store_procedure;
use ss5_view_index_store_procedure;
-- tạo bảng Products---
create table products(
	id int primary key auto_increment,
    productCode varchar(50),
    productName varchar(50),
    productPrice int,
    productAmount int ,
    productDescription varchar(50),
    productStatus enum('Còn hàng','Hết hàng') not null
);
-- thêm dữ liệu --
insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus)  
values  
('P001', 'Laptop Dell', 1500, 10, 'High-performance laptop', 'Còn hàng'),
('P002', 'iPhone 15', 1200, 5, 'Latest Apple smartphone', 'Còn hàng'),
('P003', 'Samsung Galaxy S24', 1100, 8, 'Newest Samsung flagship phone', 'Còn hàng'),
('P004', 'MacBook Pro M3', 2000, 6, 'Apple MacBook Pro with M3 chip', 'Còn hàng'),
('P005', 'Sony WH-1000XM5', 350, 15, 'Noise-canceling wireless headphones', 'Còn hàng'),
('P006', 'iPad Air 2024', 700, 12, 'Lightweight and powerful tablet', 'Còn hàng'),
('P007', 'Logitech MX Master 3', 100, 20, 'High-precision wireless mouse', 'Còn hàng');
-- truy vấn trước khi tạo index--
explain select * from products where productName = 'Laptop Dell' and productPrice = 1500;
-- tạo unique index ---
create unique index idx_productCode ON products (productCode);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)--
create index idx_productName_price on products(productName, productPrice);
-- truy vấn sau khi tạo index --
explain select * from products where productName = 'Laptop Dell' and productPrice = 1500;
-- tạo view --
create view product_view
as
select productCode, productName, productPrice, productStatus
from products;
-- truy vấn view --
select * from product_view;
-- sửa đổi view --
create or replace view product_view AS
SELECT productCode, productName, productPrice, productAmount, productStatus
FROM products;
-- xóa view --
drop view if exists product_view;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product--
DELIMITER //

CREATE PROCEDURE getAllProducts()
BEGIN
    SELECT * FROM products;
END //

DELIMITER ;
-- Tạo store procedure thêm một sản phẩm mới--
DELIMITER //

CREATE PROCEDURE addProduct(
    IN p_productCode VARCHAR(50),
    IN p_productName VARCHAR(50),
    IN p_productPrice INT,
    IN p_productAmount INT,
    IN p_productDescription VARCHAR(50),
    IN p_productStatus ENUM('Còn hàng', 'Hết hàng')
)
BEGIN
    INSERT INTO products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (p_productCode, p_productName, p_productPrice, p_productAmount, p_productDescription, p_productStatus);
END //

DELIMITER ;
-- Tạo store procedure sửa thông tin sản phẩm theo id--
DELIMITER //

CREATE PROCEDURE updateProduct(
    IN p_id INT,
    IN p_productCode VARCHAR(50),
    IN p_productName VARCHAR(50),
    IN p_productPrice INT,
    IN p_productAmount INT,
    IN p_productDescription VARCHAR(50),
    IN p_productStatus ENUM('Còn hàng', 'Hết hàng')
)
BEGIN
    UPDATE products
    SET productCode = p_productCode,
        productName = p_productName,
        productPrice = p_productPrice,
        productAmount = p_productAmount,
        productDescription = p_productDescription,
        productStatus = p_productStatus
    WHERE id = p_id;
END //

DELIMITER ;
-- Tạo store procedure xoá sản phẩm theo id --
DELIMITER $$

CREATE PROCEDURE deleteProduct(IN p_id INT)
BEGIN
    DELETE FROM products WHERE id = p_id;
END $$

DELIMITER ;




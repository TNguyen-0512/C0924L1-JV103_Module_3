-- tạo csdl---
create database if not exists quan_ly_sinh_vien;
use quan_ly_sinh_vien;
-- tạo table ---
create table Class(
	id int primary key auto_increment,
    `name` varchar(50) not null default("abc")
);
create table Teacher(
	id int primary key auto_increment,
    `name` varchar(50) not null default("abc"),
    age int(3)
);
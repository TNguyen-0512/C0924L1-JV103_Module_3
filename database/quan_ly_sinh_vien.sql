-- tạo csdl---
create database if not exists c0924L1;
use c0924L1;
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
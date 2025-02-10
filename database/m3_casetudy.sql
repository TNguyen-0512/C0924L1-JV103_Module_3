-- tạo csdl---
create database if not exists m3_casestudy;
use m3_casestudy;
-- tạo table vị trí ---
create table vi_tri(
	ma_vi_tri int primary key,
    ten_vi_tri varchar(50)
);
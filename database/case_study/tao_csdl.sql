-- tạo csdl---
Drop database if exists m3_casestudy;
create database m3_casestudy;
use m3_casestudy;
-- tạo table vị trí ---
create table vi_tri(
	ma_vi_tri int primary key auto_increment,
    ten_vi_tri varchar(45)
);
-- tạo bảng trình độ --
create table trinh_do(
	ma_trinh_do int primary key auto_increment,
    ten_trinh_do varchar(45)
);
-- tạo bảng bộ phận --
create table bo_phan(
	ma_bo_phan int primary key auto_increment,
    ten_bo_phan varchar(45)
);
-- tạo bảng nhân viên --
create table nhan_vien(
	ma_nhan_vien int primary key auto_increment,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    luong double,
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    ma_vi_tri int,
    ma_trinh_do int,
    ma_bo_phan int,
    foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
    foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
    foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);
-- tạo bảng loại khách--
create table loai_khach(
	ma_loai_khach int auto_increment primary key,
    ten_loai_khach varchar(45)
);
-- tạo bảng khách hàng--
create table khach_hang(
	ma_khach_hang int primary key auto_increment,
    ho_ten varchar(45),
    ngay_sinh date,
    gioi_tinh bit(1),
    so_cmnd varchar(45),
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    ma_loai_khach int,
    foreign key (ma_loai_khach) references loai_khach(ma_loai_khach) on delete cascade
);
-- tạo bảng kiểu thuế --
create table kieu_thue(
	ma_kieu_thue int primary key auto_increment,
    ten_kieu_thue varchar(45)
);
-- tạo bảng loại dịch vụ --
create table loai_dich_vu(
	ma_loai_dich_vu int primary key auto_increment,
    ten_loai_dich_vu varchar(45)
);
-- tạo bảng dịch vụ--
create table dich_vu(
	ma_dich_vu int primary key auto_increment,
    ten_dich_vu varchar(45),
    dien_tich int,
    chi_phi_thue double,
    so_nguoi_toi_da int,
    ma_kieu_thue int,
    ma_loai_dich_vu int,
    tieu_chuan_phong varchar(45),
    mo_ta_tien_nghi_khac varchar(45),
    dien_tich_ho_boi double,
    so_tang int,
    foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
    foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);
-- tạo bảng dịch vụ đi kèm--
create table dich_vu_di_kem(
	ma_dich_vu_di_kem int primary key auto_increment,
    ten_dich_vu_di_kem varchar(45),
    gia double,
    don_vi varchar(10),
    trang_thai varchar(45)
);
-- tạo bảng hợp đồng--
create table hop_dong(
	ma_hop_dong int primary key auto_increment,
    ngay_lam_hop_dong datetime,
    ngay_ket_thuc datetime,
    tien_dat_coc double,
    ma_nhan_vien int,
    ma_khach_hang int,
    ma_dich_vu int,
    foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
    foreign key (ma_khach_hang) references khach_hang(ma_khach_hang) on delete cascade,
    foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);
-- tạo bảng hợp đồng chi tiết--
create table hop_dong_chi_tiet(
	ma_hop_dong_chi_tiet int primary key auto_increment,
    ma_hop_dong int,
    ma_dich_vu_di_kem int,
    so_luong int,
    foreign key (ma_hop_dong) references hop_dong(ma_hop_dong) on delete cascade,
    foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

-- insert bảng vị trí --
insert into vi_tri(ten_vi_tri) 
values
	('Quản Lý'),('Nhân Viên');
-- insert bảng trình độ--
insert into trinh_do(ten_trinh_do)
values
	('Trung Cấp'),('Cao Đẳng'),('Đại Học'),('Sau Đại Học');
-- insert bảng bộ phận --
insert into bo_phan(ten_bo_phan)
values 
	('Sale-Marketing'),('Hành Chính'),('Phục Vụ'),('Quản Lý');
-- insert bảng nhân viên--
insert into nhan_vien (ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)  
values 
    ('Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),  
    ('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),  
    ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),  
    ('Võ Công Toàn', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),  
    ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),  
    ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),  
    ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),  
    ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),  
    ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),  
    ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
-- insert bảng loại khách--
insert into loai_khach(ten_loai_khach)
values
	('Diamond'),('Platinium'),('Gold'),('Sliver'),('Member');
-- insert bảng khách hàng--
insert into khach_hang (ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach)  
values
    ('Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),  
    ('Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),  
    ('Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),  
    ('Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),  
    ('Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),  
    ('Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),  
    ('Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),  
    ('Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),  
    ('Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),  
    ('Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);  
-- insert bảng kiểu thuế--
insert into kieu_thue(ten_kieu_thue)
values
	('year'),('month'),('day'),('hour');
-- insert loại dịch vụ--
insert into loai_dich_vu(ten_loai_dich_vu)
values
	('Villa'),('House'),('Room');
-- insert dịch vụ--
insert into dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu)  
values  
    ('Villa Beach Front', 25000, 10000000, 10, 'vip', 'Có hồ bơi', 500, 4, 3, 1),  
    ('House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, 3, 2, 2),  
    ('Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', null, null, 4, 3),  
    ('Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, 3, 1),  
    ('House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null, 2, 3, 2),  
    ('Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, 4, 3);  
-- insert dịch vụ đi kèm--
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai)  
values 
    ('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),  
    ('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),  
    ('Thuê xe đạp', 20000, 'chiếc', 'tốt'),  
    ('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),  
    ('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),  
    ('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');  
-- insert hợp đồng--
insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)  
values  
    ('2020-12-08', '2020-12-08', 0, 3, 1, 3),  
    ('2020-07-14', '2020-07-21', 200000, 7, 3, 1),  
    ('2021-03-15', '2021-03-17', 50000, 3, 4, 2),  
    ('2021-01-14', '2021-01-18', 100000, 7, 5, 5),  
    ('2021-07-14', '2021-07-15', 0, 7, 2, 6),  
    ('2021-06-01', '2021-06-03', 0, 7, 7, 6),  
    ('2021-09-02', '2021-09-05', 100000, 7, 4, 4),  
    ('2021-06-17', '2021-06-18', 150000, 3, 4, 1),  
    ('2020-11-19', '2020-11-19', 0, 3, 4, 3),  
    ('2021-04-12', '2021-04-14', 0, 10, 3, 5),  
    ('2021-04-25', '2021-04-25', 0, 2, 2, 1),  
    ('2021-05-25', '2021-05-27', 0, 7, 10, 1);  
-- insert hợp đồng chi tiết--
insert into hop_dong_chi_tiet (so_luong, ma_hop_dong, ma_dich_vu_di_kem)  
values 
    (5, 2, 4),  
    (8, 2, 5),  
    (15, 2, 6),  
    (1, 3, 1),  
    (11, 3, 2),  
    (1, 1, 3),  
    (2, 1, 2),  
    (2, 12, 2);  

-- câu 2--
select *  
from nhan_vien  
where (ho_ten like 'H%' OR ho_ten like 'T%' OR ho_ten like 'K%')  
and char_length(ho_ten) <= 15;
-- câu 3--
select *
from khach_hang
where timestampdiff(year, ngay_sinh, curdate()) between 18 and 50
And( dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');
-- câu 4--
select khach_hang.ma_khach_hang, khach_hang.ho_ten, COUNT(hop_dong.ma_hop_dong) as so_lan_dat_phong
from khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where loai_khach.ten_loai_khach = 'Diamond'
group by khach_hang.ma_khach_hang, khach_hang.ho_ten
order by so_lan_dat_phong asc;
-- câu 5 ---
select 
    kh.ma_khach_hang, 
    kh.ho_ten, 
    lk.ten_loai_khach, 
    hd.ma_hop_dong, 
    dv.ten_dich_vu, 
    hd.ngay_lam_hop_dong, 
    hd.ngay_ket_thuc, 
    (dv.chi_phi_thue + ifnull(sum(hdct.so_luong * dvdk.gia), 0)) as tong_tien
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, dv.chi_phi_thue
order by kh.ma_khach_hang;
-- câu 6 ---
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu not in (
    select distinct hd.ma_dich_vu
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = 2021
    and month(hd.ngay_lam_hop_dong) in (1, 2, 3)
);
-- câu 7 --
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu in (
    select distinct hd.ma_dich_vu
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = 2020
)
and dv.ma_dich_vu not in (
    select distinct hd.ma_dich_vu
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = 2021
);

-- câu 8--
-- dùng distinct--
select distinct ho_ten
from khach_hang;

-- dùng group by--
select ho_ten
from khach_hang
group by ho_ten;

-- dùng not exists--
select ho_ten 
from khach_hang kh1
where not exists (
    select 1 
    from khach_hang kh2 
    where kh1.ho_ten = kh2.ho_ten and kh1.ma_khach_hang > kh2.ma_khach_hang
);

-- câu 9---
select 
    month(ngay_lam_hop_dong) as thang, 
    count(distinct ma_khach_hang) as so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by thang;

-- câu 10 --
select 
    month(ngay_lam_hop_dong) as thang, 
    count(distinct ma_khach_hang) as so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by thang;


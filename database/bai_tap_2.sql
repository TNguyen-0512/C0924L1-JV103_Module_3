-- tạo cdsl--
create database if not exists bai_tap_2;
use bai_tap_2;
-- tạo vật tư--
create table VATTU(
	MaVTU int primary key,
    TenVTU varchar(50)
);
-- tạo phiếu xuất--
create table PHIEUXUAT(
	SoPX int primary key,
    NgayXuat date
);
-- tạo xuất vật tư--
create table XUAT_VTU(
	SoPX int,
    MaVTU int,
    DGXuat varchar(50),
    SLXuat int,
    primary key(SoPX, MaVTU),
    foreign key (SoPX) references PHIEUXUAT(SoPX),
    foreign key (MaVTU) references VATTU(MaVTU)
);
-- tạo phiếu nhập --
create table PHIEUNHAP(
	SoPN int primary key,
    NgayNhap date
);
-- tạo nhập vật tư --
create table NHAP_VTU(
	SoPN int,
    MaVTU int,
    DGNhap varchar(50),
    SLNhap int,
    primary key(SoPN, MaVTU),
	foreign key (SoPN) references PHIEUNHAP(SoPN),
    foreign key (MaVTU) references VATTU(MaVTU)
);
-- tạo nhà cung cấp --
create table NHACC(
	MaNCC int primary key,
    TenNCC varchar(50),
    DiaChi varchar(50)
);
create table SDT(
	SDTNCC varchar(10) primary key,
    MaNCC int,
    foreign key(MaNCC) references NHACC(MaNCC)
);
-- tạo đơn đặt hàng --
create table DONDH(
	SoDH int auto_increment primary key,
    NgayDH date,
    MaNCC int,
    foreign key(MaNCC) references NHACC(MaNCC)
);
-- tạo DDH_VTU---
create table DDH_VTU(
	MaVTU int,
    SoDH int,
    primary key(MaVTU, SoDH),
    foreign key (MaVTU) references VATTU(MaVTU),
    foreign key (SoDH) references DONDH(SoDH)
);
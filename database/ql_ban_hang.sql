-- tạo csdl--
create database if not exists ql_ban_hang;
use ql_ban_hang;
-- tạo bảng Customer--
create table Customer(
	cID int auto_increment primary key,
    cName varchar(50) not null default ("abc"),
    cAge int(3)
);
-- tạo bảng Order --
create table `Order`(
	oID int auto_increment primary key,
    cID int,
    oDate date,
    oTotalPrice int,
    foreign key (cID) references Customer(cID)
);
-- tạo bảng Product --
create table Product(
	pID int auto_increment primary key,
    pName varchar(50),
    pPrice int
);
-- tạo bảng OrderDetail--
create table OrderDetail(
	oID int,
    pID int,
    odQTY int,
    primary key(oID, pID),
    foreign key(oID) references `Order`(oID),
    foreign key(pID) references Product(pID)
);
use ql_ban_hang;
-- thêm vào bảng customer ---
insert into customer values 
	(1, 'Minh Quan', 10),
	(2, 'Ngoc Oanh', 20),
	(3, 'Hong Ha', 50);
-- thêm vào bảng order--
insert into `order` values
	(1, 1, '2006-3-21', null),
    (2, 2, '2006-3-23', null),
    (3, 1, '2006-3-16', null);
-- thêm vào bảng product --
insert into product values
	(1, 'May Giat', 3),
    (2, 'Tu Lanh', 5),
    (3, 'Dieu Hoa', 7),
    (4, 'Quat', 1),
    (5, 'Bep dien', 2);
-- thêm vào bảng orderdetail--
insert into orderdetail (oID, pID, odQTY) values
	(1, 1, 3),
    (1, 3, 7),
    (1, 4, 2),
    (2, 1, 1),
    (3, 1, 8),
    (2, 5, 4),
    (2, 3, 3);
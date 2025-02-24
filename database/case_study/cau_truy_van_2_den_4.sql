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
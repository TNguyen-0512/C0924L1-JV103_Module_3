package com.example.do_an_ca_nhan.model;

import java.sql.Timestamp;

public class HopDong {
    private int maHopDong;
    private Timestamp ngayLamHopDong;
    private Timestamp ngayKetThuc;
    private double tienDatCoc;
    private int maNhanVien;
    private int maKhachHang;
    private int maDichVu;

    public HopDong(int maHopDong, Timestamp ngayLamHopDong, Timestamp ngayKetThuc, double tienDatCoc, int maNhanVien, int maKhachHang, int maDichVu) {
        this.maHopDong = maHopDong;
        this.ngayLamHopDong = ngayLamHopDong;
        this.ngayKetThuc = ngayKetThuc;
        this.tienDatCoc = tienDatCoc;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.maDichVu = maDichVu;
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(int maHopDong) {
        this.maHopDong = maHopDong;
    }

    public Timestamp getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(Timestamp ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }
}

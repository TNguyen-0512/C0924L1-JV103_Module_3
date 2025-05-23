package com.example.do_an_ca_nhan.model;

import java.util.Date;

public class NhanVien {
    private int maNhanVien;
    private String hoTen;
    private Date ngaySinh;
    private String soCMND;
    private double luong;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private int maViTri;
    private int maTrinhDo;
    private int maBoPhan;



    public NhanVien(int maNhanVien, String hoTen, Date ngaySinh, String soCMND, double luong, String soDienThoai, String email, String diaChi, int maViTri, int maTrinhDo, int maBoPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.maViTri = maViTri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public NhanVien() {

    }


    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public java.sql.Date getNgaySinh() {
        return (java.sql.Date) ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }
}

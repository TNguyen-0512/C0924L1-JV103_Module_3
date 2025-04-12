package com.example.do_an_ca_nhan.model;

public class LoaiKhach {
    private int maLoaiKhach;
    private String tenLoaiKhach;

    public LoaiKhach(int maLoaiKhach, String tenLoaiKhach) {
        this.maLoaiKhach = maLoaiKhach;
        this.tenLoaiKhach = tenLoaiKhach;
    }

    public int getMaLoaiKhach() {
        return maLoaiKhach;
    }

    public void setMaLoaiKhach(int maLoaiKhach) {
        this.maLoaiKhach = maLoaiKhach;
    }

    public String getTenLoaiKhach() {
        return tenLoaiKhach;
    }

    public void setTenLoaiKhach(String tenLoaiKhach) {
        this.tenLoaiKhach = tenLoaiKhach;
    }
}

package com.example.do_an_ca_nhan.model;

public class LoaiDichVu {
    private int maLoaiDichVu;
    private String tenLoaiDichVu;

    public LoaiDichVu(int maLoaiDichVu, String tenLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public int getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(int maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }
}

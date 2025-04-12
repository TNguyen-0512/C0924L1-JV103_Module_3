package com.example.do_an_ca_nhan.model;

public class KieuThue {
    private int maKieuThue;
    private String tenKieuThue;

    public KieuThue(int maKieuThue, String tenKieuThue) {
        this.maKieuThue = maKieuThue;
        this.tenKieuThue = tenKieuThue;
    }

    public int getMaKieuThue() {
        return maKieuThue;
    }

    public void setMaKieuThue(int maKieuThue) {
        this.maKieuThue = maKieuThue;
    }

    public String getTenKieuThue() {
        return tenKieuThue;
    }

    public void setTenKieuThue(String tenKieuThue) {
        this.tenKieuThue = tenKieuThue;
    }
}

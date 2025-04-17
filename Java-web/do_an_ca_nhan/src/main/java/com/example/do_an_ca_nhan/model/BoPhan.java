package com.example.do_an_ca_nhan.model;

public class BoPhan {
    private int maBoPhan;
    private String tenBoPhan;

    public BoPhan(int maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }

    public BoPhan() {

    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
}

package com.example.do_an_ca_nhan.model;

public class TrinhDo {
    private int maTrinhDo;
    private String tenTrinhDo;

    public TrinhDo(int maTrinhDo, String tenTrinhDo) {
        this.maTrinhDo = maTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
    }

    public TrinhDo() {

    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }
}

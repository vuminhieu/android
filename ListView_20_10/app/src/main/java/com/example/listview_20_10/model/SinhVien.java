package com.example.listview_20_10.model;

public class SinhVien {
    private String mTen;
    private String mDiachi;
    private String mSDT;

    public SinhVien() {
    }

    public SinhVien(String mTen, String mDiachi, String mSDT) {
        this.mTen = mTen;
        this.mDiachi = mDiachi;
        this.mSDT = mSDT;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public String getmDiachi() {
        return mDiachi;
    }

    public void setmDiachi(String mDiachi) {
        this.mDiachi = mDiachi;
    }

    public String getmSDT() {
        return mSDT;
    }

    public void setmSDT(String mSDT) {
        this.mSDT = mSDT;
    }
}

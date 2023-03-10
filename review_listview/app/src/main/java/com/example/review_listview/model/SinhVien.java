package com.example.review_listview.model;

public class SinhVien {
    private String mTen;
    private String mDiaChi;
    private String mTuoi;

    public SinhVien(String mTen, String mDiaChi, String mTuoi) {
        this.mTen = mTen;
        this.mDiaChi = mDiaChi;
        this.mTuoi = mTuoi;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public String getmDiaChi() {
        return mDiaChi;
    }

    public void setmDiaChi(String mDiaChi) {
        this.mDiaChi = mDiaChi;
    }

    public String getmTuoi() {
        return mTuoi;
    }

    public void setmTuoi(String mTuoi) {
        this.mTuoi = mTuoi;
    }

}

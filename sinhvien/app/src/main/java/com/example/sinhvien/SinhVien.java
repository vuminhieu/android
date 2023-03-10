package com.example.sinhvien;

public class SinhVien {
    private String HoTen;
    private Integer NamSinh;

    public SinhVien(String hoTen, Integer namSinh) {
        HoTen = hoTen;
        NamSinh = namSinh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public Integer getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(Integer namSinh) {
        NamSinh = namSinh;
    }

}

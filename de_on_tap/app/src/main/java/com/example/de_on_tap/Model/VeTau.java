package com.example.de_on_tap.Model;

public class VeTau {
    private int Id;
    private String GaDi;
    private String GaDen;
    private String DonGia;
    private String KhuHoi;

    public VeTau(int id, String gaDi, String gaDen, String donGia, String khuHoi) {
        Id = id;
        GaDi = gaDi;
        GaDen = gaDen;
        DonGia = donGia;
        KhuHoi = khuHoi;
    }

    public VeTau(String gaDi, String gaDen, String donGia, String khuHoi) {
        GaDi = gaDi;
        GaDen = gaDen;
        DonGia = donGia;
        KhuHoi = khuHoi;
    }

    public VeTau() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGaDi() {
        return GaDi;
    }

    public void setGaDi(String gaDi) {
        GaDi = gaDi;
    }

    public String getGaDen() {
        return GaDen;
    }

    public void setGaDen(String gaDen) {
        GaDen = gaDen;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String donGia) {
        DonGia = donGia;
    }

    public String getKhuHoi() {
        return KhuHoi;
    }

    public void setKhuHoi(String khuHoi) {
        KhuHoi = khuHoi;
    }
}

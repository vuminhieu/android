package com.example.code_mau;


public class VeTau  implements  Comparable<VeTau> {
    private int Ma;
    private String GaDi;
    private String GaDen;
    private float DonGia;
    private boolean KhuHoi;

    public VeTau(int ma, String gaDi, String gaDen, float donGia, boolean khuHoi) {
        Ma = ma;
        GaDi = gaDi;
        GaDen = gaDen;
        KhuHoi = khuHoi;
        if(KhuHoi == true)
            DonGia = (float) (donGia*2*0.95);
        else
            DonGia = donGia;
    }

    public VeTau() {
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int ma) {
        Ma = ma;
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

    public float getDonGia() {
        return this.DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public boolean isKhuHoi() {
        return KhuHoi;
    }

    public void setKhuHoi(boolean khuHoi) {
        KhuHoi = khuHoi;
    }

    @Override
    public int compareTo(VeTau o) {
        if(this.getGaDen().compareTo(o.getGaDen())>0)
            return 1;
        if(this.getGaDen().compareTo(o.getGaDen())<0)
            return -1;
        return 0;
    }


}


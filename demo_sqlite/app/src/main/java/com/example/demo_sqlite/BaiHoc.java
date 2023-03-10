package com.example.demo_sqlite;

public class BaiHoc {
    private int id;
    private String tenbai;

    public BaiHoc(int id, String tenbai) {
        this.id = id;
        this.tenbai = tenbai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenbai() {
        return tenbai;
    }

    public void setTenbai(String tenbai) {
        this.tenbai = tenbai;
    }
}

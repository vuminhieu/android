package com.example.baikiemtragiuaki;

public class CaSi {
    private String mid;
    private String mName;
    private String mSinger;
    private String mTime;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSinger() {
        return mSinger;
    }

    public void setmSinger(String mSinger) {
        this.mSinger = mSinger;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public CaSi(String mid, String mName, String mSinger, String mTime) {
        this.mid = mid;
        this.mName = mName;
        this.mSinger = mSinger;
        this.mTime = mTime;
    }
    public CaSi( String mName, String mSinger, String mTime) {
        this.mName = mName;
        this.mSinger = mSinger;
        this.mTime = mTime;
    }
}

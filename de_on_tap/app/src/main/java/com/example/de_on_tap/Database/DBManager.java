package com.example.de_on_tap.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.de_on_tap.Model.VeTau;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "vetaus_manager";
    private static final String TABLE_NAME = "vetaus";
    private static final String ID = "id";
    private static final String GADI = "gadi";
    private static final String GADEN = "gaden";
    private static final String GIA = "gia";
    private static final String KHUHOI = "khuhoi";
    private static int VERSION = 1;

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private  String SQLQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GADI + " TEXT, " +
            GADEN + " TEXT, " +
            GIA + " TEXT, " +
            KHUHOI + " TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // lay tat ca cac du lieu tu database len listview
    public List<VeTau> GetAllVeTau() {
        List<VeTau> veTaulist = new ArrayList<>();
        String AddingVeTau = "INSERT INTO vetaus VALUES (null, '" + "Thai Nguyen" + "', '" + "Thai Binh" + "', '" + "300000" + "', '" + "abc" + "')";
        String selectSQL = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectSQL, null);
        if (cursor.moveToFirst()) {
            do {
                VeTau veTau = new VeTau();
                veTau.setId(cursor.getInt(0));
                veTau.setGaDi(cursor.getString(1));
                veTau.setGaDen(cursor.getString(2));
                veTau.setDonGia(cursor.getString(3));
                veTau.setKhuHoi(cursor.getString(4));
                veTaulist.add(veTau);
            }
            while (cursor.moveToNext());
        }
        db.close();
        return veTaulist;
    }

    public int UpdateVeTau(VeTau veTau) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GADI, veTau.getGaDi());
        contentValues.put(GADEN, veTau.getGaDen());
        contentValues.put(GIA, veTau.getDonGia());
        contentValues.put(KHUHOI, veTau.getKhuHoi());
        String where = ID + " = " + veTau.getId();
        return db.update(TABLE_NAME,contentValues,where,null);
    }

    public int Delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = ID + " = " + id;
        return db.delete(TABLE_NAME,where,null);
    }
}

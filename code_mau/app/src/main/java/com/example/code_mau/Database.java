package com.example.code_mau;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_vetau";
    private static final String TABLE_NAME = "Vetau";
    private static final String MA = "MA";
    private static final String GADI = "GADI";
    private static final String GADEN = "GADEN";
    private static final String DONGIA = "DONGIA";
    private static final String KHUHOI = "KHUHOI";

    private Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                MA + " integer primary key AUTOINCREMENT, " +
                GADI + " TEXT, " +
                GADEN + " TEXT, " +
                DONGIA + " double, " +
                KHUHOI + " int)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void xoaToanBo() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from Vetau");
    }


    //Add new a student
    public void addSP(VeTau vetau) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GADI, vetau.getGaDi());
        values.put(GADEN, vetau.getGaDen());
        values.put(DONGIA, vetau.getDonGia());
        if (vetau.isKhuHoi() == true)
            values.put(KHUHOI, 1);
        else
            values.put(KHUHOI, 0);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public void updateVetau(VeTau vetau) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MA, vetau.getMa());
        values.put(GADI, vetau.getGaDi());
        values.put(GADEN, vetau.getGaDen());
        values.put(DONGIA, vetau.getDonGia());
        if (vetau.isKhuHoi() == true)
            values.put(KHUHOI, 1);
        else
            values.put(KHUHOI, 0);

        db.update(TABLE_NAME, values, "MA = ?", new String[]{String.valueOf(vetau.getMa())});

        db.close();
    }


    public void QueryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void DeleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from Vetau where MA = "+id);
    }

    public List<VeTau> getAll() {
        List<VeTau> list = new ArrayList<VeTau>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                VeTau vetau = new VeTau();
                vetau.setMa(cursor.getInt(0));
                vetau.setGaDi(cursor.getString(1));
                vetau.setGaDen(cursor.getString(2));
                vetau.setDonGia(cursor.getFloat(3));
                if (cursor.getInt(4) == 1)
                    vetau.setKhuHoi(true);
                else
                    vetau.setKhuHoi(false);
                list.add(vetau);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}

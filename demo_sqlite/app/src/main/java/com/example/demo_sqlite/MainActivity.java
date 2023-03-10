package com.example.demo_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BaiHocHelper baiHocHelper;
    ListView lv;
    ArrayList<BaiHoc> arrayList;
    BaiHocAdapter adapter;
    Button button_them;
    EditText editText_ten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        button_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bai = editText_ten.getText().toString().trim();
                if (TextUtils.isEmpty(bai)) {
                    Toast.makeText(MainActivity.this, "Vui Long nhap du lieu", Toast.LENGTH_SHORT).show();
                    return;
                }
                baiHocHelper.QueryData("INSERT INTO NoiDung VALUES (null, '" + bai + "')");
                actionGetData();
                editText_ten.setText("");
            }
        });

        arrayList = new ArrayList<>();
        adapter = new BaiHocAdapter(this, R.layout.dong_noi_dung, arrayList);
        lv.setAdapter(adapter);

        // Tao database
        baiHocHelper = new BaiHocHelper(this, "BaiHoc.sqlite", null,1);

        // tao bang database
        baiHocHelper.QueryData("CREATE TABLE IF NOT EXISTS NoiDung(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenNoiDung VARCHAR(200))");

        // them du lieu
//        baiHocHelper.QueryData("INSERT INTO NoiDung VALUES (null, 'Bai 1: Gioi Thieu Android')");
//        baiHocHelper.QueryData("INSERT INTO NoiDung VALUES (null, 'Bai 2: Cai Dat Moi Truong')");

        //truy xuat du lieu
        actionGetData();

    }

    private void actionGetData() {
        Cursor dataBaiHoc = baiHocHelper.GetData("SELECT * FROM NoiDung");
        arrayList.clear();
        while (dataBaiHoc.moveToNext()) {
            String ten  = dataBaiHoc.getString(1);
            int id = dataBaiHoc.getInt(0);
//            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
            arrayList.add(new BaiHoc(id, ten));
            adapter.notifyDataSetChanged();
        }
    }

    private void mapping() {
        lv = (ListView) findViewById(R.id.lv_noi_dung);
        button_them = (Button) findViewById(R.id.btn_them);
        editText_ten = (EditText) findViewById(R.id.edt_ten);
    }
}
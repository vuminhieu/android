package com.example.a05_10_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class home_page extends AppCompatActivity {
    TextView textView_show_email;
    ListView lv;
    ArrayList<SinhVien> arrayList;
    SinhVienAdapter adapter;

    public void mapping() {
        textView_show_email = (TextView) findViewById(R.id.tv_show_email);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mapping();
        Intent intent = getIntent();
        String email = intent.getStringExtra("Email");
        textView_show_email.setText("Hello" + email);

        lv = (ListView) findViewById(R.id.lv_student);
        arrayList = new ArrayList<>();

        arrayList.add(new SinhVien("Vu Minh Hieu", "Thai Binh" , 21 ));
        adapter = new SinhVienAdapter(this , R.layout.activity_list_sinh_vien,arrayList);
        lv.setAdapter(adapter);

    }
}
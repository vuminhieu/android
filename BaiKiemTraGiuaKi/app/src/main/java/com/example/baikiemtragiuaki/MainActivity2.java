package com.example.baikiemtragiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewTruyen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewTruyen = (TextView) findViewById(R.id.tv_truyen);
        Bundle bundle = getIntent().getBundleExtra("MyBundle");
        if (bundle != null) {
            String ten = bundle.getString("ten");
            String id = bundle.getString("id");
            String casi = bundle.getString("casi");
            String thoigian = bundle.getString("thoigian");
            textViewTruyen.setText("ID:  "+ id + "Tên Bài" + ten + "Tên Ca Sĩ" + casi + "Thời Gian" + thoigian);
        }
    }
}
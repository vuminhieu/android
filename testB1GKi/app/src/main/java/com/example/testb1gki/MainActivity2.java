package com.example.testb1gki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextTen, editTextCasi, editTextId, editTextThoiGian;
    Button buttonLuu, buttonTruyen;



    private  void  mapping() {
        editTextTen = (EditText) findViewById(R.id.edt_ten);
        editTextId = (EditText) findViewById(R.id.edt_id);
        editTextCasi = (EditText) findViewById(R.id.edt_ca_si);
        editTextThoiGian = (EditText) findViewById(R.id.edt_time);
        buttonLuu = (Button) findViewById(R.id.btn_them);
        buttonTruyen = (Button) findViewById(R.id.btn_truyen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        mapping();

//        buttonLuu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
//
//                intent.putExtra("id", editTextId.getText().toString());
//                intent.putExtra("ten", editTextTen.getText().toString());
//                intent.putExtra("casi", editTextCasi.getText().toString());
//                intent.putExtra("thoigian", editTextThoiGian.getText().toString());
//
//                setResult(33, intent);
//                finish();
//
//            }
//        });
    }
}
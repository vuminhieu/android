package com.example.result_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button buttonBinhPhuong, buttonNhanDoi;
    TextView textViewNhan;
    public static final int My_code_result =33;
    public static final int My_code_result2 = 34;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonBinhPhuong = (Button) findViewById(R.id.btn_binh_phuong);
        buttonNhanDoi = (Button) findViewById(R.id.btn_nhan_doi);
        textViewNhan = (TextView) findViewById(R.id.tv_nhan);

        Intent intent = getIntent();
        int a = intent.getIntExtra("so_a", 0);
        textViewNhan.setText(a + "");

        buttonBinhPhuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("binh_phuong" , a * a);
                setResult(My_code_result, intent);
                finish();
            }
        });

        buttonNhanDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("nhan_doi" , 2 * a);
                setResult(My_code_result2, intent);
                finish();
            }
        });

    }
}
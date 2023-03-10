package com.example.demoresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewNhan;
    Button buttonKetQua, buttonTich;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewNhan = (TextView) findViewById(R.id.textView_truyen);
        buttonKetQua = (Button) findViewById(R.id.btn_tinh);
        buttonTich = (Button) findViewById(R.id.button);

        Intent intent = getIntent();
        int a = intent.getIntExtra("soa", 0);
        int b = intent.getIntExtra("sob", 0);
        textViewNhan.setText("So a :   " + a + "   So b:   " + b);

        buttonKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("kq", a + b);
                setResult(33, intent);
                finish();
            }
        });

        buttonTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tich", a * b);
                setResult(88, intent);
                finish();
            }
        });


    }
}
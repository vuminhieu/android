package com.example.a10_10_22_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button buttonXuly;
    TextView textViewNhan;
    int a, b;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Initwidgets1();

        buttonXuly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = a + b;
                // gan vao intent
                intent.putExtra("tong", c);
                // tra ket qua ve
                setResult(33, intent);
                // phai dong Mh2 thi ben Main moi nhan duoc
                // Main nhan o foreground lifetime
                finish();
            }
        });
    }

    private void Initwidgets1() {
        buttonXuly = (Button) findViewById(R.id.buttonXuly);
        textViewNhan = (TextView) findViewById(R.id.textViewNhan);
        intent = getIntent();
        a = intent.getIntExtra("a", 0);
        b = intent.getIntExtra("b", 0);
        textViewNhan.setText("a = " + a + "b = " + b);
    }
}
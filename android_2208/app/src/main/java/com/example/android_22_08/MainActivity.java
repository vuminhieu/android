package com.example.android_22_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3;
    Button button;
    EditText editText1, editText2;

    public void mapping() {
        textView1 = (TextView) findViewById(R.id.txt1);
        textView2 = (TextView) findViewById(R.id.txt2);
        textView3 = (TextView) findViewById(R.id.txt3);
        button = (Button) findViewById(R.id.btn1);
        editText1 = (EditText) findViewById((R.id.edt1));
        editText2 = (EditText) findViewById((R.id.edt2));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText1.getText().toString();
                String b = editText2.getText().toString();
                int so1 = Integer.parseInt(a);
                int so2 = Integer.parseInt(b);
                int c = so1 + so2;
                String kq = String.valueOf(c);
                textView3.setText(kq);
            }
        });
    }
}
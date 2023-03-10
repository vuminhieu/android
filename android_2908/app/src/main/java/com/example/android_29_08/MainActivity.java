package com.example.android_29_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    Button button;
    EditText editText1, editText2;
    CheckBox tinhbot, protein, vatamin;
    RadioButton ankieng,khongankieng;

    public void mapping() {
        textView1 = (TextView) findViewById(R.id.txt1);
        textView2 = (TextView) findViewById(R.id.txt2);
        textView3 = (TextView) findViewById(R.id.txt3);
        textView4 = (TextView) findViewById(R.id.txt4);
        textView5 = (TextView) findViewById(R.id.txt5);
        textView6 = (TextView) findViewById(R.id.txt6);
        textView7 = (TextView) findViewById(R.id.txt7);
        button = (Button) findViewById(R.id.btn1);
        button = (Button) findViewById(R.id.btn2);
        editText1 = (EditText) findViewById((R.id.edt1));
        editText2 = (EditText) findViewById((R.id.edt2));
        tinhbot = (CheckBox) findViewById(R.id.ck1);
        protein = (CheckBox) findViewById(R.id.ck2);
        vatamin = (CheckBox) findViewById(R.id.ck3);
        ankieng = (RadioButton) findViewById(R.id.rdo1);
        khongankieng = (RadioButton) findViewById(R.id.rdo2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText1.getText().toString();
                String b = editText2.getText().toString();
                float cannang = Float.parseFloat(a);
                float chieucao = Float.parseFloat(b);
                float c = (cannang / (chieucao* chieucao)) ;
                String kq = String.valueOf(c);
                textView3.setText(kq);
                String tinhtrang;
                if (c < 15 ) {
                    tinhtrang = "sieu gay";
                }
                else if (c < 16) {
                    tinhtrang = "hoi gay";
                }
                else if (c < 18.5) {
                    tinhtrang = "tinh trang gay";
                }
                else if (c < 25) {
                    tinhtrang = "tinh trang binh thuong";
                }
                else {
                    tinhtrang = "qua beo";
                }
                textView5.setText(tinhtrang);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1;
                if(ankieng.isChecked()) {
                    str1 = ankieng.getText().toString();
                    textView6.setText(str1);
                }
                if (khongankieng.isChecked()) {
                    str1 = khongankieng.getText().toString();
                    textView6.setText(str1);
                }
            }
        });
    }
}
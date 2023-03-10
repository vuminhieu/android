package com.example.listview_15_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView_noi_dung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView_noi_dung = (TextView) findViewById(R.id.textView_Content);
        Bundle bundle = getIntent().getBundleExtra("MyBundle");
        if (bundle != null) {
            String hoten = bundle.getString("Ten");
            String gioitinh = bundle.getString("GioiTinh");
            String quoctich = bundle.getString("QuocTich");
            String sothich = bundle.getString("SoThich");
            textView_noi_dung.setText("Ho ten: " + hoten + "\n" +
                    "Gioi tinh: " + gioitinh +  "\n" +
                    "Quoc tich: " + quoctich + "\n" +
                    "So thich: " + sothich);
        }
    }
}
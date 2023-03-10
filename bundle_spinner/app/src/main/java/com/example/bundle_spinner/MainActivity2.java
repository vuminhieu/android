package com.example.bundle_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewTen, textViewGioiTinh, textViewSoThich, textViewTinh;

    private void mapping() {
        textViewTen = (TextView) findViewById(R.id.tv_ten);
        textViewGioiTinh = (TextView) findViewById(R.id.tv_gioi_tinh);
        textViewSoThich = (TextView) findViewById(R.id.tv_so_thich);
        textViewTinh = (TextView) findViewById(R.id.tv_tinh);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mapping();
        Bundle bundle = getIntent().getBundleExtra("MyBundle");
        if (bundle != null) {
            String ten = bundle.getString("ten");
            String GioiTinh = bundle.getString("gioi_tinh");
            String SoThich = bundle.getString("so_thich");
            String Tinh = bundle.getString("tinh_thanh");

            textViewTen.setText("Ho ten " + ten);
            textViewTinh.setText("Thanh Pho" + Tinh);
            textViewSoThich.setText("So thich" + SoThich);
            textViewGioiTinh.setText("Gioi Tinh" + GioiTinh);
        }
    }
}
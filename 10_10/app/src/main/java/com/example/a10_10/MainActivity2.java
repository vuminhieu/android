package com.example.a10_10;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editTextKq = (EditText) findViewById(R.id.editTextKq);
        Bundle bundle = getIntent().getBundleExtra("mybundle");
        if (bundle !=null){
            String hoten = bundle.getString("hoten");
            String ngaysinh = bundle.getString("ngaysinh");
            String gioitinh = bundle.getString("gioitinh");
            String quoctich = bundle.getString("quoctich");
            String sothich = bundle.getString("sothich");
            editTextKq.setText("Ho ten: " + hoten + "\n" +
                    "Ngay sinh: " + ngaysinh + "\n" +
                    "Gioi tinh: " + gioitinh +  "\n" +
                    "Quoc tich: " + quoctich + "\n" +
                    "So thich: " + sothich);
        }
    }
}

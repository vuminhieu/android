package com.example.testb1gki;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewDS;
    Button buttonThem;
    CustomAdapter customAdapter;
    ArrayList<CaSi> caSiArr;

    private void mapping() {
        buttonThem = (Button) findViewById(R.id.btn_them);
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 33) {
//            String id = data.getStringExtra("id");
//            String ten = data.getStringExtra("ten");
//            String casi = data.getStringExtra("casi");
//            String thoigian = data.getStringExtra("thoigian");
//            caSiArr.add(new CaSi(ten,casi,thoigian));
//            customAdapter.notifyDataSetChanged();
//        }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        caSiArr = new ArrayList<>();
        caSiArr.add(new CaSi("PHÚT CUỐI", "BẰNG KIỀU", "3:11"));
        customAdapter = new CustomAdapter(this, R.layout.dong_bai_hat,caSiArr);
        listViewDS.setAdapter(customAdapter);


        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, 99);
            }
        });
    }



}
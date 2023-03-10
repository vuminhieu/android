package com.example.baikiemtragiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextTen, editTextCasi, editTextId, editTextThoiGian;
    Button buttonThem, buttonTruyen;
    ListView listViewDS;
    CustomAdapter customAdapter;
    ArrayList<CaSi> caSiArr;

    private  void  mapping() {
        editTextTen = (EditText) findViewById(R.id.edt_ten);
        editTextId = (EditText) findViewById(R.id.edt_id);
        editTextCasi = (EditText) findViewById(R.id.edt_ca_si);
        editTextThoiGian = (EditText) findViewById(R.id.edt_time);
        listViewDS = (ListView) findViewById(R.id.lv_danh_sach);
        buttonThem = (Button) findViewById(R.id.btn_them);
        buttonTruyen = (Button) findViewById(R.id.btn_truyen);
    }

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
                String ten = editTextTen.getText().toString();
                String casi = editTextCasi.getText().toString();
                String thoigian = editTextThoiGian.getText().toString();
                if(TextUtils.isEmpty(ten) || TextUtils.isEmpty(casi) || TextUtils.isEmpty(thoigian)) {
                    Toast.makeText(MainActivity.this, "Vui Long Nhap day du thong Tin", Toast.LENGTH_SHORT).show();
                }
                caSiArr.add(new CaSi(ten,casi,thoigian));
                customAdapter.notifyDataSetChanged();
                editTextId.setText("");
                editTextTen.setText("");
                editTextThoiGian.setText("");
                editTextCasi.setText("");
            }
        });

        buttonTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", editTextId.getText().toString());
                bundle.putString("ten", editTextTen.getText().toString());
                bundle.putString("casi", editTextCasi.getText().toString());
                bundle.putString("thoigian", editTextThoiGian.getText().toString());

                intent.putExtra("MyBundle", bundle);
                startActivity(intent);

            }
        });



        listViewDS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editTextTen.setText(caSiArr.get(position).getmName());
                editTextThoiGian.setText(caSiArr.get(position).getmTime());
                editTextCasi.setText(caSiArr.get(position).getmSinger());
            }
        });
    }
}
package com.example.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<SinhVien> arrayList;
    SinhVienAdapter adapter;
    EditText editTextHoten, editTextNamsinh;
    Button buttonAdd, btnCapNhat;
    Integer vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidgets();
        lv = (ListView) findViewById(R.id.list_View_SinhVien);
        arrayList = new ArrayList<>();

        arrayList.add(new SinhVien("VietNam", 2001));
        adapter = new SinhVienAdapter(this, R.layout.dong_sinh_vien, arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = arrayList.get(i).getHoTen() + "-" + arrayList.get(i).getNamSinh();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                editTextHoten.setText(arrayList.get(i).getHoTen().toString());
                editTextNamsinh.setText(arrayList.get(i).getNamSinh().toString());
                vitri = i;

            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextHoten.getText().toString().trim().equals("") && !editTextNamsinh.getText().toString().trim().equals("")) {
                    arrayList.add(new SinhVien(editTextHoten.getText().toString().trim(),
                            Integer.parseInt(editTextNamsinh.getText().toString().trim())));
                    adapter.notifyDataSetChanged();
                    editTextHoten.setText("");
                    editTextNamsinh.setText("");
                }
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                arrayList.set(vitri, editTextHoten.getText().toString());
//                arrayList.set(vitri, editTextNamsinh.getText().toString());
                arrayList.get(vitri).setHoTen(editTextHoten.getText().toString()) ;
                arrayList.get(vitri).setNamSinh(Integer.parseInt(editTextNamsinh.getText().toString()));
                adapter.notifyDataSetChanged();
                adapter.notifyDataSetChanged();
                editTextHoten.setText("");
                editTextNamsinh.setText("");
                }
        });


    }


    private void InitWidgets() {
        editTextHoten = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextNamsinh = (EditText) findViewById(R.id.editTextTextPersonYear);
        buttonAdd = (Button) findViewById(R.id.button_add);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
    }
}

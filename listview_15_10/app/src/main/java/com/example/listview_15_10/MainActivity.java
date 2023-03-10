package com.example.listview_15_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SinhVien> arrayList = new ArrayList<SinhVien>();
    SinhVienAdapter adapter_list_sinh_vien;
    ListView listViewDanhSach;
    EditText editText_Ten;
    RadioButton radioButton_Nam, radioButton_Nu;
    Spinner spinner_Quoc_Tich;
    CheckBox checkBox_Bong_Da, checkBox_Cau_Long;
    Button button_truyen, button_them, button_sua, button_xoa;
    String quoc_tich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        ArrayList<String> qt = new ArrayList<String>();
        qt.add("Việt Nam");
        qt.add("Trung Quốc");
        qt.add("Mỹ");
        qt.add("Anh");
        qt.add("Liên Xô");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, qt);
        spinner_Quoc_Tich.setAdapter(adapter);

        //button truyen
        button_truyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("Ten", editText_Ten.getText().toString());
                if (radioButton_Nam.isChecked()) {
                    bundle.putString("GioiTinh", radioButton_Nam.getText().toString());
                }
                if (radioButton_Nu.isChecked()) {
                    bundle.putString("GioiTinh", radioButton_Nu.getText().toString());
                }
                spinner_Quoc_Tich.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        quoc_tich = qt.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                bundle.putString("QuocTich", quoc_tich);
                String so_thich = "";
                if (checkBox_Bong_Da.isChecked()) {
                    so_thich = so_thich + checkBox_Bong_Da.getText().toString();
                }
                if (checkBox_Cau_Long.isChecked()) {
                    so_thich = so_thich + checkBox_Cau_Long.getText().toString();
                }
                bundle.putString("SoThich", so_thich);

                intent.putExtra("MyBundle", bundle);
                startActivity(intent);
            }
        });

        button_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new SinhVien(editText_Ten.getText().toString().trim()));
                adapter_list_sinh_vien.notifyDataSetChanged();
                editText_Ten.setText("");
            }
        });


    }

    private void mapping() {
        listViewDanhSach = (ListView) findViewById(R.id.listview);
        editText_Ten = (EditText) findViewById(R.id.edt_Name);
        radioButton_Nam = (RadioButton) findViewById(R.id.radioButtonNam);
        radioButton_Nu = (RadioButton) findViewById(R.id.radioButtonNu);
        spinner_Quoc_Tich = (Spinner) findViewById(R.id.spinner_Quoc_tich);
        checkBox_Bong_Da = (CheckBox) findViewById(R.id.checkBox_Bong_Da);
        checkBox_Cau_Long = (CheckBox) findViewById(R.id.checkBox_Cau_Long);
        button_truyen = (Button) findViewById(R.id.button_truyen);
        button_them = (Button) findViewById(R.id.button_them);
        button_sua = (Button) findViewById(R.id.button_sua);
        button_xoa = (Button) findViewById(R.id.button_xoa);

    }
}
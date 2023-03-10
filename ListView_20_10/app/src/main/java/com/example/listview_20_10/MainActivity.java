package com.example.listview_20_10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview_20_10.adapter.SinhVienAdapter;
import com.example.listview_20_10.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextTen, editTextDiaChi, editTextSDT, editTextTimKiem;
    Button buttonThem, buttonSua, buttonXoa, buttonTimKiem;
    ListView listViewSinhVien;
    ArrayList<SinhVien> arrSinhVien;
    SinhVienAdapter sinhVienAdapter;
    private int vitri;

    private void mapping() {
        editTextTen = (EditText) findViewById(R.id.edt_ten);
        editTextDiaChi = (EditText) findViewById(R.id.edt_dia_chi);
        editTextSDT = (EditText) findViewById(R.id.edt_so_dt);
        editTextTimKiem = (EditText) findViewById(R.id.edt_timkiem);
        buttonThem = (Button) findViewById(R.id.btn_them);
        buttonTimKiem = (Button) findViewById(R.id.btn_timkiem);
        buttonSua = (Button) findViewById(R.id.button_sua);
        buttonXoa = (Button) findViewById(R.id.btn_xoa);
        listViewSinhVien = (ListView) findViewById(R.id.lv_sinhvien);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        arrSinhVien = new ArrayList<SinhVien>();
        sinhVienAdapter = new SinhVienAdapter(this, R.layout.item_sinh_vien, arrSinhVien);
        arrSinhVien.add(new SinhVien("Hieu", "Thai Binh", "03432234"));
        listViewSinhVien.setAdapter(sinhVienAdapter);

        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTextTen.getText().toString().trim();
                String diachi = editTextDiaChi.getText().toString().trim();
                String sdt = editTextSDT.getText().toString().trim();
                if (TextUtils.isEmpty(ten) || TextUtils.isEmpty(diachi) || TextUtils.isEmpty(sdt)) {
                    Toast.makeText(MainActivity.this, "Vui Long nhap du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    arrSinhVien.add((new SinhVien(ten, diachi, sdt)));
                    sinhVienAdapter.notifyDataSetChanged();
                    editTextTen.setText("");
                    editTextDiaChi.setText("");
                    editTextSDT.setText("");
                }
            }
        });

        listViewSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                editTextTen.setText(arrSinhVien.get(position).getmTen());
                editTextDiaChi.setText(arrSinhVien.get(position).getmDiachi());
                editTextSDT.setText(arrSinhVien.get(position).getmSDT());
            }
        });

        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xacnhanxoa();
            }
        });

        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrSinhVien.get(vitri).setmTen(editTextTen.getText().toString());
                arrSinhVien.get(vitri).setmDiachi(editTextDiaChi.getText().toString());
                arrSinhVien.get(vitri).setmSDT(editTextSDT.getText().toString());
                sinhVienAdapter.notifyDataSetChanged();
            }
        });

    }

    private void xacnhanxoa() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thong bao");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Co chac chan xoa khong");
        alertDialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrSinhVien.remove(vitri);
                sinhVienAdapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}
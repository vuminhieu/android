package com.example.review_listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.review_listview.adapter.CustomAdapter;
import com.example.review_listview.model.SinhVien;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button buttonThem, buttonSua, buttonXoa;
    ListView listViewSinhVien;
    EditText editTextTen, editTextDiaChi, editTextTuoi,editTextTimKiem;
    ArrayList<SinhVien> arrSinhVien;
    CustomAdapter sinhVienAdapter;
    private int vitri;

    private SearchView searchView;



    private void mapping() {
        buttonThem = (Button) findViewById(R.id.btn_them);
        buttonSua = (Button) findViewById(R.id.btn_sua);
        buttonXoa = (Button) findViewById(R.id.btn_xoa);
        listViewSinhVien = (ListView) findViewById(R.id.lv_sinh_vien);
        editTextTen = (EditText) findViewById(R.id.edt_ten);
        editTextTimKiem = (EditText) findViewById(R.id.edt_timkiem);
        editTextDiaChi = (EditText) findViewById(R.id.edt_diachi);
        editTextTuoi = (EditText) findViewById(R.id.edt_tuoi);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        arrSinhVien = new ArrayList<SinhVien>();
        arrSinhVien.add(new SinhVien("Hieu", "Thai Binh", "34"));
        arrSinhVien.add(new SinhVien("Abc", "Thai Binh", "34"));
        arrSinhVien.add(new SinhVien("dáđ", "Thai Binh", "34"));
        arrSinhVien.add(new SinhVien("dđ", "Thai Binh", "34"));
        arrSinhVien.add(new SinhVien("ddddd", "Thai Binh", "34"));
        sinhVienAdapter = new CustomAdapter(this, R.layout.list_item_sinh_vien, arrSinhVien);
        listViewSinhVien.setAdapter(sinhVienAdapter);


        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTextTen.getText().toString();
                String diachi = editTextDiaChi.getText().toString();
                String tuoi = editTextTuoi.getText().toString();
                if (TextUtils.isEmpty(ten) && TextUtils.isEmpty(diachi) && TextUtils.isEmpty(tuoi) ) {
                    Toast.makeText(MainActivity.this, "Vui Long nhap dau du thong tin", Toast.LENGTH_SHORT).show();
                }
                arrSinhVien.add(new SinhVien(ten, diachi, tuoi));
                sinhVienAdapter.notifyDataSetChanged();
                editTextTen.setText("");
                editTextDiaChi.setText("");
                editTextTuoi.setText("");
            }
        });
        // su kien listview
        listViewSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                editTextTen.setText(arrSinhVien.get(position).getmTen());
                editTextTuoi.setText(arrSinhVien.get(position).getmTuoi());
                editTextDiaChi.setText(arrSinhVien.get(position).getmDiaChi());
            }
        });

        // button sua
        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrSinhVien.get(vitri).setmTen(editTextTen.getText().toString());
                arrSinhVien.get(vitri).setmDiaChi(editTextDiaChi.getText().toString());
                arrSinhVien.get(vitri).setmTuoi(editTextTuoi.getText().toString());
                sinhVienAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Sua thanh cong", Toast.LENGTH_SHORT).show();
            }
        });

        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xacnhanxoa();
            }
        });

        //tim kiem
        editTextTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.sinhVienAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
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


    // tim kiem

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                sinhVienAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                sinhVienAdapter.getFilter().filter(newText);
                return false;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }
}
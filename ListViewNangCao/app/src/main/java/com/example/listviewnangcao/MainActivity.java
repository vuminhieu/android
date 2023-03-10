package com.example.listviewnangcao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewDanhsach;
    EditText editTextHoten, editTextNamsinh;
    Button buttonAdd, buttonDelete, buttonUpdate;
    int val;
    ArrayList<Sinhvien> dsSinhvien = new ArrayList<Sinhvien>();
    SinhvienAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidgets();

        dsSinhvien.add(new Sinhvien("Nguyen Van A", 1991));
        dsSinhvien.add(new Sinhvien("Pham Thi C", 1993));
        dsSinhvien.add(new Sinhvien("Tran Van D", 1982));
        adapter = new SinhvienAdapter(MainActivity.this, R.layout.item, dsSinhvien);
        listViewDanhsach.setAdapter(adapter);

        listViewDanhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = dsSinhvien.get(position).Hoten + " " + dsSinhvien.get(position).Namsinh;
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                val = position;
                editTextHoten.setText(dsSinhvien.get(position).Hoten.toString());
                editTextNamsinh.setText(dsSinhvien.get(position).Namsinh.toString());
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextHoten.getText().toString().trim().equals("") &&
                        !editTextNamsinh.getText().toString().trim().equals(""))
                {
                    dsSinhvien.add(new Sinhvien(editTextHoten.getText().toString().trim(),
                            Integer.parseInt(editTextNamsinh.getText().toString().trim())));
                    adapter.notifyDataSetChanged();
                    editTextHoten.setText("");
                    editTextNamsinh.setText("");
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dsSinhvien.remove(val);
                //adapter.notifyDataSetChanged();
                xacnhanxoa();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsSinhvien.get(val).Hoten = editTextHoten.getText().toString();
                dsSinhvien.get(val).Namsinh = Integer.parseInt(editTextNamsinh.getText().toString());
                adapter.notifyDataSetChanged();
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
                dsSinhvien.remove(val);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    private void InitWidgets() {
        listViewDanhsach = (ListView) findViewById(R.id.listViewSinhvien);
        editTextHoten = (EditText) findViewById(R.id.editTextHoten);
        editTextNamsinh = (EditText) findViewById(R.id.editTextNamsinh);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
    }
}
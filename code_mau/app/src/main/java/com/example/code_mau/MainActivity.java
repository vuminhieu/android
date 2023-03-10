package com.example.code_mau;


import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.View;




import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView lsvVeTau;
    VeTauAdapter veTauAdapter;
    ArrayList<VeTau> arrayListVeTaus;
    Database database = new Database(this);
    int viTriDangChon=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
//        database.xoaToanBo();
//        database.addSP(new VeTau(1, "Vinh", "Nam Định", 300000, true));
//        database.addSP(new VeTau(2, "Vinh", "Nam Định", 300000, true));
//        database.addSP(new VeTau(3, "Thái Nguyên", "Thái Bình", (float) 30, false));
//        database.addSP(new VeTau(4, "Đà Nẵng", "Cần Thơ", (float) 60, true));
//        database.addSP(new VeTau(5, "Hà Nội", "Cần Thơ", (float) 500000, true));
        arrayListVeTaus = (ArrayList<VeTau>) database.getAll();
        Collections.sort(arrayListVeTaus);
        veTauAdapter = new VeTauAdapter(MainActivity.this, R.layout.item_listview, arrayListVeTaus);
        lsvVeTau.setAdapter(veTauAdapter);
        lsvVeTau.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                viTriDangChon = position;
                registerForContextMenu(lsvVeTau);
                return false;
            }
        });

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemXoa){
            float tongTien=0;
            int dem = 0;
            for(int i=0;i<arrayListVeTaus.size();i++)
                if(arrayListVeTaus.get(i).getGaDen().compareTo(arrayListVeTaus.get(viTriDangChon).getGaDen())==0){
                    tongTien += arrayListVeTaus.get(i).getDonGia();
                    dem++;
                    database.DeleteById(arrayListVeTaus.get(i).getMa());
                }
            Toast.makeText(MainActivity.this, "Trung binh la: "+tongTien/dem, Toast.LENGTH_LONG).show();
            arrayListVeTaus= (ArrayList<VeTau>) database.getAll();
            veTauAdapter = new VeTauAdapter(MainActivity.this, R.layout.item_listview, arrayListVeTaus);
            lsvVeTau.setAdapter(veTauAdapter);
        }
        if(item.getItemId() == R.id.itemSua){

            int ma = arrayListVeTaus.get(viTriDangChon).getMa();//list item title
            String gaden = arrayListVeTaus.get(viTriDangChon).getGaDen();//list item title
            String gadi = arrayListVeTaus.get(viTriDangChon).getGaDi();//list item title
            double giatien = arrayListVeTaus.get(viTriDangChon).getDonGia();//list item title
            boolean khuhoi = arrayListVeTaus.get(viTriDangChon).isKhuHoi();//
            Intent it = new Intent(MainActivity.this, SuaActivity.class);
            it.putExtra("ID",  ma );
            it.putExtra("GADEN",  gaden );
            it.putExtra("GADI",  gadi );
            it.putExtra("GIATIEN",  giatien );
            it.putExtra("KHUHOI",  khuhoi );

            startActivity(it);

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu, menu);
    }

    void Init(){
        lsvVeTau = findViewById(R.id.lsvVeTau);
    }
}
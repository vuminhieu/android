package com.example.de_on_tap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.de_on_tap.Database.DBManager;
import com.example.de_on_tap.Model.VeTau;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonThem;
    ListView listViewDS;
    CustomAdapter customAdapter;
    List<VeTau> veTaus;
    DBManager dbManager = new DBManager(this);

    private void mapping() {
        listViewDS = (ListView) findViewById(R.id.lv_danh_sach);
        buttonThem = (Button) findViewById(R.id.btn_them);
    }

    private void setAdapter() {
        if (customAdapter == null) {
            customAdapter = new CustomAdapter(this, R.layout.dong_ve_tau, veTaus);
            listViewDS.setAdapter(customAdapter);
        } else {
            customAdapter.notifyDataSetChanged();
            listViewDS.setSelection(customAdapter.getCount() - 1);
        }
    }

    public void updateListVeTau() {
        veTaus.clear();
        veTaus.addAll(dbManager.GetAllVeTau());
        if (customAdapter != null) {
            customAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        veTaus = dbManager.GetAllVeTau();
        setAdapter();
        registerForContextMenu(listViewDS);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main_nenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        VeTau veTau = veTaus.get(i.position);
        // item sua
        if (item.getItemId() == R.id.item_sua) {
            DialogUpdate(veTau);
        }

        // item xoa
        if (item.getItemId() == R.id.item_xoa) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Thông báo");
            alertDialog.setIcon(R.mipmap.ic_launcher);
            alertDialog.setMessage("Bạn có chắc chắn xoá không");
            alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    int result = dbManager.Delete(veTau.getId());
                    if (result > 0) {
                        updateListVeTau();
                        Toast.makeText(MainActivity.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Xoá bị lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.show();
        }
        return super.onContextItemSelected(item);
    }


    public void DialogUpdate(VeTau veTau) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_repair);

        EditText editTextIDUpdate = (EditText) dialog.findViewById(R.id.edt_sua_id);
        EditText editTextGaDiUpdate = (EditText) dialog.findViewById(R.id.edt_sua_ga_di);
        EditText editTextGaDenUpdate = (EditText) dialog.findViewById(R.id.edt_sua_ga_den);
        EditText editTextGiaUpdate = (EditText) dialog.findViewById(R.id.edt_sua_gia);
        RadioButton radioButtonMotChieu = (RadioButton) dialog.findViewById(R.id.rdo_sua_mot_chieu);
        RadioButton radioButtonKhuHoi = (RadioButton) dialog.findViewById(R.id.rdo_sua_khu_hoi);
        Button buttonSua = (Button) dialog.findViewById(R.id.btn_update);
        Button buttonHuy = (Button) dialog.findViewById(R.id.btn_huy);

        editTextIDUpdate.setText(veTau.getId() + "");
        editTextGaDiUpdate.setText(veTau.getGaDi() + "");
        editTextGaDenUpdate.setText(veTau.getGaDen() + "");
        editTextGiaUpdate.setText(veTau.getDonGia() + "");
//        radioButtonMotChieu.setText(veTau.getmKhuHoi() + "");
//        if ("Một chiều" == radioButtonMotChieu.getText().toString().trim()) {
//            radioButtonMotChieu.isChecked();
//        }
//        if ("Khứ hồi" == radioButtonKhuHoi.getText().toString().trim()) {
//            radioButtonKhuHoi.isChecked();
//        }
        buttonHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VeTau veTau1 = new VeTau();
                veTau1.setId(Integer.parseInt(String.valueOf(editTextIDUpdate.getText())));
                veTau1.setGaDi(editTextGaDiUpdate.getText() + "");
                veTau1.setGaDen(editTextGaDenUpdate.getText() + "");
                veTau1.setDonGia(editTextGiaUpdate.getText() + "");
                String khuhoi = "";
                if (radioButtonMotChieu.isChecked()) {
                    khuhoi = khuhoi + radioButtonMotChieu.getText().toString();
                }
                if (radioButtonKhuHoi.isChecked()) {
                    khuhoi = khuhoi + radioButtonKhuHoi.getText().toString();
                }
                veTau1.setKhuHoi(khuhoi + "");
                int result = dbManager.UpdateVeTau(veTau1);
                if (result > 0) {
                    dbManager.UpdateVeTau(veTau1);
                    updateListVeTau();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
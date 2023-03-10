package com.example.bundle_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextTen;
    Spinner spinnerTinh;
    RadioButton radioButtonNam, radioButtonNu;
    CheckBox checkBoxBongDa, checkBoxCauLong;
    Button buttonTruyen;
    String TinhThanh;

    private void mapping() {
        editTextTen = (EditText) findViewById(R.id.edt_ten);
        spinnerTinh = (Spinner) findViewById(R.id.spn_tinh);
        radioButtonNam = (RadioButton) findViewById(R.id.rdo_nam);
        radioButtonNu = (RadioButton) findViewById(R.id.rdo_nu);
        checkBoxBongDa = (CheckBox) findViewById(R.id.cb_bong_da);
        checkBoxCauLong = (CheckBox) findViewById(R.id.cb_cau_long);
        buttonTruyen = (Button) findViewById(R.id.btn_truyen);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        ArrayList<String> tinh = new ArrayList<String>();
        tinh.add("Thái Bình");
        tinh.add("Nam Định");
        tinh.add("Hà Nội");
        tinh.add("Long AN");
        tinh.add("Thành Phố HCM");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tinh);
        spinnerTinh.setAdapter(adapter);

        // button truyen
        buttonTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle  =  new Bundle();
                bundle.putString("ten", editTextTen.getText().toString());
                if (radioButtonNam.isChecked()) {
                    bundle.putString("gioi_tinh", radioButtonNam.getText().toString());
                }
                if (radioButtonNu.isChecked()) {
                    bundle.putString("gioi_tinh", radioButtonNu.getText().toString());
                }
                spinnerTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        TinhThanh = tinh.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                bundle.putString("tinh_thanh", TinhThanh);
                String SoThich = "";
                if (checkBoxBongDa.isChecked()) {
                    SoThich = SoThich + checkBoxBongDa.getText().toString();
                }
                if (checkBoxCauLong.isChecked()) {
                    SoThich = SoThich + checkBoxCauLong.getText().toString();
                }
                bundle.putString("so_thich", SoThich);
                intent.putExtra("MyBundle", bundle);

                startActivity(intent);
            }
        });





    }
}
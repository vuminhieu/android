package com.example.code_mau;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuaActivity extends AppCompatActivity {
    private Database dataBase = new Database(this);
    private TextView txtGaDen, txtGaDi, txtGiaTien;
    private Button btnUpdate, btnBack;
    private RadioButton rdoKhuHoi, rdoMotChieu;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        Map();
        Intent intent = getIntent();
        int ma = intent.getIntExtra("ID", 0);
        String gaden = intent.getStringExtra("GADEN");
        String gadi = intent.getStringExtra("GADI");
        double giatien = intent.getDoubleExtra("GIATIEN", 0.0);
        boolean khuhoi = intent.getBooleanExtra("KHUHOI", true);
        txtGiaTien.setText(giatien+"");
        txtGaDen.setText(gaden);
        txtGaDi.setText(gadi);
        if(khuhoi==true)
            rdoKhuHoi.setChecked(true);
        else
            rdoMotChieu.setChecked(true);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean kh;
                if(rdoKhuHoi.isChecked())
                    kh=true;
                else
                    kh=false;
                VeTau vt = new VeTau(ma, txtGaDi.getText().toString(), txtGaDen.getText().toString(), Float.parseFloat(txtGiaTien.getText().toString()), kh);
                dataBase.updateVetau(vt);
                Intent it = new Intent(SuaActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

    }
    void Map(){
        txtGaDen = (EditText)findViewById(R.id.tvGaDen);
        txtGaDi = (EditText)findViewById(R.id.tvGadi);
        txtGiaTien = (EditText)findViewById(R.id.tvDonGia);
        btnUpdate = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);
        rdoKhuHoi=(RadioButton)findViewById(R.id.rdoKhuHoi);
        rdoMotChieu=(RadioButton)findViewById(R.id.rdoMotChieu);
    }
}


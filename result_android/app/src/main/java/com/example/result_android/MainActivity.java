package com.example.result_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonTruyen;
    EditText editTextSoa;
    TextView textViewKetQua;
    public static final int My_code_request = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTruyen = (Button) findViewById(R.id.btn_truyen);
        editTextSoa = (EditText) findViewById(R.id.edt_so_a);
        textViewKetQua = (TextView) findViewById(R.id.tv_ket_qua);

        buttonTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("so_a" , Integer.parseInt(editTextSoa.getText().toString()));
                startActivityForResult(intent, My_code_request);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == My_code_request && resultCode == MainActivity2.My_code_result) {
            int kq = data.getIntExtra("binh_phuong" , 0);
            textViewKetQua.setText(" Ket Qua = " + kq);
        }

        if (requestCode == My_code_request && resultCode == MainActivity2.My_code_result2) {
            int kq = data.getIntExtra("nhan_doi" , 0);
            textViewKetQua.setText(" Ket Qua = " + kq);
        }

    }
}
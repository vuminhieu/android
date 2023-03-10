package com.example.demoresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextA, editTextB;
    Button buttonTruyen;
    TextView textViewKetQua;

    private void mapping() {
        editTextA = (EditText) findViewById(R.id.edt_soa);
        editTextB= (EditText) findViewById(R.id.edr_so_b);
        buttonTruyen = (Button) findViewById(R.id.btn_truyen);
        textViewKetQua = (TextView) findViewById(R.id.tv_hetqua);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        buttonTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("soa", Integer.parseInt(editTextA.getText().toString()));
                intent.putExtra("sob", Integer.parseInt(editTextB.getText().toString()));
                startActivityForResult(intent, 99);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33) {
            int kq = data.getIntExtra("kq",0);
            textViewKetQua.setText("ket qua :   " + kq);
        }

        if (requestCode == 99 && resultCode == 88) {
            int kq = data.getIntExtra("tich",0);
            textViewKetQua.setText("ket qua :   " + kq);
        }
    }
}
package com.example.a10_10_22_01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextSoa, editTextSob;
    Button buttonSend;
    TextView textViewKq;

    private ActivityResultLauncher<Intent> myActivityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == 33) {
                                Intent intent = result.getData();
                                int t = intent.getIntExtra("tong", 0);
                                textViewKq.setText("tong = " + t);
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitWidgets();
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xuly();
            }
        });
    }

    private void Xuly() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        // dua du lieu vao intent
        intent.putExtra("a", Integer.parseInt(editTextSoa.getText().toString()));
        intent.putExtra("b", Integer.parseInt(editTextSob.getText().toString()));
        // gui intent va doi ket qua tra ve - khong dung startActivity
        // startActivityforResult
        //startActivityForResult(intent, 99);
        myActivityResultLauncher.launch(intent);
    }

    private void InitWidgets() {
        editTextSoa = (EditText) findViewById(R.id.editTextSoa);
        editTextSob = (EditText) findViewById(R.id.editTextSob);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        textViewKq = (TextView) findViewById(R.id.textViewKq);
    }
}
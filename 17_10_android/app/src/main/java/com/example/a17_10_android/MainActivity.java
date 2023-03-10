package com.example.a17_10_android;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextId, editTextHoten, editTextNamsinh;
    Button buttonInsert, buttonUpdate, buttonDelete, buttonLoadAll;
    TextView textViewData;
    MyDBHelper dbHelper = new MyDBHelper(this);

    // lay du lieu tu textbox
    private String getValue(EditText editText){
        return editText.getText().toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
        dbHelper.openDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHelper.closeDB();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidgets();
        //dbHelper = new MyDBHelper(MainActivity.this);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long resultAdd = dbHelper.Insert(getValue(editTextHoten),
                        Integer.parseInt(getValue(editTextNamsinh)));
                if (resultAdd == -1){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonLoadAll.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                StringBuffer bufferData = new StringBuffer();
                Cursor cursor = dbHelper.getAllRecord();
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    bufferData.append(cursor.getInt(cursor.getColumnIndex(MyDBHelper.getID())));
                    bufferData.append("-");
                    bufferData.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.getNAME())));
                    bufferData.append("-");
                    bufferData.append(cursor.getInt(cursor.getColumnIndex(MyDBHelper.getYEAROB())));
                    bufferData.append("\n");
                }
                textViewData.setText(bufferData);
            }
        });
    }

    private void InitWidgets() {
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextHoten = (EditText) findViewById(R.id.editTextHoten);
        editTextNamsinh = (EditText) findViewById(R.id.editTextNamsinh);
        buttonInsert = (Button) findViewById(R.id.buttonInsert);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonLoadAll = (Button) findViewById(R.id.buttonLoadAll);
        textViewData = (TextView) findViewById(R.id.textViewData);
    }
}
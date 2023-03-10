package com.example.a10_10;


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
    Button buttonSubmit;
    EditText editTextHoten, editTextNgaysinh;
    Spinner spinnerQuoctich;
    RadioButton radioButtonNam, radioButtonNu;
    CheckBox checkBoxThethao, checkBoxDulich;
    String qt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initwidgets();
        ArrayList<String> qt = new ArrayList<String>();
        qt.add("Viet nam");
        qt.add("Trung quoc");
        qt.add("Lien xo");
        qt.add("Hoa ky");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, qt);
        spinnerQuoctich.setAdapter(adapter);
        // button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                // dua du lieu vao bundle
                bundle.putString("hoten", editTextHoten.getText().toString());
                bundle.putString("ngaysinh", editTextNgaysinh.getText().toString());
                if (radioButtonNam.isChecked()){
                    bundle.putString("gioitinh", radioButtonNam.getText().toString());
                }
                if (radioButtonNu.isChecked()){
                    bundle.putString("gioitinh", radioButtonNu.getText().toString());
                }
                spinnerQuoctich.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        qt1 = qt.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                bundle.putString("quoctich", qt1);
                String st = "";
                if (checkBoxThethao.isChecked()){
                    st = st + checkBoxThethao.getText().toString();
                }
                if (checkBoxDulich.isChecked()){
                    st = st + checkBoxDulich.getText().toString();
                }
                bundle.putString("sothich",st);
                // dua bundle vao intent
                intent.putExtra("mybundle",bundle);
                startActivity(intent);
            }
        });

    }

    private void Initwidgets() {
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        radioButtonNam = (RadioButton) findViewById(R.id.radioButtonNam);
        radioButtonNu = (RadioButton) findViewById(R.id.radioButtonNu);
        editTextHoten = (EditText) findViewById(R.id.editTextHoten);
        editTextNgaysinh = (EditText) findViewById(R.id.editTextNgaysinh);
        checkBoxDulich = (CheckBox) findViewById(R.id.checkBoxDulich);
        checkBoxThethao = (CheckBox) findViewById(R.id.checkBoxThethao);
        spinnerQuoctich = (Spinner) findViewById(R.id.spinnerQuoctich);
    }
}
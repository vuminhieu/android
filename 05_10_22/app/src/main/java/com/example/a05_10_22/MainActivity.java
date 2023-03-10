package com.example.a05_10_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_sign_up, button_sign_in;
    TextView textView_email, textView_password, textView_forget_password;

    public void mapping() {
        button_sign_up = (Button) findViewById(R.id.btn_sign_up);
        button_sign_in = (Button) findViewById(R.id.btn_sign_in);
        textView_email = (TextView) findViewById(R.id.txt_email);
        textView_password = (TextView) findViewById(R.id.txt_password);
        textView_forget_password = (TextView) findViewById(R.id.txt_forget_password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textView_email.getText().toString();
                String password = textView_password.getText().toString();
//                if (email == "minhhieuvux@gmail.com" && password == "123456" ) {
                    Intent intent = new Intent(MainActivity.this, home_page.class);
                    intent.putExtra("Email", email);
                    startActivity(intent);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Your email or password is incorrect", Toast.LENGTH_SHORT).show();
//                }
            }
        });


    }
}
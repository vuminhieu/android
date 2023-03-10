package com.example.extra_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = (TextView) findViewById(R.id.id1);
        textView2 = (TextView) findViewById(R.id.id2);

        Intent i = getIntent();
        String value1 = i.getStringExtra("key1");
        int value2 = i.getIntExtra("key2", 0);

        textView1.setText(value1);
        textView2.setText(""+ value2);
    }
}
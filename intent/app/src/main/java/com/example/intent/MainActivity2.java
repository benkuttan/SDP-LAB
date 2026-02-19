package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity { // Changed from SecondActivity
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // Ensure you have an activity_main2.xml layout

        txt2 = findViewById(R.id.text2);
        String name = getIntent().getStringExtra("username_key");

        if (name != null) {
            txt2.setText("Welcome " + name);
        }
    }
}
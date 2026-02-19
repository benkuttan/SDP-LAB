package com.example.exp7; // Ensure this matches your project package

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// 1. Class name now matches the filename MainActivity2.java
public class MainActivity2 extends AppCompatActivity {
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2. Ensure you have a file named activity_main2.xml in res/layout
        setContentView(R.layout.activity_main2);

        txt2 = findViewById(R.id.txt2); // Make sure this ID exists in your XML

        String name = getIntent().getStringExtra("username_key");

        if (name != null && !name.isEmpty()) {
            txt2.setText("Welcome " + name);
        } else {
            txt2.setText("Noname Received");
        }
    }
}
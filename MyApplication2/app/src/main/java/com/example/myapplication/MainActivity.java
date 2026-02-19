package com.example.myapplication; // Ensure this matches your project package name

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding the button by its ID defined in XML
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating and showing the Toast message
                Toast.makeText(getApplicationContext(),
                        "Welcome to SGCI",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
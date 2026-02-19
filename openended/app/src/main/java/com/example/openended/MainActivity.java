package com.example.openended;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Click listeners to open the respective screens
        findViewById(R.id.btnBook).setOnClickListener(v -> startActivity(new Intent(this, BookingActivity.class)));
        findViewById(R.id.btnView).setOnClickListener(v -> startActivity(new Intent(this, ViewActivity.class)));
        findViewById(R.id.btnManage).setOnClickListener(v -> startActivity(new Intent(this, ManageActivity.class)));
    }
}
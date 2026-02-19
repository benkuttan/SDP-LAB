package com.example.exp7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        Button btnpass = findViewById(R.id.btnpass);

        btnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();

                // Intent: (Current Context, Destination Class)
                // Change SecondActivity.class to MainActivity2.class
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("username_key", username);
                startActivity(intent);
            }
        });
    }
}
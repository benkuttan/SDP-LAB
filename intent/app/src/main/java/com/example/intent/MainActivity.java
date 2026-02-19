package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        Button btnPass = findViewById(R.id.btn_pass);

        btnPass.setOnClickListener(view -> {
            String username = name.getText().toString();

            // Fixed the Intent constructor syntax from your notes
            // Inside your button's onClickListener
            Intent intent = new Intent(MainActivity.this, MainActivity2.class); // Use MainActivity2 here
            intent.putExtra("username_key", username);
            startActivity(intent);
        });
    }
}
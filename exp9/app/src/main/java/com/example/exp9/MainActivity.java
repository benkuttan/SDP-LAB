package com.example.exp9;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText etMessage;
    private TextView tvDisplay;
    private final String FILE_NAME = "user_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = findViewById(R.id.etMessage);
        tvDisplay = findViewById(R.id.tvDisplay);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnLoad = findViewById(R.id.btnLoad);

        btnSave.setOnClickListener(v -> saveData());
        btnLoad.setOnClickListener(v -> loadData());
    }

    private void saveData() {
        String text = etMessage.getText().toString();

        // Use try-with-resources for automatic file closing
        try (FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fos.write(text.getBytes());
            etMessage.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving file: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void loadData() {
        try (FileInputStream fis = openFileInput(FILE_NAME)) {
            int size;
            StringBuilder content = new StringBuilder();

            // Read file byte by byte
            while ((size = fis.read()) != -1) {
                content.append((char) size);
            }

            tvDisplay.setText(content.toString());
            Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
            tvDisplay.setText("No saved data found.");
            Toast.makeText(this, "File Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.exp8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    CheckBox read, swim;
    RadioGroup rg;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        read = findViewById(R.id.read);
        swim = findViewById(R.id.swim);
        rg = findViewById(R.id.rg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Get name from EditText
                String name = txt.getText().toString();

                // 2. Get selected Gender from RadioGroup
                int selid = rg.getCheckedRadioButtonId();
                String gender = "None";
                if (selid != -1) {
                    RadioButton rb = findViewById(selid);
                    gender = rb.getText().toString();
                }

                // 3. Check which CheckBoxes are selected
                String chsel = "Hobbies: ";
                if (read.isChecked()) {
                    chsel += "Reading ";
                }
                if (swim.isChecked()) {
                    chsel += "Swimming ";
                }

                if (!read.isChecked() && !swim.isChecked()) {
                    chsel += "None";
                }

                // Display everything in a Toast
                String finalMessage = "Name: " + name + "\nGender: " + gender + "\n" + chsel;
                Toast.makeText(getApplicationContext(), finalMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}
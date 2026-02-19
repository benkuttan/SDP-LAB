package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText bweight, bheight;
    Button btncalc;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding UI elements
        bweight = findViewById(R.id.bweight);
        bheight = findViewById(R.id.bheight);
        btncalc = findViewById(R.id.btncalc);
        tvResult = findViewById(R.id.tvResult);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wstr = bweight.getText().toString().trim();
                String hstr = bheight.getText().toString().trim();

                // Validation
                if (wstr.isEmpty() || hstr.isEmpty()) {
                    tvResult.setText("Please enter both weight and height");
                    return;
                }

                // Calculation logic
                double w = Double.parseDouble(wstr);
                double h = Double.parseDouble(hstr);
                double bmi = w / (h * h);

                String status;
                if (bmi < 18.5) {
                    status = "underweight";
                } else if (bmi <= 24.9) {
                    status = "Normal";
                } else if (bmi <= 29.9) {
                    status = "overweight";
                } else {
                    status = "obese";
                }

                tvResult.setText("Final verdict is that you are " + status + " (BMI: " + String.format("%.2f", bmi) + ")");
            }
        });
    }
}
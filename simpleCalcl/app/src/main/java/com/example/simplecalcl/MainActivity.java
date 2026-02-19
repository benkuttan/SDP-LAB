package com.example.simplecalcl;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addbtn, subbtn, multbtn, divbtn;
    EditText num1, num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding the UI elements to Java variables
        addbtn = findViewById(R.id.addbtn);
        subbtn = findViewById(R.id.subbtn);
        multbtn = findViewById(R.id.multbtn);
        divbtn = findViewById(R.id.divbtn);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        // Example for Addition Logic
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                double sum = n1 + n2;
                result.setText("Result: " + sum);
            }
        });

        // Subtraction Logic
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                double diff = n1 - n2;
                result.setText("Result: " + diff);
            }
        });

        // Multiplication Logic
        multbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                double prod = n1 * n2;
                result.setText("Result: " + prod);
            }
        });

        // Division Logic
        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                if(n2 != 0) {
                    double div = n1 / n2;
                    result.setText("Result: " + div);
                } else {
                    result.setText("Cannot divide by zero");
                }
            }
        });
    }
}
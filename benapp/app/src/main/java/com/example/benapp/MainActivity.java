package com.example.benapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

     num1, num2;
    Button addBtn, subBtn, mulBtn, divBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        resultText = findViewById(R.id.resultText);

        addBtn.setOnClickListener(v -> calculate('+'));
        subBtn.setOnClickListener(v -> calculate('-'));
        mulBtn.setOnClickListener(v -> calculate('*'));
        divBtn.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {

        String n1 = num1.getText().toString().trim();
        String n2 = num2.getText().toString().trim();

        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(n1);
        double b = Double.parseDouble(n2);
        double result;

        switch (operator) {
            case '+':
                result = a + b;
                break;

            case '-':
                result = a - b;
                break;

            case '*':
                result = a * b;
                break;

            case '/':
                if (b == 0) {
                    resultText.setText("Division by zero not allowed");
                    return;
                }
                result = a / b;
                break;

            default:
                return;
        }

        resultText.setText("Result: " + result);
    }
}
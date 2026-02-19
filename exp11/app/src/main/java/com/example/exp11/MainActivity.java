package com.example.exp11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText eId, eName, eDept, eSalary;
    Button btnInsert, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        eId = findViewById(R.id.empid);
        eName = findViewById(R.id.name);
        eDept = findViewById(R.id.dept);
        eSalary = findViewById(R.id.salary);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);

        btnInsert.setOnClickListener(v -> {
            int id = Integer.parseInt(eId.getText().toString());
            String name = eName.getText().toString();
            String dept = eDept.getText().toString();
            double basic = Double.parseDouble(eSalary.getText().toString());

            // Compute Financials
            double da = basic * 0.10;
            double hra = basic * 0.20;
            double gross = basic + da + hra;

            boolean isInserted = db.insertData(id, name, dept, basic, gross);
            if(isInserted)
                Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
        });

        btnView.setOnClickListener(v -> {
            Cursor res = db.getAllData();
            if(res.getCount() == 0) {
                Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getString(0)).append("\n");
                buffer.append("Name: ").append(res.getString(1)).append("\n");
                buffer.append("Dept: ").append(res.getString(2)).append("\n");
                buffer.append("Basic: ").append(res.getString(3)).append("\n");
                buffer.append("Gross: ").append(res.getString(4)).append("\n\n");
            }

            // Display in an Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Employee Details");
            builder.setMessage(buffer.toString());
            builder.show();
        });
    }
}
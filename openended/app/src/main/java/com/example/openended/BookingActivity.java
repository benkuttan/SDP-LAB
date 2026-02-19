package com.example.openended;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editPhone, editDate;
    RadioGroup rgDept;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.name);
        editPhone = findViewById(R.id.phone);
        editDate = findViewById(R.id.date);
        rgDept = findViewById(R.id.rgDept);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();
            String date = editDate.getText().toString().trim();

            // 1. Validation: Prevent empty submissions
            if (name.isEmpty() || phone.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                return;
            }

            // 2. Get Selected Department safely
            int selectedId = rgDept.getCheckedRadioButtonId();
            String dept = "General"; // Default fallback
            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                dept = rb.getText().toString();
            }

            // 3. Insert into Database
            boolean isInserted = myDb.insertData(name, phone, dept, date);

            if(isInserted) {
                Toast.makeText(this, "Booked Successfully!", Toast.LENGTH_SHORT).show();
                // Clear inputs after success
                editName.setText("");
                editPhone.setText("");
                editDate.setText("");
                rgDept.clearCheck();
            } else {
                Toast.makeText(this, "Database Error: Booking Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
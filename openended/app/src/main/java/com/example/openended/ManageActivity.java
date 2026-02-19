package com.example.openended;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ManageActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editId, editNewDate;
    Button btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        myDb = new DatabaseHelper(this);

        editId = findViewById(R.id.editId);
        editNewDate = findViewById(R.id.editNewDate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // UPDATE Logic
        btnUpdate.setOnClickListener(v -> {
            String id = editId.getText().toString().trim();
            String newDate = editNewDate.getText().toString().trim();

            if (id.isEmpty() || newDate.isEmpty()) {
                Toast.makeText(this, "Please enter ID and New Date", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isUpdated = myDb.updateData(id, newDate);
            if(isUpdated) {
                Toast.makeText(this, "Appointment Updated", Toast.LENGTH_SHORT).show();
                editId.setText("");
                editNewDate.setText("");
            } else {
                Toast.makeText(this, "ID not found!", Toast.LENGTH_SHORT).show();
            }
        });

        // DELETE Logic
        btnDelete.setOnClickListener(v -> {
            String id = editId.getText().toString().trim();

            if (id.isEmpty()) {
                Toast.makeText(this, "Please enter ID to delete", Toast.LENGTH_SHORT).show();
                return;
            }

            Integer deletedRows = myDb.deleteData(id);
            if(deletedRows > 0) {
                Toast.makeText(this, "Appointment Deleted", Toast.LENGTH_SHORT).show();
                editId.setText(""); // Clear input
            } else {
                Toast.makeText(this, "ID not found!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
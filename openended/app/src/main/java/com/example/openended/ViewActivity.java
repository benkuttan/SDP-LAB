package com.example.openended;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView displayData;
    Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        myDb = new DatabaseHelper(this);
        displayData = findViewById(R.id.displayData);
        btnRefresh = findViewById(R.id.btnRefresh);

        // Load data automatically when the screen opens
        showAllBookings();

        // Refresh data when the button is clicked
        btnRefresh.setOnClickListener(v -> showAllBookings());
    }

    private void showAllBookings() {
        Cursor res = myDb.getAllData();

        if (res.getCount() == 0) {
            displayData.setText("No appointments found in the database.");
            Toast.makeText(this, "Database is Empty", Toast.LENGTH_SHORT).show();
            res.close(); // Prevent memory leaks
            return;
        }

        StringBuilder builder = new StringBuilder();
        while (res.moveToNext()) {
            builder.append("━━━━━━━━━━━━━━━━━━\n");
            builder.append("ID: ").append(res.getString(0)).append("\n");
            builder.append("Patient: ").append(res.getString(1)).append("\n");
            builder.append("Phone: ").append(res.getString(2)).append("\n");
            builder.append("Dept: ").append(res.getString(3)).append("\n");
            builder.append("Date: ").append(res.getString(4)).append("\n\n");
        }

        displayData.setText(builder.toString());
        res.close(); // Prevent memory leaks
    }
}
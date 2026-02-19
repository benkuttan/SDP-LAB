package com.example.openended;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // CHANGED VERSION TO 2: This forces the database to refresh and fix any missing column issues.
    public DatabaseHelper(Context context) {
        super(context, "DoctorDB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creates the table with all required columns
        db.execSQL("CREATE TABLE Bookings(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, dept TEXT, date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drops the old buggy table and creates a fresh one
        db.execSQL("DROP TABLE IF EXISTS Bookings");
        onCreate(db);
    }

    // CREATE: Inserts a new booking into the database
    public boolean insertData(String name, String phone, String dept, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("dept", dept);
        cv.put("date", date);

        long result = db.insert("Bookings", null, cv);
        return result != -1; // Returns true if successful, false if failed
    }

    // READ: Fetches all data for the ViewActivity
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM Bookings", null);
    }

    // UPDATE: Changes the date of a specific appointment based on ID
    public boolean updateData(String id, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("date", date);

        int result = db.update("Bookings", cv, "id=?", new String[]{id});
        return result > 0; // Returns true if at least 1 row was updated
    }

    // DELETE: Removes an appointment based on ID
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Bookings", "id=?", new String[]{id});
    }
}
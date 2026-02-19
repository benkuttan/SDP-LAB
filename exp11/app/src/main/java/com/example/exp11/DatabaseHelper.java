package com.example.exp11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "StaffDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating the table with appropriate data types
        db.execSQL("CREATE TABLE Employee(empid INTEGER PRIMARY KEY, name TEXT, department TEXT, basic_salary REAL, gross_salary REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Employee");
        onCreate(db);
    }

    public boolean insertData(int id, String name, String dept, double basic, double gross) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("empid", id);
        contentValues.put("name", name);
        contentValues.put("department", dept);
        contentValues.put("basic_salary", basic);
        contentValues.put("gross_salary", gross);
        long result = db.insert("Employee", null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM Employee", null);
    }
}
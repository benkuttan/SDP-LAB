package com.example.exp10;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button inbtn,outbtn;
    EditText name,regno,grd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inbtn=findViewById(R.id.inbtn);
        outbtn=findViewById(R.id.outbtn);
        name=findViewById(R.id.name);
        regno=findViewById(R.id.regno);
        grd=findViewById(R.id.gr);

        inbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=openOrCreateDatabase("Record.db",MODE_PRIVATE,null);
                db.execSQL("create table if not exists Student(Name varchar(20),Regno varchar(20),Grade varchar(4))");
                String na=name.getText().toString();
                db.execSQL("insert into Student values('"+na+"','"+regno.getText().toString()+"','"+grd.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"Inserted Succesfully",Toast.LENGTH_LONG).show();

            }
        });

        outbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=openOrCreateDatabase("Record.db",MODE_PRIVATE,null);
                Cursor c=db.rawQuery("select * from Student",null);
                StringBuffer buf=new StringBuffer();
                while(c.moveToNext())
                {
                    buf.append(c.getString(0)+" ");
                    buf.append(c.getString(1)+" ");
                    buf.append(c.getString(2)+" ");
                }
                Toast.makeText(getApplicationContext(),buf,Toast.LENGTH_LONG).show();


            }
        });

    }
}

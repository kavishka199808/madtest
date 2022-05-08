package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button login,register,assign,view,reports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.btnview);
        register = findViewById(R.id.btnregister);
        assign = findViewById(R.id.btnassign);
        view = findViewById(R.id.btnview);
        reports = findViewById(R.id.btnreports);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddNewDriver.class);
                startActivity(i);


            }
        });
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(getApplicationContext(), AssignDrivers.class);
                startActivity(y);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(), EditDriver.class);
                startActivity(a);
            }
        });
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(), DriverReport.class);
                startActivity(b);
            }
        });
    }
}
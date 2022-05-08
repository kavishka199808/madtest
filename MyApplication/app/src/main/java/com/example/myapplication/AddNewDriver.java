package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.Database.DBHandler;

public class AddNewDriver extends AppCompatActivity {

    EditText username,dob,password;
    Button add, updateProfile;
    RadioButton male,female;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username = findViewById(R.id.etUserNamePM);
        dob = findViewById(R.id.etDobPM);
        password = findViewById(R.id.etPasswordPM);
        add = findViewById(R.id.btnAdd);
        updateProfile = findViewById(R.id.btnUpdate);
        male = findViewById(R.id.rdbuttonMalePM);
        female = findViewById(R.id.rdbuttonFemalePM);


        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EditDriver.class);
                startActivity(i);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(male.isChecked()){
                    gender = "Male";
                }
                else{
                    gender = "Female";
                }
                DBHandler  dbHandler = new DBHandler(getApplicationContext());
               long newID =  dbHandler.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(AddNewDriver.this, "User Added. User ID:"+newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), EditDriver.class);
                startActivity(i);

                username.setText(null);
                dob.setText(null);
                password.setText(null);
                male.setChecked(true);
                female.setChecked(false);

            }
        });




    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.Database.DBHandler;

import java.util.List;

public class EditDriver extends AppCompatActivity {

    EditText username,dob,password ;
    Button edit, delete,search;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_driver);

        username = findViewById(R.id.etUserNameEP);
        dob = findViewById(R.id.etDateOfBirthEP);
        password = findViewById(R.id.etPasswordeEP);
        edit = findViewById(R.id.btnEditEP);
        delete = findViewById(R.id.btnDeleteEP);
        search = findViewById(R.id.btnSearchEP);
        male = findViewById(R.id.rdbuttonMaleEP);
        female = findViewById(R.id.rdbuttonFemaleEP);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List user =  dbHandler.readAllInfo(username.getText().toString());

                if(user.isEmpty()){

                    Toast.makeText(EditDriver.this, "No user", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else{

                    Toast.makeText(EditDriver.this, "User Found! User:"+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    dob.setText(user.get(1).toString());
                    password.setText(user.get(2).toString());
                    if(user.get(3).toString().equals("Male")){
                        male.setChecked(true);
                    }
                    else{
                        female.setChecked(true);
                    }
                }


            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(male.isChecked()){
                    gender = "Male";
                }
                else{
                    gender = "Female";
                }
                DBHandler dbHandler = new DBHandler(getApplicationContext());

                Boolean status = dbHandler.updateInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                if(status){
                    Toast.makeText(EditDriver.this, "User Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditDriver.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deleteInfo(username.getText().toString());

                Toast.makeText(EditDriver.this, "User Deleted", Toast.LENGTH_SHORT).show();

                username.setText(null);
                dob.setText(null);
                password.setText(null);
                male.setChecked(false);
                female.setChecked(false);
            }
        });

    }
}
package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class AssignDrivers extends AppCompatActivity {

    private String polonnaruwaqty = "";
    private String Medirigiriyaqty = "";
    private String spetialqty = "";

    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();

    private TableLayout table ;

    EditText ed1;

    CheckBox ch1,ch2,ch3;

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_drivers);

        ch1 = findViewById(R.id.chk1);
        ch2 = findViewById(R.id.chk2);
        ch3 = findViewById(R.id.chk3);

        ed1 = findViewById(R.id.txtsub);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0 ;
                    for(int a=0;a<data3.size();a++)
                    {
                        sum = sum+Integer.parseInt(data3.get(a).toString());
                    }
                    ed1.setText(String.valueOf(sum));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      Assign();
            }
        });
    }

    public void Assign(){
        if(ch1.isChecked()){
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Assign Driver Qty");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("ok", (Dialog,which) -> {

                    String pollonnaruwa = ch1.getText().toString();
                    int place = 5;

                    polonnaruwaqty = input.getText().toString();

                    int tot = place * Integer.parseInt(polonnaruwaqty);

                    data.add(pollonnaruwa);
                    data1.add(String.valueOf(place));
                    data2.add(String.valueOf(polonnaruwaqty));
                    data3.add(String.valueOf(tot));

                    TableLayout table = (TableLayout) findViewById(R.id.tb1);

                    String total;

                    for (int i = 0; i< data.size(); i++) {
                        String plocation = data.get(i);
                        String prc = data1.get(i);
                        String qty = data2.get(i);
                        total = data3.get(i);

                        t1.setText(plocation);
                        t2.setText(prc);
                        t3.setText(qty);
                        t4.setText(total);

                    }

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }

       else if(ch2.isChecked()){
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Assign Driver Qty");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("ok", (Dialog,which) -> {

                String medirigiriya = ch2.getText().toString();
                int place = 10;

                Medirigiriyaqty = input.getText().toString();

                int tot = place * Integer.parseInt(Medirigiriyaqty);

                data.add(medirigiriya);
                data1.add(String.valueOf(place));
                data2.add(String.valueOf(Medirigiriyaqty));
                data3.add(String.valueOf(tot));

                TableLayout table = (TableLayout) findViewById(R.id.tb1);

                String total;

                for (int i = 0; i< data.size(); i++) {
                    String plocation = data.get(i);
                    String prc = data1.get(i);
                    String qty = data2.get(i);
                    total = data3.get(i);

                    t1.setText(plocation);
                    t2.setText(prc);
                    t3.setText(qty);
                    t4.setText(total);

                }

                row.addView(t1);
                row.addView(t2);
                row.addView(t3);
                row.addView(t4);
                table.addView(row);

            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }

        else if(ch3.isChecked()){
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Assign Driver Qty");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("ok", (Dialog,which) -> {

                String spectial = ch3.getText().toString();
                int place = 2;

               spetialqty = input.getText().toString();

                int tot = place * Integer.parseInt(spetialqty);

                data.add(spectial);
                data1.add(String.valueOf(place));
                data2.add(String.valueOf(spetialqty));
                data3.add(String.valueOf(tot));

                TableLayout table = (TableLayout) findViewById(R.id.tb1);

                String total;

                for (int i = 0; i< data.size(); i++) {
                    String plocation = data.get(i);
                    String prc = data1.get(i);
                    String qty = data2.get(i);
                    total = data3.get(i);

                    t1.setText(plocation);
                    t2.setText(prc);
                    t3.setText(qty);
                    t4.setText(total);

                }

                row.addView(t1);
                row.addView(t2);
                row.addView(t3);
                row.addView(t4);
                table.addView(row);

            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }





    }
}
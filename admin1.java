package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class admin1 extends AppCompatActivity {
Spinner sp;
EditText ed,ed1,ed2,ed3,ed4,ed5;
Button b;
String g;
Mydb obj1;
String k[]={"Search Subject","BASIC C","DSA","DBMS","JAVA","ANDROID"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);
        sp=(Spinner)findViewById(R.id.spinner);
        ed=(EditText)findViewById(R.id.editText7);
        ed1=(EditText)findViewById(R.id.editText8);
        ed2=(EditText)findViewById(R.id.editText9);
        ed3=(EditText)findViewById(R.id.editText10);
        ed4=(EditText)findViewById(R.id.editText11);
        ed5=(EditText)findViewById(R.id.editText12);
        b=(Button)findViewById(R.id.button5);
        obj1=new Mydb(this);
        ArrayAdapter<String>obj;
        obj=new ArrayAdapter<String>(admin1.this,R.layout.support_simple_spinner_dropdown_item,k);
        sp.setAdapter(obj);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                g=sp.getSelectedItem().toString();
                Toast.makeText(admin1.this, g, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g.equals("BASIC C")) {
                    obj1.add_quiz(ed.getText().toString(), ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString());
                    Toast.makeText(admin1.this, "Inserted...", Toast.LENGTH_SHORT).show();
                }
               else if (g.equals("DSA")) {
                    obj1.adddsa_quiz(ed.getText().toString(), ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString());
                    Toast.makeText(admin1.this, "Inserted...", Toast.LENGTH_SHORT).show();
                }
                else if (g.equals("DBMS")) {
                    obj1.adddbms_quiz(ed.getText().toString(), ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString());
                    Toast.makeText(admin1.this, "Inserted...", Toast.LENGTH_SHORT).show();
                }
                else if (g.equals("JAVA")) {
                    obj1.addjava_quiz(ed.getText().toString(), ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString());
                    Toast.makeText(admin1.this, "Inserted...", Toast.LENGTH_SHORT).show();
                }
                else if (g.equals("ANDROID")) {
                    obj1.addandroid_quiz(ed.getText().toString(), ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString(), ed5.getText().toString());
                    Toast.makeText(admin1.this, "Inserted...", Toast.LENGTH_SHORT).show();
                }
                ed.setText(null);
                ed1.setText(null);
                ed2.setText(null);
                ed3.setText(null);
                ed4.setText(null);
                ed5.setText(null);



            }
        });


    }
}

package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kl extends AppCompatActivity {
    EditText ed, ed1, ed2, ed3, ed4;
    Button b;
    String a1, a2, a3, a4;
    Mydb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kl);
        ed = (EditText) findViewById(R.id.editText);
        ed1 = (EditText) findViewById(R.id.editText4);
        ed2 = (EditText) findViewById(R.id.editText6);
        ed3 = (EditText) findViewById(R.id.editText5);
        b = (Button) findViewById(R.id.button3);
        db = new Mydb(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    a1 = ed.getText().toString();
                    a2 = ed1.getText().toString();
                    a3 = ed2.getText().toString();
                    a4 = ed3.getText().toString();


                    cln();
                    if(a1.isEmpty()||a2.isEmpty()||a3.isEmpty()||a4.isEmpty()){
                        Toast.makeText(kl.this, "Not Registered", Toast.LENGTH_SHORT).show();
                    }
                   else {
                        db.add(a1, a3);
                        Toast.makeText(kl.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(kl.this, loginq.class);
                        startActivity(i);

                    }
                }catch (Exception e){
                    Toast.makeText(kl.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
        public void cln () {
            ed.setText(null);
            ed1.setText(null);
            ed2.setText(null);
            ed3.setText(null);
            ed.requestFocus();
        }

    }





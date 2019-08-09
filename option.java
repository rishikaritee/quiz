package com.example.quiz;

import android.content.Intent;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class option extends AppCompatActivity {
Button b,b1,b2,b3,b4;
static  String subject,bh1;
static  int counter=0,bh;
int i=1;
Mydb ob;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        tv=(TextView)findViewById(R.id.textView71);

        tv.setText(loginq.user);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        b=(Button)findViewById(R.id.button6);

        b1=(Button)findViewById(R.id.button7);
        b2=(Button)findViewById(R.id.button8);
        b3=(Button)findViewById(R.id.button10);
        b4=(Button)findViewById(R.id.button9);
        ob=new Mydb(this);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                subject="C";
                Cursor cu = ob.get_quiz(i);
                if (cu.getCount() == 0) {

                    Toast.makeText(option.this, "There are no question set..", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(option.this, start.class);
                    startActivity(i);

                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                subject = "DSA";
                Cursor cu1 = ob.dsa_quiz(i);
                if (cu1.getCount() == 0) {

                    Toast.makeText(option.this, "There are no question set..", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(option.this, dsa.class);
                    startActivity(i);
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                subject = "DBMS";
                Cursor cu1 = ob.dbms_quiz(i);
                if (cu1.getCount() == 0) {

                    Toast.makeText(option.this, "There are no question set..", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(option.this, dbms.class);
                    startActivity(i);
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                subject = "JAVA";
                Cursor cu1 = ob.java_quiz(i);
                if (cu1.getCount() == 0) {

                    Toast.makeText(option.this, "There are no question set..", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(option.this, ujava.class);
                    startActivity(i);
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                subject = "ANDROID";
                Cursor cu1 = ob.android_quiz(i);
                if (cu1.getCount() == 0) {

                    Toast.makeText(option.this, "There are no question set..", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(option.this, android.class);
                    startActivity(i);
                }

            }
        });
    }
}

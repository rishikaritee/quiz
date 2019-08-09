package com.example.quiz;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ujava extends AppCompatActivity {
    TextView t,t1,tv;
    static int marks=0;
    int i=1,k=1;
    RadioGroup rg;
    int c1=0;
    RadioButton op1,op2,op4,op3,op5;
    Mydb obj2;
    Button submit,skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ujava);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        t1=(TextView)findViewById(R.id.textView10);
        tv=(TextView)findViewById(R.id.textView26);
        tv.setText(loginq.user);
        t=(TextView)findViewById(R.id.textView110);
        op1=(RadioButton)findViewById(R.id.radioButton);
        op2=(RadioButton)findViewById(R.id.radioButton2);
        op3=(RadioButton)findViewById(R.id.radioButton3);
        op4=(RadioButton)findViewById(R.id.radioButton4);
        skip=(Button)findViewById(R.id.button12);
        submit=(Button)findViewById(R.id.button13);
        rg=(RadioGroup)findViewById(R.id.q);
        obj2=new Mydb(this);
        try{

            Cursor c=obj2.java_quiz(i);

            if(c.getCount()==0){

                Toast.makeText(ujava.this, "data Not Found", Toast.LENGTH_LONG).show();
            }

            else{

                c.moveToFirst();
                t1.setText(""+i);
                t.setText(c.getString(1));
                op1.setText(c.getString(2));
                op2.setText(c.getString(3));
                op3.setText(c.getString(4));
                op4.setText(c.getString(5));
                op1.setChecked(true);
            }

        }catch (Exception t)
        {

        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i <= 10) {
                    int id = rg.getCheckedRadioButtonId();
                    op5 = (RadioButton) findViewById(id);
                    Cursor c = obj2.java_quiz(i);
                    c.moveToFirst();
                    String st = op5.getText().toString();
                    //  Cursor cn=obj2.cc(st);
                    String a1 = c.getString(6);
                    if (a1.equals(st)) {
                        marks = marks + 4;
                        c1++;
                        Toast.makeText(ujava.this, "Successfully Submitted", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(ujava.this, "Successfully Submitted", Toast.LENGTH_SHORT).show();
                    }

                    i++;
                    if (k <= 10) {
                        try {

                            c = obj2.java_quiz(i);

                            if (c.getCount() == 0) {

                                //Toast.makeText(start.this, "data Not Found", Toast.LENGTH_SHORT).show();
                            } else {


                                c.moveToFirst();

                                t.setText(c.getString(1));
                                op1.setText(c.getString(2));
                                op2.setText(c.getString(3));
                                op3.setText(c.getString(4));
                                op4.setText(c.getString(5));
                                t1.setText("" + i);
                                op1.setChecked(true);
                                k++;
                            }

                        } catch (Exception t) {

                        }
                    }

                } else {
                    Intent j=new Intent(ujava.this,javaresult.class);
                    startActivity(j);
                }

            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ujava.this, "Skipped one question", Toast.LENGTH_SHORT).show();
                i++;
                if(i<=10) {
                    try {

                        Cursor c = obj2.dbms_quiz(i);

                        if (c.getCount() == 0) {

                            Toast.makeText(ujava.this, "data Not Found", Toast.LENGTH_SHORT).show();
                        } else {

                            c.moveToFirst();
                            t1.setText("" + i);
                            t.setText(c.getString(1));
                            op1.setText(c.getString(2));
                            op2.setText(c.getString(3));
                            op3.setText(c.getString(4));
                            op4.setText(c.getString(5));
                            op1.setChecked(true);
                        }

                    }catch (Exception t){

                    }
                }else{
                    Intent i1=new Intent(ujava.this,javaresult.class);
                    startActivity(i1);
                }
            }
        });
    }
}

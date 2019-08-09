package com.example.quiz;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginq extends AppCompatActivity {
TextView tv;
Button b1,b2;
static String user;
EditText ed1,ed2;
Mydb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginq);
        ed1=(EditText) findViewById(R.id.editText2);
        ed2=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        db=new Mydb(this);
        tv=(TextView)findViewById(R.id.textView2);
        String text="New User Register Here";
        SpannableString ss=new SpannableString(text);
        ClickableSpan o1=new ClickableSpan() {
            @Override
            public void onClick( View widget) {
                Intent obj=new Intent(loginq.this,kl.class);
                startActivity(obj);
            }

            @Override
            public void updateDrawState( TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };
        ss.setSpan(o1,8,22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ss);
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                     user=ed1.getText().toString();
                    String pass=ed2.getText().toString();

                    Cursor cr= db.login(user,pass);
                    if(user.isEmpty()||pass.isEmpty()){
                        Toast.makeText(loginq.this, "Please fill details", Toast.LENGTH_SHORT).show();
                    }
                  else if(cr.getCount()==0){
                       cln();
                        Toast.makeText(loginq.this, "Try again", Toast.LENGTH_SHORT).show();
                    }

                     else {
                        cr.moveToFirst();
                        String us = cr.getString(1);
                        String password = cr.getString(2);
                        if (us.equals(user) && password.equals(pass)) {

                            Toast.makeText(loginq.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(loginq.this,guide.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(loginq.this, "invalid user& password", Toast.LENGTH_SHORT).show();

                        }


                    }
                }catch (Exception e){
                    Toast.makeText(loginq.this, "Try Again..", Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=ed1.getText().toString();
                String pass=ed2.getText().toString();
                if(user.equals("Rishika")&& pass.equals("123")) {
                    Intent i = new Intent(loginq.this, admin1.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(loginq.this, "INCORRECT ID AND Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public  void cln(){
        ed1.setText(null);
        ed2.setText(null);
        ed1.requestFocus();
    }
}

package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class guide extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        Button b=(Button)findViewById(R.id.button4);
        tv=(TextView)findViewById(R.id.textView71);

        tv.setText(loginq.user);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent k=new Intent(guide.this,option.class);
                startActivity(k);

            }
        });
    }
}

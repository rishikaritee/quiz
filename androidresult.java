package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.quiz.android.marks;

public class androidresult extends AppCompatActivity {
    TextView tv,tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidresult);
        tv=(TextView)findViewById(R.id.textView17);
        tv1=(TextView)findViewById(R.id.textView20);
        tv2=(TextView)findViewById(R.id.textView171);
        tv3=(TextView)findViewById(R.id.textView23);
        tv4=(TextView)findViewById(R.id.textView24);
        tv.setText(loginq.user);
        tv1.setText(option.subject);
        tv2.setText("40");


        tv3.setText(""+marks);
        if(marks>=30) {
            tv4.setText("A");
        }
        else if (marks>=20&&marks<30) {
            tv4.setText("B");
        }
        else if (marks>=10&&marks<20) {
            tv4.setText("C");
        }
        else  {
            tv4.setText("FAIL");
        }
    }
}

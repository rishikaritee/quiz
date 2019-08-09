package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread obj = new Thread(){
            public void run () {
                try {
                    sleep(4000);
                } catch (Exception t) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                } finally {
                    Intent i = new Intent(MainActivity.this, loginq.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        obj.start();
    }
}

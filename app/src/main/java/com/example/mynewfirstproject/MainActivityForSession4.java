package com.example.mynewfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityForSession4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_session4);
        Button btnProfile=findViewById(R.id.btnProfileId);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivityForSession4.this,ActivityProfile.class);
                startActivity(i);
            }
        });

        Button btnDial=findViewById(R.id.btnDialId);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivityForSession4.this,DialActivity.class);
                startActivity(i);
            }
        });
    }
}

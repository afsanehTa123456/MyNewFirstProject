package com.example.mynewfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);


        final EditText edtnum = findViewById(R.id.edtPhonId);
        Button btnDial = findViewById(R.id.btnDId);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + edtnum.getText().toString()));
                startActivity(i);
                Toast.makeText(DialActivity.this, "ADD TO DIAL", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

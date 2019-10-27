package com.example.mynewfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.preference.PreferenceManager;


public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        final TextView txtUName=findViewById(R.id.etxUNameId);
        final TextView txtLName=findViewById(R.id.etxLNameId);
        final TextView txtMailAdd=findViewById(R.id.etxMailId);
        final TextView txtAges=findViewById(R.id.etxAgeId);
        Button editbtns =findViewById(R.id.btnEditId);
        Button btnOk=findViewById(R.id.btnOkId);
        Intent i=getIntent();


        txtUName.setText(i.getStringExtra("UserName"));
        txtLName.setText(i.getStringExtra("LastName"));
        txtAges.setText(i.getStringExtra("age"));
        txtMailAdd.setText(i.getStringExtra("MailAddress"));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();

                String UserName=txtUName.getText().toString();
                i.putExtra("UserName",UserName);

                String LastName=txtLName.getText().toString();
                i.putExtra("LastName",LastName);

                String MailAddress=txtMailAdd.getText().toString();
                i.putExtra("MailAddress",MailAddress);

                String Age=txtAges.getText().toString();
                i.putExtra("Age",Age);

                setResult(Activity.RESULT_OK,i);

                Toast.makeText(ReviewActivity.this,"successful!",Toast.LENGTH_LONG).show();
                finish();

            }
        });

        editbtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent();
                i.putExtra("UserName",txtUName.getText());
                i.putExtra("LastName",txtLName.getText());
                i.putExtra("Age",txtAges.getText());
                i.putExtra("MailAddress",txtMailAdd.getText());

                PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this).getString("UserName",txtUName.getText().toString());
                PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this) .getString("LastName",txtLName.getText().toString());
                PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this) .getString("Age",txtAges.getText().toString());
                PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this) .getString("MailAddress",txtMailAdd.getText().toString());
                setResult(ActivityProfile.RESULT_CANCELED);
                Toast.makeText(ReviewActivity.this,"retry",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}

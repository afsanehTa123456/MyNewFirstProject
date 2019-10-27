package com.example.mynewfirstproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button btnRev=findViewById(R.id.btnReviewId);
        final EditText edtAgeText=findViewById(R.id.etxAgeId);
        final EditText edtUNameText=findViewById(R.id.etxUNameId);
        final EditText edtLastNameText=findViewById(R.id.etxLNameId);
        final EditText edtMailText=findViewById(R.id.etxMailId);

        btnRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityProfile.this,ReviewActivity.class);
                String userName= edtUNameText.getText().toString();

                i.putExtra("userName",userName);

                String lName= edtLastNameText.getText().toString();
                i.putExtra("lName",lName);

                String mailAdd= edtMailText.getText().toString();
                i.putExtra("mailAdd",mailAdd);

                String age= edtAgeText.getText().toString();
                i.putExtra("age",age);

                startActivityForResult(i,360);
                Toast.makeText(ActivityProfile.this,"btnRev",Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==360){
            if(resultCode==Activity.RESULT_OK ){
               String userName=data.getStringExtra("userName");
                String lName=data.getStringExtra("lName");
                String mailAdd=data.getStringExtra("mailAdd");
                String age=data.getStringExtra("age");

                PreferenceManager.getDefaultSharedPreferences(ActivityProfile.this).edit().putString("name",data.getStringExtra("userName")).apply();
                PreferenceManager.getDefaultSharedPreferences(ActivityProfile.this).edit().putString("lName",data.getStringExtra("lName")).apply();
                PreferenceManager.getDefaultSharedPreferences(ActivityProfile.this).edit().putString("mailAdd",data.getStringExtra("mailAdd")).apply();
                PreferenceManager.getDefaultSharedPreferences(ActivityProfile.this).edit().putString("age",data.getStringExtra("age")).apply();

            }
        }
    }
}

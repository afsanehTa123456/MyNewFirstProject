package com.example.mynewfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("mytag","In onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mytag","In onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mytag","In onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("mytag","In onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mytag","In onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mytag","In onDestroy");
    }
}

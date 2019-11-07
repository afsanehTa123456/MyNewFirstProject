package com.example.mynewfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class newRecycleView extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recycle_view);
        RecyclerView RecycleId=findViewById(R.id.RecycleId);
        Button button3 = findViewById(R.id.BtnNavId);

        ArrayList<String> list=new ArrayList<>();
        ArrayList<DataModel> animalNames = new ArrayList<>();
        animalNames.add(new DataModel(R.drawable.dial,"Dial"));
        animalNames.add(new DataModel(R.drawable.profile,"Profile"));

       RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recycler.setAdapter(adapter);
        //
        ImageView img = findViewById(R.id.Imgbtn);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
                drawerLayout.openDrawer(Gravity.LEFT);
                TextView _TextView = findViewById(R.id.txtChange);
                _TextView.setText("varand");
            }
        });


    }
    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        if (adapter.getItem(position).name == "Dial")
        {
            Intent intent = new Intent(newRecycleView.this,DialActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(newRecycleView.this,ActivityProfile.class);
            startActivity(intent);
        }
    }
}

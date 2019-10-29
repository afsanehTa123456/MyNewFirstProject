package com.example.mynewfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class newRecycleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recycle_view);
        RecyclerView RecycleId=findViewById(R.id.RecycleId);
        Button button3 = findViewById(R.id.BtnNavId);

        ArrayList<String> list=new ArrayList<>();
        list.add("PROFILE");
        list.add("DIAL");
        list.add("...");

        RecyclerView recycler = findViewById(R.id.recycler);

        recyclerAdapter adapter=new recyclerAdapter(list);
        RecycleId.setAdapter(adapter);
        RecycleId.setLayoutManager(new LinearLayoutManager(newRecycleView.this,RecyclerView.VERTICAL,false));
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawerLayout= findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}

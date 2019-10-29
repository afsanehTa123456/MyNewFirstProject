package com.example.mynewfirstproject;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.testRecyclerviewHolder>{
    ArrayList<String> mylist;

    public recyclerAdapter(ArrayList list){
mylist=list;

    }
    @NonNull
    @Override
    public testRecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycles,parent,false);
        testRecyclerviewHolder holder=new testRecyclerviewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull testRecyclerviewHolder holder, int position) {
holder.txtRecycle.setText(mylist.get(position));
        if(holder.txtRecycle.getText()=="PROFILE"){
            holder.txtRecycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),ActivityProfile.class);
                    v.getContext().startActivity(intent);
                }
            });
        } if(holder.txtRecycle.getText() == "DIAL"){
            holder.txtRecycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),DialActivity.class);
                    v.getContext().startActivity(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class testRecyclerviewHolder extends RecyclerView.ViewHolder{
        TextView txtRecycle;

    public testRecyclerviewHolder(@NonNull View itemView) {
        super(itemView);
        txtRecycle=itemView.findViewById(R.id.RecycleId);
    }
}
}

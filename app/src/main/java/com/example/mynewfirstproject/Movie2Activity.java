package com.example.mynewfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cz.msebera.android.httpclient.Header;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
public class Movie2Activity extends AppCompatActivity implements MyMoviesViewAdapter.ItemClickListener,MyRecyclerViewAdapter.ItemClickListener{
    MyMoviesViewAdapter adapter;
    MyRecyclerViewAdapter adapterLeft;
    //ArrayList<Search> MoviesArry;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie2);

        //
        ArrayList<DataModel> animalNames = new ArrayList<>();
        //animalNames.add(new DataModel(R.drawable.dial,"Dial"));
       // animalNames.add(new DataModel(R.drawable.profile,"Profile"));
      //  animalNames.add(new DataModel(R.drawable.movie,"Movie Search"));
        //animalNames.add(new DataModel(R.drawable.camera,"Camera"));
        //
        RecyclerView recyclerView = findViewById(R.id.rvContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(Movie2Activity.this));
        adapterLeft = new MyRecyclerViewAdapter(Movie2Activity.this, animalNames);
        adapterLeft.setClickListener(Movie2Activity.this);
        recyclerView.setAdapter(adapterLeft);

        //

        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient tt = new AsyncHttpClient();
                EditText edtMovie = findViewById(R.id.edtMovie);
                String Url = "http://www.omdbapi.com/?s="+edtMovie.getText()+"&apikey=b80e72c2";// + intent.getStringExtra("ItemID");

                AsyncHttpClient client = new AsyncHttpClient();
                client.get(Url, new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("hello", responseString);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        try {
                            Log.d("hello", "1");
                            //MoviesArry= (ArrayList<Search>) new ArrayList<>();
                            JSONObject jsonobject = new JSONObject(responseString);
                            JSONArray jsonoArray = new JSONArray(jsonobject.getString("Search"));
                            for (int i = 0; i < jsonoArray.length(); i++) {
                                JSONObject jsonSub = jsonoArray.getJSONObject(i);
                                //MoviesArry.add(new Search(jsonSub.getString("Poster"),jsonSub.getString("Title"),jsonSub.getString("Year"),jsonSub.getString("imdbID"),"","",""));

                            }
                            RecyclerView recyclerView = findViewById(R.id.resnewMovies);
                            recyclerView.setLayoutManager(new LinearLayoutManager(Movie2Activity.this));
                           // adapter = new MyMoviesViewAdapter(Movie2Activity.this, MoviesArry);
                            adapter.setClickListener(Movie2Activity.this);
                            //recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            Log.d("hello",  e.getMessage());
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        //Gson gson= new Gson();
        //Movies weather= gson.fromJson(responseString, Movies.class);
        //String temp = weather.getSearch().get(0).getTitle();
        //Log.d("varand22", String.valueOf(weather.));
        //String temp = weather.getStatus().toString();





        //
        //RecyclerView recyclerView = findViewById(R.id.rvContacts);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ///adapter = new MyMoviesViewAdapter(this, animalNames);
        //adapter.setClickListener(this);
        //recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {
        if (adapterLeft.getItem(position).name == "Dial" )
        {
            Intent intent = new Intent(Movie2Activity.this,DialPlace.class);
            startActivity(intent);
        }
        else if (adapterLeft.getItem(position).name == "Profile")
        {
            Intent intent = new Intent(Movie2Activity.this,SecPage.class);
            startActivity(intent);
        }
        else if (adapterLeft.getItem(position).name == "Movie Search")
        {

        }
        else if (adapterLeft.getItem(position).name == "Camera")
        {
            Intent intent = new Intent(Movie2Activity.this,CameraActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onItemClickMovie(View view, int position) {
        Intent intent = new Intent(Movie2Activity.this, MDetail2Activity.class);
        //intent.putExtra("imdbCode", MoviesArry.get(position).getImdbID());
        startActivity(intent);
    }
}
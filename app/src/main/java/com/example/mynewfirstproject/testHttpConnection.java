package com.example.mynewfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class testHttpConnection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_http_connection);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL obj = new URL("https://google.com");

                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", "Mozilla/5.0");

                    int responseCode = con.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {

                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                con.getInputStream()));

                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }


                        System.out.println(response.toString());

                        JSONObject object=new JSONObject(response.toString());
                         String resault=object.getString("data");
                        JSONObject object1=new JSONObject(resault);
                        String resault1=object1.getString("timings");

                        JSONObject object2=new JSONObject(resault1);
                        String resalu2=object2.getString("Dhuhr");
                        System.out.println(resalu2);

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();


    }
}

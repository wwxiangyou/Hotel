package com.danke7.hotel;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;

public class SearchActivity extends AppCompatActivity {

    private static ArrayList<String> hotel_list = new ArrayList<String>();
    private ListView lv;
    private ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        lv = (ListView) findViewById(R.id.hotel_list);
        ad = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, hotel_list);
        lv.setAdapter(ad);


    }

    public  void startSearch(View view){
        /*
        String keyword = ((EditText) findViewById(R.id.search_message)).getText().toString();
        try {
            JSONObject result = jsonBinder.get_hotel_list("0", "10");
            if ( result.getInt("RESULT") == 30041) {
                hotel_list.clear();
                JSONArray hotel_array = result.getJSONArray("HOTEL");
                for (int i = 0; i < hotel_array.length(); i++) {
                    JSONObject json_hotel = hotel_array.getJSONObject(i);
                    String hotel_name = json_hotel.getString("HOTELNAME");
                    String price = json_hotel.getString("PRICE");
                    String address = json_hotel.getString("ADDRESS");
                    hotel_list.add(hotel_name + " " + price + " " + address);
                }
            } else if (result.getInt("RESULT") == 30042) {
                hotel_list.clear();
                hotel_list.add("没有合适的酒店");
            }
        } catch (Exception e) {
            hotel_list.add("无法进行查询");
            e.printStackTrace();
            }

            ad.notifyDataSetChanged();
            */
        Intent intent=new Intent(this,MainScreenActivity.class);
        startActivity((intent));
    }
}

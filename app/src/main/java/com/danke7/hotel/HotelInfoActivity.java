package com.danke7.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelInfoActivity extends AppCompatActivity {

    private ListView listView;

    private Button buttonBack;
    private Button buttonBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_info);

        listView=(ListView)findViewById(R.id.listViewInfo);
        buttonBack=(Button)findViewById(R.id.buttonCancel);
        buttonBook=(Button)findViewById(R.id.buttonBook);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.listview_hotelinfo,
                new String[]{"title_info","img_info","position","roomtype","roomnumber","roomprice"},
                new int[]{R.id.title_info,R.id.img_info,R.id.position,R.id.roomtype,R.id.roomnumber,R.id.roomprice});
        listView.setAdapter(adapter);

        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelInfoActivity.this, BookRoomActivity.class);
                startActivity(intent);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelInfoActivity.this.finish();
            }
        });
    }

    private List<Map<String,Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        //todo:query data
        map.put("title_info", "酒店1");
        map.put("img_info", R.drawable.img1);
        map.put("position","地点：张江");
        map.put("roomtype","房间类型：双人");
        map.put("roomnumber","房间数量：50间");
        map.put("roomprice","价格：200/晚");
        list.add(map);

        return list;
    }
}

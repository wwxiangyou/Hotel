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

public class OrderInfoActivity extends AppCompatActivity {

    private ListView listView;

    private Button buttonBack;
    private Button buttonFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);

        listView=(ListView)findViewById(R.id.listViewInfo);
        buttonBack=(Button)findViewById(R.id.buttonCancel);
        buttonFeedback=(Button)findViewById(R.id.buttonFeedback);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.listview_orderinfo,
                new String[]{"order_id","hotel_name","hotel_address","room_name","room_number","QRCode_info"},
                new int[]{R.id.order_id,R.id.hotel_name,R.id.hotel_address,R.id.room_name,R.id.room_number,R.id.QRCode_info});
        listView.setAdapter(adapter);

        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderInfoActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderInfoActivity.this.finish();
            }
        });
    }

    private List<Map<String,Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
		
        //todo:query data according to the username and form the QRcode 
		map.put("order_id", "0011001");
        map.put("hotel_name", "酒店1");
		map.put("hotel_address","地点：张江");
        map.put("room_name","房间名：1001");
        map.put("room_number","房间数量：1间");
		map.put("QRCode_info", R.drawable.img1);
        list.add(map);
		
        return list;
    }
}

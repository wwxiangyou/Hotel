package com.danke7.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManagementActivity extends AppCompatActivity {

    private List<String> HotelNameList=new ArrayList<String>();
    private List<String> HotelAddressList=new ArrayList<String>();
    private List<String> RoomNameList=new ArrayList<String>();
    private Spinner spinnerHotelName;
    private Spinner spinnerHotelAddress;
    private ArrayAdapter<String> HotelNameAdapter;
    private ArrayAdapter<String> HotelAddressAdapter;
    private ArrayAdapter<String> RoomNameAdapter;
	
    private ListView listView;
    private List<Map<String, Object>> listViewData;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_management);

        //对应xml文件
		spinnerHotelName=(Spinner)findViewById(R.id.spinnerHotelName);
        spinnerHotelAddress=(Spinner)findViewById(R.id.spinnerHotelAddress);
        listView=(ListView)findViewById(R.id.listViewList);


        //spinner issues
        //TODO:
        HotelNameList.add("酒店名");
        HotelNameList.add("如家快捷酒店");
        HotelNameList.add("汉庭酒店");
        HotelNameList.add("其他");
        HotelNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, HotelNameList);
        HotelNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHotelName.setAdapter(HotelNameAdapter);
        spinnerHotelName.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Do Query
                System.out.println("Something Selected on Spinner Position");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Do Nothing
                System.out.println("Nothing Selected on Spinner Position");
            }
        });

        List.add("地址");
        HotelAddressList.add("张江");
        HotelAddressList.add("外滩");
		HotelAddressList.add("其他");
        HotelAddressAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, HotelAddressList);
        HotelAddressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHotelAddress.setAdapter(HotelAddressAdapter);
        spinnerHotelAddress.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Do Query
                Log.d("spinner", "Something Selected on Spinner Price");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Do Nothing
                Log.d("spinner", "Nothing Selected on Spinner Price");
            }
        });


        //listView issues
        listViewData=getData();
        SimpleAdapter adapter = new SimpleAdapter(this,listViewData,R.layout.listview_orderlist,
                new String[]{"orderid_list","hotelname_list","hoteladdress_list","roomname_list","roomnumber_list","QRCode_list"},
                new int[]{R.id.orderid_list,R.id.hotelname_list,R.id.hoteladdress_list,R.id.roomname_list,R.id.roomnumber_list,R.id.QRCode_list});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("OrderManagement Listview", "Clicked: " + (String)listViewData.get(position).get("title"));
                //todo:transfer data to new Activity
                Intent intent=new Intent(OrderManagementActivity.this,OrderInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        //todo:query data according to the username and form the QRcode 
        map.put("orderid_list", "1011001");
        map.put("hotelname_list", "如家快捷酒店");
        map.put("hoteladdress_list", "张江");
		map.put("roomname_list", "1001");
        map.put("roomnumber_list", "1");
        map.put("QRCode_list", R.drawable.img1);
        list.add(map);

        map = new HashMap<>();

        map.put("orderid_list", "1021002");
        map.put("hotelname_list", "汉庭酒店");
        map.put("hoteladdress_list", "外滩");
		map.put("roomname_list", "1002");
        map.put("roomnumber_list", "1");
        map.put("QRCode_list", R.drawable.img1);
        list.add(map);

        return list;
    }
}

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

public class MainScreenActivity extends AppCompatActivity {

    private List<String> postionList=new ArrayList<String>();
    private List<String> priceList=new ArrayList<String>();
    private List<String> typeList=new ArrayList<String>();
    private Spinner spinnerPosition;
    private Spinner spinnerPrice;
    private Spinner spinnerType;
    private ArrayAdapter<String> positionAdapter;
    private ArrayAdapter<String> priceAdapter;
    private ArrayAdapter<String> typeAdapter;

    private SearchView searchView;

    private ListView listView;
    private List<Map<String, Object>> listViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        spinnerPosition=(Spinner)findViewById(R.id.spinnerPosition);
        spinnerPrice=(Spinner)findViewById(R.id.spinnerPrice);
        spinnerType=(Spinner)findViewById(R.id.spinnerType);
        searchView=(SearchView)findViewById(R.id.searchView);
        listView=(ListView)findViewById(R.id.listViewList);

        //searchView Issues
        searchView.setIconified(false);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                // to avoid click x button and the edittext hidden
                return true;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            public boolean onQueryTextSubmit(String query) {
                //Todo:Do Query
                System.out.println("Search query string is : "+query);

                return true;
            }

            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });


        //spinner issues
        //TODO: Positioning and add position to postionList
        postionList.add("位置");
        postionList.add("高科苑");
        postionList.add("复旦大学");
        postionList.add("其他");
        positionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, postionList);
        positionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPosition.setAdapter(positionAdapter);
        spinnerPosition.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
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

        priceList.add("价格");
        priceList.add("100-200/晚");
        priceList.add("200以上/晚");
        priceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, priceList);
        priceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrice.setAdapter(priceAdapter);
        spinnerPrice.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
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

        typeList.add("类型");
        typeList.add("三星");
        typeList.add("四星");
        typeList.add("五星");
        typeAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,typeList);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(typeAdapter);
        spinnerType.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Do Query
                System.out.println("Something Selected on Spinner Type");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Do Nothing
                System.out.println("Nothing Selected on Spinner Type");
            }
        });

        //listView issues
        listViewData=getData();
        SimpleAdapter adapter = new SimpleAdapter(this,listViewData,R.layout.listview_hotellist,
                new String[]{"title_list","info_list","img_list"},
                new int[]{R.id.title_list,R.id.info_list,R.id.img_list});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("MainScreen Listview", "Clicked: " + (String)listViewData.get(position).get("title"));
                //todo:transfer data to new Activity
                Intent intent=new Intent(MainScreenActivity.this,HotelInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        //todo:query data
        map.put("title_list", "酒店1");
        map.put("info_list", "三星、100-500/晚");
        map.put("img_list", R.drawable.img1);
        list.add(map);

        map = new HashMap<>();
        //todo:query data
        map.put("title_list", "酒店2");
        map.put("info_list", "四星、500-1000/晚");
        map.put("img_list", R.drawable.img2);
        list.add(map);

        return list;
    }
}

package com.danke7.hotel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRoomActivity extends AppCompatActivity {

    private List<String> typeList=new ArrayList<String>();
    private Spinner spinnerType;
    private ArrayAdapter<String> adpaterSType;
    
    private TextView textViewHotelName;
    private TextView textViewRoomPrice;
    
    private EditText editTextNightNumber;
    private EditText editTextRoomNumber;
    
    private Button buttonAdd;
    private Button buttonDelete;
    private Button buttonCancel;
    private Button buttonConfirm;

    private ListView listView;
    private List<Map<String,Object>> listViewData;
    private SimpleAdapter adapter;
    private boolean listFlag=false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);
        
        spinnerType=(Spinner)findViewById(R.id.spinnerRoomType);
        textViewHotelName=(TextView)findViewById(R.id.textViewHotelName);
        textViewRoomPrice=(TextView)findViewById(R.id.textViewRoomPrice);
        editTextNightNumber=(EditText)findViewById(R.id.editTextNightNumber);
        editTextRoomNumber=(EditText)findViewById(R.id.editTextRoomNumber);
        buttonAdd=(Button)findViewById(R.id.buttonAdd);
        buttonCancel=(Button)findViewById(R.id.buttonCancel);
        buttonConfirm=(Button)findViewById(R.id.buttonConfirm);
        buttonDelete=(Button)findViewById(R.id.buttonDelete);
        listView=(ListView)findViewById(R.id.listViewBook);

        textViewHotelName.setText("酒店1");

        typeList.add("类型");
        typeList.add("双人间");
        typeList.add("单人间");
        adpaterSType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeList);
        adpaterSType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adpaterSType);
        spinnerType.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO: Do Query
                switch (position) {
                    case (0):
                        onNothingSelected(parent);
                        break;
                    case (1):
                        textViewRoomPrice.setText("200");
                        break;
                    case (2):
                        textViewRoomPrice.setText("100");
                        break;
                }
                System.out.println("Something Selected on Spinner RoomType");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Do Nothing
                System.out.println("Nothing Selected on Spinner RoomType");
            }
        });

        listViewData=listViewInit();
        adapter = new SimpleAdapter(this,listViewData,R.layout.listview_booklist,
                new String[]{"rtype","rprice","nnumber","rnumber","rcost"},
                new int[]{R.id.rtype,R.id.rprice,R.id.nnumber,R.id.rnumber,R.id.rcost});
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nightNumber = editTextNightNumber.getText().toString();
                String roomNumber = editTextRoomNumber.getText().toString();
                String roomType=spinnerType.getSelectedItem().toString();
                String roomPrice=textViewRoomPrice.getText().toString();

                System.out.println(nightNumber);
                System.out.println(roomNumber);
                System.out.println(roomType);
                System.out.println(roomPrice);

                Map<String, Object> map = new HashMap<>();
                //todo:query data
                map.put("rtype",roomType);
                map.put("rprice", roomPrice+"/晚");
                map.put("nnumber", nightNumber+"天");
                map.put("rnumber", roomNumber+"间");
                int cost1=Integer.parseInt(roomPrice);
                int cost2=Integer.parseInt(nightNumber);
                int cost3=Integer.parseInt(roomNumber);
                map.put("rcost","共"+String.format("%d",cost1*cost2*cost3)+"元");

                if(listFlag==true){
                    listViewData.clear();
                }
                listViewData.add(map);
                adapter=new SimpleAdapter(BookRoomActivity.this,listViewData,R.layout.listview_booklist,
                        new String[]{"rtype","rprice","nnumber","rnumber","rcost"},
                        new int[]{R.id.rtype,R.id.rprice,R.id.nnumber,R.id.rnumber,R.id.rcost});
                listView.setAdapter(adapter);
                listFlag=false;
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookRoomActivity.this.finish();
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: Parse Server Sentback
                AlertDialog.Builder builder = new AlertDialog.Builder(BookRoomActivity.this);
                builder.setTitle("消息");
                builder.setMessage("预订成功");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(BookRoomActivity.this,MainScreenActivity.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewData=listViewInit();
                adapter=new SimpleAdapter(BookRoomActivity.this,listViewData,R.layout.listview_booklist,
                        new String[]{"rtype","rprice","nnumber","rnumber","rcost"},
                        new int[]{R.id.rtype,R.id.rprice,R.id.nnumber,R.id.rnumber,R.id.rcost});
                listView.setAdapter(adapter);
            }
        });
    }

    private List<Map<String,Object>> listViewInit(){
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        //todo:query data
        map.put("rtype","请添加订单");
        map.put("rprice", "");
        map.put("nnumber","");
        map.put("rnumber","");
        map.put("rcost","");
        list.add(map);

        listFlag=true;
        return list;
    }
}

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

public class FeedBackActivity extends AppCompatActivity {

    private List<String> typeList=new ArrayList<String>();
    private ArrayAdapter<String> adpaterSType;
    
    private TextView textViewComment;
	private TextView textViewPhotoDisplay;
	private TextView textViewScore;
    private TextView textViewComplain;

    
    private EditText editTextComment;
    private EditText editTextScore;
	private EditText editTextComplain;
    
	
	private Button buttonAdd;
	private Button buttonUploadPhoto;
	private Button buttonCancel;
    private Button buttonSubmit;

    private ListView listView;
    private List<Map<String,Object>> listViewData;
    private SimpleAdapter adapter;
    private boolean listFlag=false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        
        textViewComment=(TextView)findViewById(R.id.textViewComment);
		editTextComment=(EditText)findViewById(R.id.editTextComment);
        textViewPhotoDisplay=(TextView)findViewById(R.id.textViewPhotoDisplay);
		buttonUploadPhoto=(Button)findViewById(R.id.buttonUploadPhoto);
		textViewScore=(TextView)findViewById(R.id.textViewScore);
		editTextScore=(EditText)findViewById(R.id.editTextScore);
		textViewComplain=(TextView)findViewById(R.id.textViewComplain);
		editTextComplain=(EditText)findViewById(R.id.editTextComplain);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        buttonCancel=(Button)findViewById(R.id.buttonCancel);
     
		
		
	    /*buttonUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextComment = editTextComment.getText().toString();
                String TextScore = editTextScore.getText().toString();
                String TextComplain= editTextComplain.getText().toString();

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
        });*/

		buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				String TextComment = editTextComment.getText().toString();
                String TextScore = editTextScore.getText().toString();
                String TextComplain= editTextComplain.getText().toString();
                //Todo: Parse Server Sentback
                AlertDialog.Builder builder = new AlertDialog.Builder(FeedbackActivity.this);
                builder.setTitle("反馈");
                builder.setMessage("提交成功");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FeedbackActivity.this.finish();
                    }
                });
                builder.show();
            }
        });
		
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackActivity.this.finish();
            }
        });

     
    }

    /*private List<Map<String,Object>> listViewInit(){
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
    }*/
}

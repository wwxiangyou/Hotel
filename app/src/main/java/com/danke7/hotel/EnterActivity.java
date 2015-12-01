package com.danke7.hotel;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TabHost;

import cn.smssdk.SMSSDK;

public class EnterActivity extends TabActivity {
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        tabHost = this.getTabHost();

        TabHost.TabSpec spec;
        Intent intent;
        intent=new Intent().setClass(this, MainScreenActivity.class);
        spec=tabHost.newTabSpec("酒店").setIndicator("酒店").setContent(intent);
        tabHost.addTab(spec);
        intent=new Intent().setClass(this, OrderActivity.class);
        spec=tabHost.newTabSpec("订单").setIndicator("订单").setContent(intent);
        tabHost.addTab(spec);
        intent=new Intent().setClass(this, ProfileActivity.class);
        spec=tabHost.newTabSpec("我").setIndicator("我").setContent(intent);
        tabHost.addTab(spec);
        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_tab_search:
                        tabHost.setCurrentTabByTag("酒店");
                        break;
                    case R.id.main_tab_order:
                        tabHost.setCurrentTabByTag("订单");
                        break;
                    case R.id.main_tab_profile:
                        tabHost.setCurrentTabByTag("我");
                        break;
                    default:
                        tabHost.setCurrentTabByTag("酒店");
                        break;
                }
            }
        });
        Context ctx = EnterActivity.this;
        SharedPreferences sp = ctx.getSharedPreferences("SP", MODE_WORLD_READABLE);
        //存入数据
        SharedPreferences.Editor editor = sp.edit();
        editor.commit();

        if(sp.getBoolean("SET_LOCK", false) ){
            Intent intent2;
            intent2 = new Intent().setClass(EnterActivity.this, VerifyLockActivity.class);
            startActivity(intent2);
        }
    }
}

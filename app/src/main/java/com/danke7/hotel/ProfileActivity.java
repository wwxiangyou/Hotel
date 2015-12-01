package com.danke7.hotel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Context ctx = ProfileActivity.this;
        SharedPreferences sp = ctx.getSharedPreferences("SP", MODE_WORLD_READABLE);
        //存入数据
        SharedPreferences.Editor editor = sp.edit();
        editor.commit();

        if(!sp.getBoolean("LOGIN", false)){
            Intent intent=new Intent(ProfileActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }

}

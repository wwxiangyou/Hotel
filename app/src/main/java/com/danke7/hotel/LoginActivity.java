package com.danke7.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }
    private void findViews(){
        Button comify_button =(Button) this.findViewById(R.id.comify_code);
        comify_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent().setClass(LoginActivity.this, SetLockActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });
    }

}

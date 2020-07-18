package com.example.dutyregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout userLay,adminLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userLay = findViewById(R.id.userLay);
        adminLay = findViewById(R.id.adminLay);

        adminLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminLogin adminLogin = new AdminLogin(getApplicationContext());
                adminLogin.show(getSupportFragmentManager(),"blah");
            }
        });

        userLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLogin userLogin = new UserLogin(getApplicationContext());
                userLogin.show(getSupportFragmentManager(),"blah");
            }
        });
    }
}

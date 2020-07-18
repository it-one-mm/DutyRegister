package com.example.dutyregister;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserMainPanel extends AppCompatActivity {

    Calendar c = Calendar.getInstance();
    SimpleDateFormat df,tf;
    String dateRes,timeRes;

    TextView checkInT,checkOutT,breakOutT,breakInT,daTe;
    Button addCI,addCO,addBI,addBO,saVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_panel);

        daTe = findViewById(R.id.daTe);
        addBO = findViewById(R.id.addBO);
        addBI = findViewById(R.id.addBI);
        addCO = findViewById(R.id.addCO);
        breakOutT = findViewById(R.id.breakOutT);
        breakInT = findViewById(R.id.breakInT);
        checkOutT = findViewById(R.id.checkOutT);
        addCI = findViewById(R.id.addCI);
        checkInT = findViewById(R.id.checkInT);
        saVe = findViewById(R.id.saVe);


        addBI.setEnabled(false);
        addBO.setEnabled(false);
        addCO.setEnabled(false);
        saVe.setEnabled(false);

        saVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userdao dao = new Userdao(getApplicationContext());
                dao.addDate(daTe.getText().toString().trim()
                        ,checkInT.getText().toString().trim()
                        ,breakOutT.getText().toString().trim()
                        ,breakInT.getText().toString().trim()
                        ,checkOutT.getText().toString().trim());
                daTe.setText("Daily Records");
                checkInT.setText("00:00");
                breakOutT.setText("00:00");
                breakInT.setText("00:00");
                checkOutT.setText("00:00");
                saVe.setEnabled(false);
                addCI.setEnabled(true);
            }
        });

        checkInT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCI.setVisibility(View.VISIBLE);
            }
        });

        checkOutT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCO.setVisibility(View.VISIBLE);
            }
        });

        breakOutT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBO.setVisibility(View.VISIBLE);
            }
        });

        breakInT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBI.setVisibility(View.VISIBLE);
            }
        });

        addCI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                df = new SimpleDateFormat("yyyy-MM-dd");
                tf = new SimpleDateFormat("HH:mm:ss");

                dateRes = df.format(c.getTime());
                timeRes = tf.format(c.getTime());
                checkInT.setText(timeRes);
                daTe.setText("Date :"+dateRes);

                addCO.setEnabled(true);
                addBO.setEnabled(true);
                addCI.setEnabled(false);
            }
        });

        addCO.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tf = new SimpleDateFormat("HH:mm:ss");

                timeRes = tf.format(c.getTime());
                checkOutT.setText(timeRes);
                addCO.setEnabled(false);
                saVe.setEnabled(true);
            }
        });

        addBO.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tf = new SimpleDateFormat("HH:mm:ss");

                timeRes = tf.format(c.getTime());
                breakOutT.setText(timeRes);
                addBI.setEnabled(true);
                addCO.setEnabled(false);
                addBO.setEnabled(false);
            }
        });

        addBI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tf = new SimpleDateFormat("HH:mm:ss");

                timeRes = tf.format(c.getTime());
                breakInT.setText(timeRes);
                addCO.setEnabled(true);
                addBI.setEnabled(false);
            }
        });

    }
}

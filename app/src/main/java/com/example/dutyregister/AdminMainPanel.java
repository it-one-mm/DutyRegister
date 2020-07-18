package com.example.dutyregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdminMainPanel extends AppCompatActivity {

    FloatingActionButton floAdd;
    ListView userListView;
    BottomAppBar botApp;
    Userdao userdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_panel);

        floAdd = findViewById(R.id.floAdd);
        userListView = findViewById(R.id.userViewList);
        botApp = findViewById(R.id.botApp);
        userdao = new Userdao(getApplicationContext());

        loadUser();

        botApp.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.setting)
                {
                    Toast.makeText(getApplicationContext(),"Now You Press Setting Key.",Toast.LENGTH_LONG).show();
                }
                else if (item.getItemId() == R.id.about)
                {
                    Toast.makeText(getApplicationContext(),"Now You Press About Key.",Toast.LENGTH_LONG).show();
                }
                else if (item.getItemId() == R.id.reFresh)
                {
                    loadUser();
                    Toast.makeText(getApplicationContext(),"Now You Press Refresh Key.",Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

        floAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser adduser = new adduser(getApplicationContext());
                adduser.show(getSupportFragmentManager(),"blah");
            }
        });

    }

    public void loadUser()
    {
        AdminAdapter adapter = new AdminAdapter(getLayoutInflater(),getApplicationContext(),userdao.getuserNames());
        userListView.setAdapter(adapter);
    }

}

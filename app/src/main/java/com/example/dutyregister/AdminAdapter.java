package com.example.dutyregister;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminAdapter extends BaseAdapter {

    String TBName = "work";
    String ColId = "Id";
    String ColName = "Name";

    LayoutInflater inflater;
    Context context;
    ArrayList<userModel> users;

    public AdminAdapter(LayoutInflater inflater, Context context, ArrayList<userModel> users) {
        this.inflater = inflater;
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View myView = inflater.inflate(R.layout.adminadapter,null);
        TextView txtId = myView.findViewById(R.id.txtId);
        TextView txtName = myView.findViewById(R.id.txtName);
        Button butDelete = myView.findViewById(R.id.butDelete);

        txtId.setText(users.get(position).getId()+"");
        txtName.setText(users.get(position).getName());

        butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userdao userdao = new Userdao(context);
                userdao.deleteUser(users.get(position).getId());
                Toast.makeText(context,"Succefully Deleted "+ users.get(position).getName(),Toast.LENGTH_LONG).show();
            }
        });

        return myView;
    }



}
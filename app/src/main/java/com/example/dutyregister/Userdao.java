package com.example.dutyregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Userdao {

    SQLiteDatabase db;
    String TBDate = "worktime";
    String TBName = "work";
    String ColId = "Id";
    String ColName = "Name";

    public Userdao(Context context) {
        this.context = context;
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    Context context;

    public long adduser(String name , String password)
    {
        ContentValues values = new ContentValues();
        values.put("Name",name);
        values.put("Password",password);
        return db.insert(TBName,null,values);
    }

    public long addDate(String Date , String CI , String BO , String BI , String CO)
    {
        ContentValues values = new ContentValues();
        values.put("Date",Date);
        values.put("CI",CI);
        values.put("BO",BO);
        values.put("BI",BI);
        values.put("CO",CO);
        return db.insert(TBDate,null,values);
    }

    public ArrayList<userModel> getuserNames()
    {
        ArrayList<userModel> user = new ArrayList<>();
        Cursor c = db.rawQuery("select * from "+ TBName,null);
        while (c.moveToNext())
        {
            userModel model = new userModel();
            model.Id = c.getInt(c.getColumnIndex(ColId));
            model.Name = c.getString(c.getColumnIndex(ColName));
            user.add(model);
        }
        return user;
    }

    public long deleteUser(Integer d)
    {
        return db.delete(TBName,"id=?",new String[]{String.valueOf(d)});
    }

}

package com.example.dutyregister;

public class userModel {

    int Id;
    String Name,Password;

    public userModel() {
    }

    public userModel(int id, String name, String password) {
        Id = id;
        Name = name;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("userId")
    int userId ;
    @SerializedName("id")
    int id ;
    @SerializedName("title")
    String title ;
    @SerializedName("body")
    String body ;

    public Model(int userId,  String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

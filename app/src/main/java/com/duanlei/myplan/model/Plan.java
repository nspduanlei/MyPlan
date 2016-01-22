package com.duanlei.myplan.model;

/**
 * Author: duanlei
 * Date: 2016-01-22
 */
public class Plan {

    private int id;
    private String time;
    private String content;

    public Plan(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

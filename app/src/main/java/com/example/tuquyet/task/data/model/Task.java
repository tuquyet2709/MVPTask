package com.example.tuquyet.task.data.model;

/**
 * Created by tuquyet on 07/07/2017.
 */
public class Task {
    private int mId;
    private String mTitle;

    public Task(int id) {
        mId = id;
    }

    public Task(String title) {
        mTitle = title;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}

package com.example.tuquyet.task.data.source;

import android.telecom.Call;

import com.example.tuquyet.task.data.model.Task;

/**
 * Created by tuquyet on 07/07/2017.
 */
public interface TaskDataSource {
    void addTask(Task task, CallBack<Boolean> callBack );
    void editTask(Task task, CallBack<Boolean> callBack );
    void deleteTask(int id, CallBack<Boolean> callBack );
    void getTask(int id, CallBack<Task> callBack);

    interface CallBack<T>{
        void onSucess(T data);
        void onFailed(String msg);
    }
}



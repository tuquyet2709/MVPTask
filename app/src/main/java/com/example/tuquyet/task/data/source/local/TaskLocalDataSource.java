package com.example.tuquyet.task.data.source.local;

import com.example.tuquyet.task.data.model.Task;
import com.example.tuquyet.task.data.source.TaskDataSource;

/**
 * Created by tuquyet on 07/07/2017.
 */
public class TaskLocalDataSource implements TaskDataSource {
    @Override
    public void addTask(Task task, CallBack<Boolean> callBack) {
        //add task
        callBack.onSucess(true);
    }

    @Override
    public void editTask(Task task, CallBack<Boolean> callBack) {
    }

    @Override
    public void deleteTask(int id, CallBack<Boolean> callBack) {
    }

    @Override
    public void getTask(int id, CallBack<Task> callBack) {
    }
}

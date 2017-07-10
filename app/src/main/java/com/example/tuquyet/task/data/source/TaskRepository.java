package com.example.tuquyet.task.data.source;

import com.example.tuquyet.task.data.model.Task;
import com.example.tuquyet.task.data.source.TaskDataSource;

/**
 * Created by tuquyet on 07/07/2017.
 */
public class TaskRepository implements TaskDataSource{
    private TaskDataSource mLocalDataSource;

    public TaskRepository(TaskDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    @Override
    public void addTask(Task task, CallBack<Boolean> callBack) {
        mLocalDataSource.addTask(task,callBack);
    }

    @Override
    public void editTask(Task task, CallBack<Boolean> callBack) {
        mLocalDataSource.editTask(task,callBack);
    }

    @Override
    public void deleteTask(int id, CallBack<Boolean> callBack) {
        mLocalDataSource.deleteTask(id,callBack);
    }

    @Override
    public void getTask(int id, final CallBack<Task> callBack) {
        mLocalDataSource.getTask(id, new CallBack<Task>() {

            @Override
            public void onSucess(Task data) {
                callBack.onSucess(data);
            }

            @Override
            public void onFailed(String msg) {
                callBack.onFailed(msg);
            }
        });
    }
}

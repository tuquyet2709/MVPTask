package com.example.tuquyet.task.main;

import com.example.tuquyet.task.data.model.Task;

import java.util.List;

/**
 * Created by tuquyet on 07/07/2017.
 */
public interface MainContract {
    interface View {
        void onAddTaskSuccess(Task task);
        void onAddTaskFailed(String msg);
        void onEditSuccess();
        void onEditFailed();
        void onDeleteSuccess();
        void onDeleteFailed();
        void onGetSuccess();
        void onGetFailed();
    }

    interface Presenter {
        void addTask(List<Task> taskList, String taskName);
        void editTask();
        void deleteTask(List<Task> taskList, String taskName);
        void getTask(int id);
    }
}

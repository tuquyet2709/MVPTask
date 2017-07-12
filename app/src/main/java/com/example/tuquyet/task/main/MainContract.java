package com.example.tuquyet.task.main;

import com.example.tuquyet.task.data.model.Task;

import java.util.List;

/**
 * Created by tuquyet on 07/07/2017.
 */
public interface MainContract {
    interface View {
        void onDeleteTaskClick(Task task);
        void onAddTaskClick(String title);
        void onEditTaskClick(Task t);
        void onAddTaskSuccess(Task task);
        void onAddTaskFailed(String msg);
        void onEditSuccess(Task task);
        void onEditFailed(String msg);
        void onDeleteSuccess(Task task);
        void onDeleteFailed(String msg);
        void onGetSuccess(List<Task> list);
        void onGetFailed(String msg);
    }

    interface Presenter {
        void addTask(Task task);
        void editTask(Task task);
        void deleteTask(Task task);
        void getAllTask();
    }
}

package com.example.tuquyet.task.main;

import com.example.tuquyet.task.data.model.Task;
import com.example.tuquyet.task.data.source.TaskDataSource;

import java.util.List;

/**
 * Created by tuquyet on 07/07/2017.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private TaskDataSource mTaskRepository;

    public MainPresenter(MainContract.View view,
                         TaskDataSource taskRepository) {
        mView = view;
        mTaskRepository = taskRepository;
    }

    @Override
    public void addTask(final Task task) {
        mTaskRepository.addTask(task, new TaskDataSource.CallBack<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                mView.onAddTaskSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mView.onAddTaskFailed(msg);
            }
        });
    }

    @Override
    public void editTask(final Task task) {
        mTaskRepository.editTask(task, new TaskDataSource.CallBack<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                mView.onEditSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mView.onEditFailed(msg);
            }
        });
    }

    @Override
    public void deleteTask(final Task task) {
        mTaskRepository.deleteTask(task, new TaskDataSource.CallBack<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                mView.onDeleteSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mView.onDeleteFailed(msg);
            }
        });
    }


    @Override
    public void getAllTask() {
        mTaskRepository.getAllTask(new TaskDataSource.CallBacks<Task>() {
            @Override
            public void onSuccess(List<Task> data) {
                mView.onGetSuccess(data);
            }

            @Override
            public void onFailed(String msg) {
                mView.onGetFailed(msg);
            }
        });
    }
}

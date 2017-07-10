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
    public void addTask(final List<Task> taskList, final String taskName) {
        final Task task = new Task(taskName);
        mTaskRepository.addTask(task, new TaskDataSource.CallBack<Boolean>() {
            @Override
            public void onSucess(Boolean data) {
                taskList.add(task);
                mView.onAddTaskSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mView.onAddTaskFailed(msg);
            }
        });

    }

    @Override
    public void editTask() {
    }

    @Override
    public void deleteTask(List<Task> taskList, String taskName) {
    }

    @Override
    public void getTask(int id) {
    }
}

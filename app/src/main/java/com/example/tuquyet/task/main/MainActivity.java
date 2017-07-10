package com.example.tuquyet.task.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tuquyet.task.R;
import com.example.tuquyet.task.data.model.Task;
import com.example.tuquyet.task.data.source.TaskRepository;
import com.example.tuquyet.task.data.source.local.TaskLocalDataSource;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    private MainContract.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this, new TaskRepository(new TaskLocalDataSource()));
    }

    @Override
    public void onAddTaskSuccess(Task task) {
    }

    @Override
    public void onAddTaskFailed(String msg) {
    }

    @Override
    public void onEditSuccess() {
    }

    @Override
    public void onEditFailed() {
    }

    @Override
    public void onDeleteSuccess() {
    }

    @Override
    public void onDeleteFailed() {
    }

    @Override
    public void onGetSuccess() {
    }

    @Override
    public void onGetFailed() {
    }
}

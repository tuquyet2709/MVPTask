package com.example.tuquyet.task.main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuquyet.task.R;
import com.example.tuquyet.task.data.model.Task;
import com.example.tuquyet.task.data.source.TaskRepository;
import com.example.tuquyet.task.data.source.local.TaskLocalDataSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;
    private List<Task> mListTasks;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(
            new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mListTasks = new ArrayList<>();
        mMainAdapter = new MainAdapter(mListTasks, this);
        mRecyclerView.setAdapter(mMainAdapter);
        mPresenter = new MainPresenter(this, new TaskRepository(new TaskLocalDataSource(this)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_add)
            onAddTaskClick(mTitle);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDeleteTaskClick(final Task task) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete ?")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    mPresenter.deleteTask(task);
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
    }

    @Override
    public void onAddTaskClick(String title) {
        final EditText text = new EditText(this);
        text.setHint("Title");
        new AlertDialog.Builder(this).setTitle("Add task")
            .setView(text)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String title = text.getText().toString();
                    Task task = new Task(title);
                    mPresenter.addTask(task);
                }
            })
            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            })
            .show();
    }

    @Override
    public void onEditTaskClick(final Task task) {
        final EditText text = new EditText(this);
        text.setHint("Title");
        new AlertDialog.Builder(this).setTitle("Edit task")
            .setView(text)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String title = text.getText().toString();
                    task.setTitle(title);
                    mPresenter.editTask(task);
                }
            })
            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            })
            .show();
    }

    @Override
    public void onAddTaskSuccess(Task task) {
        mListTasks.add(task);
        mMainAdapter.notifyItemInserted(mListTasks.size());
    }

    @Override
    public void onAddTaskFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEditSuccess(Task task) {
        int index = mListTasks.indexOf(task);
        mListTasks.set(index, task);
        mMainAdapter.notifyItemChanged(index);
    }

    @Override
    public void onEditFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteSuccess(Task task) {
        int index = mListTasks.indexOf(task);
        mListTasks.remove(index);
        mMainAdapter.notifyItemRemoved(index);
    }

    @Override
    public void onDeleteFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetSuccess(List<Task> list) {
        mListTasks.clear();
        mListTasks.addAll(list);
        mMainAdapter.notifyItemInserted(mListTasks.size());
    }

    @Override
    public void onGetFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

package com.example.tuquyet.task.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuquyet.task.R;
import com.example.tuquyet.task.data.model.Task;

import java.util.List;

/**
 * Created by tuquyet on 11/07/2017.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<Task> mTaskList;
    private MainContract.View mView;

    public MainAdapter(List<Task> taskList, MainContract.View v) {
        mTaskList = taskList;
        mView = v;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_task, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = mTaskList.get(position);
        holder.bindData(task);
    }

    @Override
    public int getItemCount() {
        if (mTaskList != null)
            return mTaskList.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Task mTask;
        private CheckBox mCheckBox;
        private TextView mTextTitle;
        private ImageView mImageEdit;
        private ImageView mImageDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            mTextTitle = (TextView) itemView.findViewById(R.id.textView_title);
            mImageEdit = (ImageView) itemView.findViewById(R.id.imageView_edit);
            mImageDelete = (ImageView) itemView.findViewById(R.id.imageView_delete);
            mCheckBox.setOnClickListener(this);
            mImageEdit.setOnClickListener(this);
            mImageDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.checkBox:
                    break;
                case R.id.imageView_edit:
                    mView.onEditTaskClick(mTask.getTitle());
                    break;
                case R.id.imageView_delete:
                    mView.onDeleteTaskClick(mTask);
                    break;
                default:
                    break;
            }
        }

        public void bindData(Task task) {
            mTask = task;
            mCheckBox.setChecked(task.isChecked());
            mTextTitle.setText(task.getTitle());
        }
    }
}

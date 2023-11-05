package com.example.adaptumapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.TaskListItem

class TasksListAdapter : ListAdapter<TaskListItem, TaskViewHolder>(TaskItemDiffCallback())  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
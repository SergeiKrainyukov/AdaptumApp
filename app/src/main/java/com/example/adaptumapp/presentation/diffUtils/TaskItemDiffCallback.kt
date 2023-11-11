package com.example.adaptumapp.presentation.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.adaptumapp.presentation.model.TaskListItem

class TaskItemDiffCallback : DiffUtil.ItemCallback<TaskListItem>() {
    override fun areItemsTheSame(oldItem: TaskListItem, newItem: TaskListItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TaskListItem, newItem: TaskListItem) = oldItem == newItem
}
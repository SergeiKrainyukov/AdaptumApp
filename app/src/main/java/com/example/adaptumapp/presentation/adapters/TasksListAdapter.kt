package com.example.adaptumapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.diffUtils.TaskItemDiffCallback
import com.example.adaptumapp.presentation.model.StageListItem
import com.example.adaptumapp.presentation.viewHolders.TaskViewHolder

class TasksListAdapter : ListAdapter<StageListItem, TaskViewHolder>(TaskItemDiffCallback()) {

    var onClickStage: ((StageListItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.itemView.setOnClickListener {
            onClickStage?.invoke(currentList[position])
        }
    }
}
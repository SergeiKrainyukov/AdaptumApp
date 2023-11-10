package com.example.adaptumapp.presentation.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.TaskListItem

class TaskViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(training: TaskListItem) {
        view.findViewById<TextView>(R.id.task_name_tv).text = training.name
        view.findViewById<TextView>(R.id.description_tv).text = training.description
        view.findViewById<TextView>(R.id.created_date_tv).text = training.date
    }
}
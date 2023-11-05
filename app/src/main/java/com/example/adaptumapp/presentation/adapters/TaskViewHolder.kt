package com.example.adaptumapp.presentation.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.TaskListItem

class TaskViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(training: TaskListItem) {
        view.findViewById<TextView>(R.id.training_type_tv).text = training.type
        view.findViewById<TextView>(R.id.training_date_tv).text = training.date
    }
}
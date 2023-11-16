package com.example.adaptumapp.presentation.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.StageListItem

class StageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(stage: StageListItem) {
        view.findViewById<TextView>(R.id.task_name_tv).text = stage.name
        view.findViewById<TextView>(R.id.description_tv).text = stage.description
        view.findViewById<TextView>(R.id.created_date_tv).text = stage.date
        view.findViewById<TextView>(R.id.status_tv).text = stage.status
    }
}
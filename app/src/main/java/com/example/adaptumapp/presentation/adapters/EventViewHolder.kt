package com.example.adaptumapp.presentation.adapters

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.EventListItem

class EventViewHolder(private val view: View, private val registerAction: ((Int) -> Unit)?) :
    RecyclerView.ViewHolder(view) {
    fun bind(eventItem: EventListItem) {
        with(view) {
            findViewById<TextView>(R.id.title).text = eventItem.title
            findViewById<TextView>(R.id.scores).text = eventItem.units.toString()
            findViewById<TextView>(R.id.date).text = eventItem.date
            findViewById<TextView>(R.id.description).text = eventItem.description
            findViewById<Button>(R.id.register_button).apply {
                text = if (eventItem.status == "Планируется") "Записаться" else "Запись недоступна"
                isEnabled = if (eventItem.status == "Планируется") {
                    setOnClickListener {
                        registerAction?.invoke(eventItem.id)
                    }
                    setBackgroundColor(view.context.resources.getColor(R.color.primary_color))
                    true
                } else {
                    setBackgroundColor(view.context.resources.getColor(R.color.grey))
                    false
                }
            }
        }
    }
}
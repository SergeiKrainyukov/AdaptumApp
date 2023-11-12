package com.example.adaptumapp.presentation.viewHolders

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.EventListItem

class EventViewHolder(private val view: View, private val registerAction: ((Int) -> Unit)?) :
    RecyclerView.ViewHolder(view) {
    fun bind(eventItem: EventListItem) {
        with(view) {
            findViewById<TextView>(R.id.title).text = eventItem.title
            findViewById<TextView>(R.id.status_tv).text = eventItem.status
            findViewById<TextView>(R.id.date).text = eventItem.date.take(10)
            findViewById<TextView>(R.id.description).text = eventItem.description
            if (eventItem.photoUrl.isNotBlank()) Glide.with(itemView.context).load(eventItem.photoUrl)
                .into(findViewById(R.id.event_image))
            findViewById<Button>(R.id.register_button).apply {
                text = if (eventItem.status == "Планируется") "Записаться" else "Запись недоступна"
                isEnabled = if (eventItem.status == "Планируется") {
                    setOnClickListener {
                        registerAction?.invoke(eventItem.id)
                    }
                    setBackgroundColor(view.context.resources.getColor(R.color.theme_green))
                    true
                } else {
                    setBackgroundColor(view.context.resources.getColor(R.color.test_secondary))
                    false
                }
            }
        }
    }
}
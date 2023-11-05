package com.example.adaptumapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.EventListItem

class EventsListAdapter : ListAdapter<EventListItem, EventViewHolder>(EventItemDiffCallback())  {

    var registerAction: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view, registerAction)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
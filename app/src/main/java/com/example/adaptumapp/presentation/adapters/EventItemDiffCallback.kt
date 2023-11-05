package com.example.adaptumapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.adaptumapp.presentation.model.EventListItem

class EventItemDiffCallback : DiffUtil.ItemCallback<EventListItem>() {
    override fun areItemsTheSame(oldItem: EventListItem, newItem: EventListItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: EventListItem, newItem: EventListItem) = oldItem == newItem
}
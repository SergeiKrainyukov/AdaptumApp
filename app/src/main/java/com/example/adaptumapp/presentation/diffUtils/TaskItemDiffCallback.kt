package com.example.adaptumapp.presentation.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.adaptumapp.presentation.model.StageListItem

class TaskItemDiffCallback : DiffUtil.ItemCallback<StageListItem>() {
    override fun areItemsTheSame(oldItem: StageListItem, newItem: StageListItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: StageListItem, newItem: StageListItem) = oldItem == newItem
}
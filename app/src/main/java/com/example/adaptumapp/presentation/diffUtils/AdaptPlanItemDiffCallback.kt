package com.example.adaptumapp.presentation.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.adaptumapp.presentation.model.AdaptPlanListItem

class AdaptPlanItemDiffCallback : DiffUtil.ItemCallback<AdaptPlanListItem>() {
    override fun areItemsTheSame(oldItem: AdaptPlanListItem, newItem: AdaptPlanListItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: AdaptPlanListItem, newItem: AdaptPlanListItem) = oldItem == newItem
}
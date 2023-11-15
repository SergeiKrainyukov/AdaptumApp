package com.example.adaptumapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.diffUtils.AdaptPlanItemDiffCallback
import com.example.adaptumapp.presentation.model.AdaptPlanListItem
import com.example.adaptumapp.presentation.viewHolders.AdaptPlanViewHolder

class AdaptPlansListAdapter : ListAdapter<AdaptPlanListItem, AdaptPlanViewHolder>(AdaptPlanItemDiffCallback())  {

    var onClickAction: ((Int) -> Unit)? = null
    var onClickSendMessageAction: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptPlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adapt_plan, parent, false)
        return AdaptPlanViewHolder(view, onClickAction, onClickSendMessageAction)
    }

    override fun onBindViewHolder(holder: AdaptPlanViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
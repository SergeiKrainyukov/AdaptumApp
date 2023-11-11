package com.example.adaptumapp.presentation.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.model.AdaptPlanListItem

class AdaptPlanViewHolder(private val view: View, private val onClickAction: ((Int) -> Unit)?) :
    RecyclerView.ViewHolder(view) {
    fun bind(adaptPlanListItem: AdaptPlanListItem) {
        with(view) {
            findViewById<TextView>(R.id.plan_name_tv).text = adaptPlanListItem.adaptPlanName
            findViewById<TextView>(R.id.group_name_tv).text = adaptPlanListItem.groupName
            findViewById<TextView>(R.id.start_date_value).text = adaptPlanListItem.startDate
            findViewById<TextView>(R.id.countMentors).text =
                adaptPlanListItem.countMentors
            findViewById<TextView>(R.id.countStages).text = adaptPlanListItem.countStages
            findViewById<TextView>(R.id.count_materials).text =
                adaptPlanListItem.countMaterials
            findViewById<TextView>(R.id.durationDays).text =
                adaptPlanListItem.durationDays
            val imageView = view.findViewById(R.id.avatar) as ImageView
            Glide.with(this).load(adaptPlanListItem.avatarUrl).into(imageView)

        }
        itemView.setOnClickListener {
            onClickAction?.invoke(adaptPlanListItem.id)
        }
    }
}
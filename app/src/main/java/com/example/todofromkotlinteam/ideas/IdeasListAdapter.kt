package com.example.todofromkotlinteam.ideas

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.R

class IdeasListAdapter(listArray:ArrayList<ListEvent>, context: Context): RecyclerView.Adapter<IdeasListAdapter.ViewHolder>() {
    private var events = listArray
    private var appContext = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventView = view.findViewById<ConstraintLayout>(R.id.eventItemView)
        val colorView = view.findViewById<View>(R.id.colorView)
        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val timeIcon = view.findViewById<ImageView>(R.id.timeIcon)
        val timeTextView = view.findViewById<TextView>(R.id.timeTextView)
        val partnerIcon = view.findViewById<ImageView>(R.id.partnerIcon)
        val partnerTextView = view.findViewById<TextView>(R.id.partnerTextView)

        fun bind(listEvent: ListEvent, context: Context) {
            if (listEvent.isPriority) {
                eventView.background.setTint(Color.parseColor(listEvent.eventType.color))
                colorView.background.setTint(context.resources.getColor(R.color.white))

                titleTextView.setTextColor(context.resources.getColor(R.color.white))
                descriptionTextView.setTextColor(context.resources.getColor(R.color.white))
                timeTextView.setTextColor(context.resources.getColor(R.color.white))
                partnerTextView.setTextColor(context.resources.getColor(R.color.white))

                timeIcon.setColorFilter(context.resources.getColor(R.color.white))
                partnerIcon.setColorFilter(context.resources.getColor(R.color.white))
            } else {
                eventView.background.setTint(context.resources.getColor(R.color.white))
                colorView.background.setTint(Color.parseColor(listEvent.eventType.color))
            }

            if (listEvent.isDone) eventView.alpha = 0.5f

            titleTextView.text = listEvent.title
            descriptionTextView.text = listEvent.description
            timeTextView.text = "${listEvent.startTime} - ${listEvent.finishTime}"
            partnerTextView.text = listEvent.partner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(appContext)
        return ViewHolder(inflater.inflate(R.layout.event_list_layout, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = events.get(position)
        holder.bind(listItem, appContext)
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
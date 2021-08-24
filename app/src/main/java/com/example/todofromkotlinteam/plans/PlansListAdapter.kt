package com.example.todofromkotlinteam.plans

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent

class PlansListAdapter(eventArray: ArrayList<ListEvent>, context: Context) : RecyclerView.Adapter<PlansListAdapter.ViewHolder>() {
    private var events = eventArray
    private var appContext = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventView = view.findViewById<ConstraintLayout>(R.id.eventItemView)
        val colorView = view.findViewById<View>(R.id.colorView)
        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val timeIcon = view.findViewById<ImageView>(R.id.timeIcon)
        val timeTexxtView = view.findViewById<TextView>(R.id.timeTextView)
        val partnerIcon = view.findViewById<ImageView>(R.id.partnerIcon)
        val partnerTextView = view.findViewById<TextView>(R.id.partnerTextView)

        fun bind(listEvent: ListEvent, context: Context) {

            if (listEvent.isPriority) {
                val eventBackground = eventView.background
                eventBackground.setTint(Color.parseColor(listEvent.eventType.color))
                val colorBackground = colorView.background
                colorBackground.setTint(context.resources.getColor(R.color.white))

                titleTextView.setTextColor(context.resources.getColor(R.color.white))
                descriptionTextView.setTextColor(context.resources.getColor(R.color.white))
                timeTexxtView.setTextColor(context.resources.getColor(R.color.white))
                partnerTextView.setTextColor(context.resources.getColor(R.color.white))

                timeIcon.setColorFilter(context.resources.getColor(R.color.white))
                partnerIcon.setColorFilter(context.resources.getColor(R.color.white))

            } else {
                val eventBackground = eventView.background
                eventBackground.setTint(context.resources.getColor(R.color.white))
                val colorBackground = colorView.background
                colorBackground.setTint(Color.parseColor(listEvent.eventType.color))
            }

            if (listEvent.isDone) eventView.alpha = 0.5f

            titleTextView.text = listEvent.title
            descriptionTextView.text = listEvent.description
            timeTexxtView.text = "${listEvent.startTime} - ${listEvent.finishTime}"
            partnerTextView.text = listEvent.partner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(appContext)
        return ViewHolder(inflater.inflate(R.layout.event_list_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listEvent = events.get(position)
        holder.bind(listEvent, appContext)
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
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
        private val eventView = view.findViewById<ConstraintLayout>(R.id.eventItemView)
        private val colorView = view.findViewById<View>(R.id.colorView)
        private val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        private val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        private val timeIcon = view.findViewById<ImageView>(R.id.timeIcon)
        private val timeTextView = view.findViewById<TextView>(R.id.timeTextView)
        private val partnerIcon = view.findViewById<ImageView>(R.id.partnerIcon)
        private val partnerTextView = view.findViewById<TextView>(R.id.partnerTextView)

        fun bind(listEvent: ListEvent, context: Context) {
            if (listEvent.isPriority) {
                eventView.background.setTint(Color.parseColor(listEvent.eventType.color))
                colorView.background.setTint(context.resources.getColor(R.color.white, null))

                titleTextView.setTextColor(context.resources.getColor(R.color.white, null))
                descriptionTextView.setTextColor(context.resources.getColor(R.color.white, null))
                timeTextView.setTextColor(context.resources.getColor(R.color.white, null))
                partnerTextView.setTextColor(context.resources.getColor(R.color.white, null))

                timeIcon.setColorFilter(context.resources.getColor(R.color.white, null))
                partnerIcon.setColorFilter(context.resources.getColor(R.color.white, null))
            } else {
                eventView.background.setTint(context.resources.getColor(R.color.white, null))
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
        return ViewHolder(inflater.inflate(R.layout.event_list_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listEvent = events.get(position)
        holder.bind(listEvent, appContext)
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
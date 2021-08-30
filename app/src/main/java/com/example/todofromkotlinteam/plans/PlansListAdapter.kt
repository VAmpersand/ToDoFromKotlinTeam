package com.example.todofromkotlinteam.plans

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.plans.customCalendarView.CustomCalendarView

class PlansListAdapter(eventArray: ArrayList<ListEvent>, context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var events = eventArray
    private var appContext = context

    class EventsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val eventView = view.findViewById<ConstraintLayout>(R.id.eventItemView)
        val colorView = view.findViewById<View>(R.id.colorView)
        val titleTV = view.findViewById<TextView>(R.id.titleTV)
        val descriptionTV = view.findViewById<TextView>(R.id.descriptionTV)
        val imageTime = view.findViewById<ImageView>(R.id.imageTime)
        val timeTV = view.findViewById<TextView>(R.id.timeTextView)
        val imagePartner = view.findViewById<ImageView>(R.id.imagePartner)
        val partnerTV = view.findViewById<TextView>(R.id.partnerTV)


        fun bind(listEvent: ListEvent, context: Context) {

            if (listEvent.isPriority) {
                val eventViewShape = eventView.background
                eventViewShape.setTint(context.resources.getColor(R.color.main_orange))
                val colorViewShape = colorView.background
                colorViewShape.setTint(context.resources.getColor(R.color.white))

                titleTV.setTextColor(context.resources.getColor(R.color.white))
                descriptionTV.setTextColor(context.resources.getColor(R.color.white))
                timeTV.setTextColor(context.resources.getColor(R.color.white))
                partnerTV.setTextColor(context.resources.getColor(R.color.white))

                imageTime.setColorFilter(context.resources.getColor(R.color.white))
                imagePartner.setColorFilter(context.resources.getColor(R.color.white))

            } else {
                val eventViewShape = eventView.background
                eventViewShape.setTint(context.resources.getColor(R.color.white))
                val colorViewShape = colorView.background
                colorViewShape.setTint(context.resources.getColor(R.color.blue))
            }

            if (listEvent.isDone) eventView.alpha = 0.5f

            titleTV.text = listEvent.title
            descriptionTV.text = listEvent.description
            timeTV.text = "${listEvent.startTime} - ${listEvent.finishTime}"
            partnerTV.text = listEvent.partner

        }
    }


    class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(appContext)
        when (viewType) {
            0 -> {
                val calendar = CustomCalendarView(appContext)
                calendar.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                val holder = CalendarViewHolder(calendar)
                holder.setIsRecyclable(false)
                return holder
            }
            else -> return EventsViewHolder(inflater.inflate(R.layout.activity_event, parent,false))
        }
    }

    override fun getItemCount(): Int {
        return events.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> println("Calendar is bind")
            else -> {
                (holder as EventsViewHolder).bind(events[position - 1], appContext)
                holder.setIsRecyclable(false)
            }
        }
    }
}


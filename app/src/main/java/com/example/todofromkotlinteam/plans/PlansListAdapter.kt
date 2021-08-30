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
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.plans.customCalendarView.CustomCalendarView
import java.util.*
import kotlin.collections.ArrayList

class PlansListAdapter(eventArray: ArrayList<ListEvent>, context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var events = eventArray
    private var appContext = context

    class EventsViewHolder(view: View) : RecyclerView.ViewHolder(view){
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

    class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.titleTextView)

        fun bind(context: Context){
            var calendar = Calendar.getInstance()
            val todayDay = calendar.get(Calendar.DAY_OF_MONTH)
            val todayMonth = calendar.get(Calendar.MONTH) + 1
            val todayYear = calendar.get(Calendar.YEAR)

            calendar.time = (context as NavigationBarActivity).selectedDate
            val displayDay = calendar.get(Calendar.DAY_OF_MONTH)
            val displayMonth = calendar.get(Calendar.MONTH) + 1
            val displayYear = calendar.get(Calendar.YEAR)

            if (displayDay == todayDay && displayMonth == todayMonth && displayYear == todayYear) {
                title.text = "Today's events"
            } else {
                title.text = "Accepted events"
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
//
        when (position){
            0 -> return R.id.customCalendar
            1 -> return R.id.titleListLayout
            else -> return R.id.eventItemView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(appContext)

        when (viewType) {
            R.id.customCalendar -> {
                val calendar = CustomCalendarView(appContext)
                calendar.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                val holder = CalendarViewHolder(calendar)
                holder.setIsRecyclable(false)
                return holder}
            R.id.titleListLayout ->  return TitleViewHolder(inflater.inflate(R.layout.title_list_layout, parent, false))

            else -> return EventsViewHolder(inflater.inflate(R.layout.event_list_layout, parent, false))

        }
    }


    override fun getItemCount(): Int {
        return events.size + 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.id.customCalendar -> println("Calendar is bind")
            R.id.titleListLayout -> (holder as TitleViewHolder).bind(appContext)
            else -> {
                (holder as EventsViewHolder).bind(events[position - 2], appContext)
                holder.setIsRecyclable(false)
            }
        }
    }
}






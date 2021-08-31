package com.example.todofromkotlinteam.plans

import android.content.Context
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






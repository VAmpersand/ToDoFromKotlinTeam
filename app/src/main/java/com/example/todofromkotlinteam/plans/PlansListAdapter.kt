package com.example.todofromkotlinteam.plans

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.plans.customCalendarView.CustomCalendarView

class PlansListAdapter(eventArray: ArrayList<ListEvent>, context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var events = eventArray
    private var parentContext = context

    class EventsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val colorEvent = view.findViewById<ImageView>(R.id.eventColorView)
        val titleEvent = view.findViewById<TextView>(R.id.titleEvent)
        val subTitleEvent = view.findViewById<TextView>(R.id.subTitleEvent)
        val timeEvent = view.findViewById<TextView>(R.id.timeEvent)
        val doctorEvent = view.findViewById<TextView>(R.id.doctorEvent)

        fun bind(listEvent: ListEvent, context: Context) {
            colorEvent.setImageResource(listEvent.color)
            titleEvent.text = listEvent.title
            subTitleEvent.text = listEvent.subtitle
            timeEvent.text = listEvent.time
            doctorEvent.text = listEvent.partner
//            itemView.setOnClickListener(){
//            }
        }
    }

    class CaendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        view as Cus
//        lateinit var calendar: CustomCalendarView
//        var calendar = CustomCalendarView(context, null)
//        var calendar = view.findViewById<CustomCalendarView>(R.id.customCalendarView)

//        fun bind(context: Context) : View {
//            calendar = CustomCalendarView(context, null)
//            calendar.configureCalendar()
//            calendar.layoutParams = ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//            )
//            return calendar
//        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parentContext)
        when (viewType) {
            0 -> {
                val calendar = CustomCalendarView(parentContext)
                calendar.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                return CaendarViewHolder(calendar)
            }
            else -> return EventsViewHolder(inflater.inflate(R.layout.activity_event, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> println("Calendar was shown")//(holder as CaendarViewHolder).bind(parentContext)
            else -> {
                var listEvent = events.get(position)
                (holder as EventsViewHolder).bind(listEvent, parentContext)
            }
        }
    }
}
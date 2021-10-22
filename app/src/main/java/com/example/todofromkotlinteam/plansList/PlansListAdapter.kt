package com.example.todofromkotlinteam.plansList

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.adapters.TDRecycleListAdapter
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.views.OnUpdateAndDeleteButtonClickListener
import com.example.todofromkotlinteam.views.customCalendarView.CustomCalendarView

interface ClickListener {
    fun onItemClick(item: ListEvent)
    fun onLongItemClick(item: ListEvent)
}

class PlansListAdapter(eventArray: List<ListEvent>, context: Context, listener: ClickListener  ) : TDRecycleListAdapter(),
    OnUpdateAndDeleteButtonClickListener {
    private var events = eventArray
    private var appContext = context
    private val listener = listener
    private var selectPosition: Int? = null

    class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun getItemCount(): Int {
        return events.size + 2
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
                calendar.setupParent(appContext as NavigationBarActivity)
                calendar.configureCalendar(
                    (appContext as NavigationBarActivity)?.currentCalendar,
                    (appContext as NavigationBarActivity)?.selectedDate
                )
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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.id.customCalendar -> println("Calendar is bind")
            R.id.titleListLayout -> (holder as TitleViewHolder).bind(appContext)
            else -> {
                (holder as EventsViewHolder).bind(events[position - 2], appContext)
                holder.setIsRecyclable(false)
            }
        }

        holder.itemView.setOnClickListener {
            listener.onItemClick(events[position-2])
            selectPosition = position-2
            Log.d("prior","$selectPosition")
        }

        holder.itemView.setOnLongClickListener {
            listener.onLongItemClick(events[position-2])
            true
        }

    }

    override fun onDeleteClickListener() {
        TODO("Not yet implemented")
    }
}





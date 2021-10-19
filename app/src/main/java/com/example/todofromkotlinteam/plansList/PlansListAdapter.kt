package com.example.todofromkotlinteam.plansList

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.NewEventActivity
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.adapters.TDRecycleListAdapter
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.views.InputColorDialogView
import com.example.todofromkotlinteam.views.InputTimeDialogView
import com.example.todofromkotlinteam.views.UpdateAndDeleteDialogView
import com.example.todofromkotlinteam.views.customCalendarView.CustomCalendarView

interface OnClickItemListEvent {
    fun clickItemListEvent(item: ListEvent)
    fun clickLongItemListEvent(item: ListEvent)
}


class PlansListAdapter(eventArray: List<ListEvent>, context: Context, listener: OnClickItemListEvent) : TDRecycleListAdapter() {
    private var events = eventArray
    private var appContext = context
    private var listener = listener
    private var selectPosition : Int? = null


    class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun getItemCount(): Int {
        return events.size + 2
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
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
                return holder
            }
            R.id.titleListLayout -> return TitleViewHolder(
                inflater.inflate(
                    R.layout.title_list_layout,
                    parent,
                    false
                )
            )
            else -> return EventsViewHolder(
                inflater.inflate(
                    R.layout.event_list_layout,
                    parent,
                    false
                )
            )
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        when (holder.itemViewType) {
            R.id.customCalendar -> println("Calendar is bind")
            R.id.titleListLayout -> (holder as TitleViewHolder).bind(appContext)
            else -> {
                (holder as EventsViewHolder).bind(events[position - 2], appContext)
                // НЕ ЗАБЫТЬ ИЗМЕНИТЬ!!!
                if (selectPosition == position) {
                    holder.eventView?.background?.setTint(Color.parseColor("#FF8552"))
                    holder.colorView?.background?.setTint(appContext.resources.getColor(R.color.white, null))

                    holder.titleTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))
                    holder.descriptionTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))
                    holder.timeTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))
                    holder.partnerTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))

                    holder.timeIcon?.setColorFilter(appContext.resources.getColor(R.color.white, null))
                    holder.partnerIcon?.setColorFilter(appContext.resources.getColor(R.color.white, null))
                }
//                if (selectPosition != position) holder.eventView?.alpha = 0.5f
                holder.setIsRecyclable(false)
            }
        }

        holder.itemView.setOnClickListener {
            listener.clickItemListEvent(events[position - 2])
            selectPosition = position
            Log.d("Click", "$selectPosition")
        }

        holder.itemView.setOnLongClickListener {
                listener.clickLongItemListEvent(events[position - 2])
                true
        }
    }


}






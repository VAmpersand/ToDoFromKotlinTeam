package com.example.todofromkotlinteam.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.db.model.ListEvent
import java.util.*
import kotlin.text.*

open class TDRecycleListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class EventsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val eventView = view.findViewById<ConstraintLayout>(R.id.eventItemView)
        private val colorView = view.findViewById<View>(R.id.colorView)
        private val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        private val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        private val timeIcon = view.findViewById<ImageView>(R.id.timeIcon)
        private val timeTextView = view.findViewById<TextView>(R.id.timeTextView)
        private val partnerIcon = view.findViewById<ImageView>(R.id.partnerIcon)
        private val partnerTextView = view.findViewById<TextView>(R.id.partnerTextView)

        fun bind(listEvent: ListEvent, context: Context) {

            val listEventTypeDao = RoomAppDB.getAppDB(context)?.listEventTypeDao()
            val type = listEventTypeDao?.getColorType(listEvent.eventTypeId)
            Log.d("Color", "${type?.color}")

            if (listEvent.isPriority) {
                eventView?.background?.setTint(Color.parseColor(type?.color))
                colorView?.background?.setTint(context.resources.getColor(R.color.white, null))

                titleTextView?.setTextColor(context.resources.getColor(R.color.white, null))
                descriptionTextView?.setTextColor(context.resources.getColor(R.color.white, null))
                timeTextView?.setTextColor(context.resources.getColor(R.color.white, null))
                partnerTextView?.setTextColor(context.resources.getColor(R.color.white, null))

                timeIcon?.setColorFilter(context.resources.getColor(R.color.white, null))
                partnerIcon?.setColorFilter(context.resources.getColor(R.color.white, null))
            } else {
                eventView?.background?.setTint(context.resources.getColor(R.color.white, null))
                colorView?.background?.setTint(Color.parseColor(type?.color))

            }

            if (listEvent.isDone) eventView?.alpha = 0.5f

            titleTextView?.text = listEvent.title
            descriptionTextView?.text = listEvent.description
            timeTextView?.text = "${listEvent.startTime} - ${listEvent.finishTime}"
            partnerTextView?.text = listEvent.partner
        }
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.titleTextView)

        fun bind(context: Context) {
            var calendar = Calendar.getInstance()
            val todayDay = calendar.get(Calendar.DAY_OF_MONTH)
            val todayMonth = calendar.get(Calendar.MONTH) + 1
            val todayYear = calendar.get(Calendar.YEAR)

            calendar.time = (context as NavigationBarActivity).selectedDate
            val displayDay = calendar.get(Calendar.DAY_OF_MONTH)
            val displayMonth = calendar.get(Calendar.MONTH) + 1
            val displayYear = calendar.get(Calendar.YEAR)

            if (displayDay == todayDay && displayMonth == todayMonth && displayYear == todayYear) {
                title?.text = "Today's events"
            } else {
                title?.text = "Accepted events"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
package com.example.todofromkotlinteam.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.db.model.ListEvent
import java.util.*


open class TDRecycleListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class EventsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventView = view.findViewById<ConstraintLayout>(R.id.eventItemView)!!
        val colorView = view.findViewById<View>(R.id.colorView)!!
        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)!!
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)!!
        val timeIcon = view.findViewById<ImageView>(R.id.timeIcon)!!
        val timeTextView = view.findViewById<TextView>(R.id.timeTextView)!!
        val partnerIcon = view.findViewById<ImageView>(R.id.partnerIcon)!!
        val partnerTextView = view.findViewById<TextView>(R.id.partnerTextView)!!

        @SuppressLint("SetTextI18n")
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
            val calendar = Calendar.getInstance()
            val todayDay = calendar.get(Calendar.DAY_OF_MONTH)
            val todayMonth = calendar.get(Calendar.MONTH) + 1
            val todayYear = calendar.get(Calendar.YEAR)

            calendar.time = (context as NavigationBarActivity).selectedDate
            val displayDay = calendar.get(Calendar.DAY_OF_MONTH)
            val displayMonth = calendar.get(Calendar.MONTH) + 1
            val displayYear = calendar.get(Calendar.YEAR)

            if (displayDay == todayDay && displayMonth == todayMonth && displayYear == todayYear) {
                title?.text = context.getString(R.string.title_new)
            } else {
                title?.text = context.getString(R.string.title_accept)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
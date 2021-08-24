package com.example.todofromkotlinteam.ideas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.R

class IdeasListAdapter(listArray:ArrayList<ListEvent>, context: Context): RecyclerView.Adapter<IdeasListAdapter.ViewHolder>() {
    private var events = listArray
    private var parentContext = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventView = view.findViewById<ConstraintLayout>(R.id.eventItemView)
        val colorView = view.findViewById<View>(R.id.colorView)
        val titleTV = view.findViewById<TextView>(R.id.titleTV)
        val descriptionTV = view.findViewById<TextView>(R.id.descriptionTV)
        val imageTime = view.findViewById<ImageView>(R.id.imageTime)
        val timeTV = view.findViewById<TextView>(R.id.timeTV)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parentContext)
        return ViewHolder(inflater.inflate(R.layout.shablon_events, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = events.get(position)
        holder.bind(listItem, parentContext)
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
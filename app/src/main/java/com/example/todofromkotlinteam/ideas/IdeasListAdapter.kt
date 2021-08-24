package com.example.todofromkotlinteam.ideas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.R

class IdeasListAdapter(listArray:ArrayList<ListEvent>, context: Context): RecyclerView.Adapter<IdeasListAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvEventType = view.findViewById<ImageView>(R.id.evenIdeas)
        val tvColor = view.findViewById<ImageView>(R.id.colorView)
        val tvTitle = view.findViewById<TextView>(R.id.titleView)
        val tvDescription = view.findViewById<TextView>(R.id.contentView)
        val tvStartTime = view.findViewById<TextView>(R.id.startTimeView)
        val tvFinishTime = view.findViewById<TextView>(R.id.finishTimeView)
        val tvPartner = view.findViewById<TextView>(R.id.nameView)

        fun bind(listEvent: ListEvent, context: Context){

            if(listEvent.isPriority) {
                tvEventType.background = listEvent.eventType.color
                tvTitle.setTextColor(R.color.white)
                tvDescription.setTextColor(R.color.white)
            }
            tvTitle.text = listEvent.title
            tvDescription.text = listEvent.description
            tvStartTime.text = listEvent.startTime
            tvFinishTime.text = listEvent.finishTime
            tvPartner.text = listEvent.partner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.shablon_events, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }
}
package com.example.todofromkotlinteam.Plans

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.Model.ListEvent

class PlansListAdapter(eventArray: ArrayList<ListEvent>, context: Context): RecyclerView.Adapter<PlansListAdapter.ViewHolder>() {
    var adapterEventR = eventArray
    var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
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
            itemView.setOnClickListener(){
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.activity_event,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listEvent = adapterEventR.get(position)
        holder.bind(listEvent, contextR)
    }

    override fun getItemCount(): Int {
        return adapterEventR.size
    }
}
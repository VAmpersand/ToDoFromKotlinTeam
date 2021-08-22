package com.example.todofromkotlinteam.managers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R

class MyAdapter(listArray:ArrayList<ListItem>,context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById<TextView>(R.id.titleView)
        val tvContent = view.findViewById<TextView>(R.id.contentView)
        val tvTime = view.findViewById<TextView>(R.id.timeView)
        val tvInform = view.findViewById<TextView>(R.id.nameView)

        fun  bind(listItem: ListItem, context: Context){
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.contentText
            tvTime.text = listItem.timeText
            tvInform.text = listItem.nameText
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return  ViewHolder(inflater.inflate(R.layout.shablon_events, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem =listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }
}
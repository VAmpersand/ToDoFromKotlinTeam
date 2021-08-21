package com.example.todofromkotlinteam.managers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< Updated upstream
=======
import android.widget.ImageView
>>>>>>> Stashed changes
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R

<<<<<<< Updated upstream
class MyAdapter(listArray:ArrayList<ListItem>,context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val tvTime = view.findViewById<TextView>(R.id.tvTime)
        val tvInform = view.findViewById<TextView>(R.id.tvInfom)

        fun  bind(listItem: ListItem, context: Context){
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.contentText
            tvTime.text = listItem.timeText
            tvInform.text = listItem.nameText
=======
class MyAdapter(listArray: ArrayList<ListItem>,context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.titleView)
        val tvContene = view.findViewById<TextView>(R.id.contentView)
        val tvTime = view.findViewById<TextView>(R.id.timeView)
        val tvName = view.findViewById<TextView>(R.id.nameView)

        fun bind(listItem: ListItem, context: Context){
            tvTitle.text = listItem.titleText
            tvContene.text = listItem.contentText
            tvTime.text = listItem.timeText
            tvName.text = listItem.nameText
>>>>>>> Stashed changes
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
<<<<<<< Updated upstream
        return  ViewHolder(inflater.inflate(R.layout.shablon_events, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem =listArrayR.get(position)
        holder.bind(listItem, contextR)
=======
        return  ViewHolder(inflater.inflate(R.layout.shablon_events,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var listItem = listArrayR.get(position)
        holder.bind(listItem,contextR)
>>>>>>> Stashed changes
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}
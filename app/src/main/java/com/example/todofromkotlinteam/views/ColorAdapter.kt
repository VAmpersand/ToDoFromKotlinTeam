package com.example.todofromkotlinteam.views

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEventType

interface ItemSelectionListener {
    fun select(item: ListEventType)

}
class ColorAdapter(listArray: ArrayList<ListEventType>, context: Context, listener: ItemSelectionListener) : RecyclerView.Adapter<ColorAdapter.ThemeViewHolder>(){
    private var events = listArray
    private var appContext = context
    private var listener = listener


    class ThemeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val colorTheme = view.findViewById<View>(R.id.colorTheme)
        private val nameTheme = view.findViewById<TextView>(R.id.nameTheme)

        fun bind(listEvent: ListEventType) {
            colorTheme?.background?.setTint(Color.parseColor(listEvent.color))
            nameTheme?.text = listEvent.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  ThemeViewHolder{
        val inflater = LayoutInflater.from(appContext)
       return ThemeViewHolder(inflater.inflate(R.layout.color_theme_field_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.bind(events[position])
        var posit = -1
        if (posit == position) holder.itemView.setBackgroundColor(Color.parseColor("#8A817C"))
        else holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFFFF"))

        holder.itemView.setOnClickListener {
            listener.select(events[position])
            posit = position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return events.size
    }
}
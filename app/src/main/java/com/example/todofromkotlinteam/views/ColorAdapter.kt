package com.example.todofromkotlinteam.views

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEventType



class ColorAdapter(listArray: ArrayList<ListEventType>, context: Context) : RecyclerView.Adapter<ColorAdapter.ThemeViewHolder>()
//    View.OnClickListener
{


    private var events = listArray
    private var appContext = context
    private var onItemClickListener: OnItemClickListener? = null

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
        holder.itemView.setOnClickListener {
            onItemClickListener?.OnItemClicked(events[position])
            }
    }

     override fun getItemCount(): Int {
        return events.size
    }

    interface OnItemClickListener {
        fun OnItemClicked(item: ListEventType)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {

        this.onItemClickListener = onItemClickListener
    }

}
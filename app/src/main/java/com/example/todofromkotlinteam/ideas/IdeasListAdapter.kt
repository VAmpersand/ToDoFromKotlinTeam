package com.example.todofromkotlinteam.ideas

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.adapters.TDRecycleListAdapter
import kotlin.collections.ArrayList

class IdeasListAdapter(listArray:ArrayList<ListEvent>, context: Context) : TDRecycleListAdapter() {
    private var events = listArray
    private var appContext = context

    override fun getItemCount(): Int {
        return events.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        when (position){
            0 -> return R.id.titleListLayout
            else -> return R.id.eventItemView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(appContext)

        when (viewType) {
            R.id.titleListLayout ->  return TitleViewHolder(inflater.inflate(R.layout.title_list_layout, parent, false))
            else -> return EventsViewHolder(inflater.inflate(R.layout.event_list_layout, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.id.titleListLayout -> (holder as TitleViewHolder).bind(appContext)
            else -> {
                (holder as EventsViewHolder).bind(events[position - 1], appContext)
                holder.setIsRecyclable(false)
            }
        }
    }
}
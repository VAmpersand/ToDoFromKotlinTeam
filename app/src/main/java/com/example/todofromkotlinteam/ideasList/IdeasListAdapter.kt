package com.example.todofromkotlinteam.ideasList

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.adapters.TDRecycleListAdapter
import com.example.todofromkotlinteam.plansList.OnClickItemListEvent
import kotlin.collections.ArrayList


class IdeasListAdapter(
    listArray: ArrayList<ListEvent>,
    context: Context, listener: OnClickItemListEvent
) : TDRecycleListAdapter() {
    private var events = listArray
    private var appContext = context
    private var listener = listener
    private var selectPosition : Int? = null

    override fun getItemCount(): Int {
        return events.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> return R.id.titleListLayout
            else -> return R.id.eventItemView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(appContext)

        when (viewType) {
            R.id.titleListLayout -> return TitleViewHolder(
                inflater.inflate(
                    R.layout.title_list_layout,
                    parent,
                    false
                )
            )
            else -> return EventsViewHolder(
                inflater.inflate(
                    R.layout.event_list_layout,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        when (holder.itemViewType) {
            R.id.titleListLayout -> (holder as TitleViewHolder).bind(appContext)
            else -> {
                (holder as EventsViewHolder).bind(events[position - 1], appContext)
                if (selectPosition == position) {
                    holder.eventView?.background?.setTint(Color.parseColor("#FF8552"))
                    holder.colorView?.background?.setTint(appContext.resources.getColor(R.color.white, null))

                    holder.titleTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))
                    holder.descriptionTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))
                    holder.timeTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))
                    holder.partnerTextView?.setTextColor(appContext.resources.getColor(R.color.white, null))

                    holder.timeIcon?.setColorFilter(appContext.resources.getColor(R.color.white, null))
                    holder.partnerIcon?.setColorFilter(appContext.resources.getColor(R.color.white, null))
                }
//                if (selectPosition != position) holder.eventView?.alpha = 0.5f
                holder.setIsRecyclable(false)
            }
        }


        holder.itemView.setOnClickListener {
            listener.clickItemListEvent(events[position - 1])
            selectPosition = position
            Log.d("Click", "$selectPosition")
        }

        holder.itemView.setOnLongClickListener {
            listener.clickLongItemListEvent(events[position - 1])
            selectPosition = position
            true
        }
    }
}
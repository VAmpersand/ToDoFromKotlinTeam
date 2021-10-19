package com.example.todofromkotlinteam.ideasList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.plansList.OnClickItemListEvent
import kotlinx.android.synthetic.main.ideas_fragment.*
import kotlinx.android.synthetic.main.ideas_fragment.recycleViewIdeas


class IdeasFragment : Fragment(), OnClickItemListEvent {
    private var events: List<ListEvent>? = null
    private var event: ListEvent? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ideas_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllIdeasListEvent()
        recycleViewIdeas?.hasFixedSize()
        recycleViewIdeas?.layoutManager = LinearLayoutManager(context)
        if (events == null) events = emptyList()
        recycleViewIdeas?.adapter = IdeasListAdapter(events as ArrayList<ListEvent>, requireContext(), this)

        ideasWeekView?.setupParent(context as NavigationBarActivity)
    }

    override fun onPause() {
        super.onPause()
        getAllIdeasListEvent()
    }

    override fun onResume() {
        super.onResume()

        getAllIdeasListEvent()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun configureFragment() {
        recycleViewIdeas?.adapter?.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private  fun getAllIdeasListEvent(){
        val listEventDao = RoomAppDB.getAppDB(requireContext())?.listEventDao()
        events = listEventDao?.getIdeasListEvent() as ArrayList<ListEvent>?
        recycleViewIdeas?.adapter?.notifyDataSetChanged()}

    override fun clickItemListEvent(item: ListEvent) {
        event = item
        recycleViewIdeas?.adapter?.notifyDataSetChanged()
    }

    override fun clickLongItemListEvent(item: ListEvent) {
        TODO("Not yet implemented")
    }

}
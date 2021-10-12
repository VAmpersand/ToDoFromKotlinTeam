package com.example.todofromkotlinteam.ideas

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
import kotlinx.android.synthetic.main.ideas_fragment.*
import kotlinx.android.synthetic.main.ideas_fragment.recycleView

class IdeasFragment : Fragment() {
    private var events: List<ListEvent>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ideas_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllListEvent()

        recycleView?.hasFixedSize()
        recycleView?.layoutManager = LinearLayoutManager(context)
        if(events == null) events= emptyList()
        recycleView?.adapter = IdeasListAdapter(events!!,requireContext())

        ideasWeekView?.setupParent(context as NavigationBarActivity)
    }

    fun configureFragment() {
        recycleView?.adapter?.notifyDataSetChanged()
    }

    private fun getAllListEvent() {
        val listEventDao = RoomAppDB.getAppDB(requireContext())?.listEventDao()
        events = listEventDao?.getAllListEvent()
        recycleView?.adapter?.notifyDataSetChanged()
    }
}
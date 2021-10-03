package com.example.todofromkotlinteam.ideas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEventType
import kotlinx.android.synthetic.main.ideas_fragment.*
import kotlinx.android.synthetic.main.ideas_fragment.recycleView

class IdeasFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ideas_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val events = ArrayList<ListEvent>()

        events.add(
            ListEvent(
                ListEventType("#55A738","Doctor"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                false,
                false
            )
        )

        events.add(
            ListEvent(
                ListEventType("#55A738","Doctor"),
                "Guided group meditation",
                "Group meditation session at the office Group meditation session at the office Group meditation session at the office vGroup meditation session at the office",
                "13:00",
                "13:30",
                "Yoga instructor",
                false,
                true
            )
        )

        events.add(
            ListEvent(
                ListEventType("#5263FF","Doctor"),
                "Sprint planning",
                "Catchup to plan for next week's sprint",
                "14:00",
                "15:00",
                "Dev.Team",
                true,
                true
            )
        )

        events.add(
            ListEvent(
                ListEventType("#343D8F","Doctor"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                true,
                false
            )
        )

        events.add(
            ListEvent(
                ListEventType("#55A738","Doctor"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                false,
                false
            )
        )

        events.add(
            ListEvent(
                ListEventType("#55A738","Doctor"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                false,
                false
            )
        )

        events.add(
            ListEvent(
                ListEventType("#FF5252","Doctor"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                false,
                false
            )
        )
        recycleView?.hasFixedSize()
        recycleView?.layoutManager = LinearLayoutManager(context)
        recycleView?.adapter = IdeasListAdapter(events, requireContext())

        ideasWeekView?.setupParent(context as NavigationBarActivity)
    }

    fun configureFragment() {
        recycleView?.adapter?.notifyDataSetChanged()
    }
}
package com.example.todofromkotlinteam.ideas

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEventType
import kotlinx.android.synthetic.main.ideas_fragment.*

class IdeasFragment(context: Context) : Fragment() {
    private val parentContext = context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ideas_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val events = ArrayList<ListEvent>()

        events.add(
            ListEvent(
                ListEventType("Doctor", "000000"),
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
                ListEventType("Doctor", "000000"),
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
                ListEventType("Doctor", "000000"),
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
                ListEventType("Doctor", "000000"),
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
                ListEventType("Doctor", "000000"),
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
                ListEventType("Doctor", "000000"),
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
                ListEventType("Doctor", "000000"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                false,
                false
            )
        )

        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(parentContext)
        recyclerView.adapter = IdeasListAdapter(events, parentContext)
    }
}
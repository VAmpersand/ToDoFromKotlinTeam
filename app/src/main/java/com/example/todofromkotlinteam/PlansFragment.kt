package com.example.todofromkotlinteam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.managers.ListEvent
import com.example.todofromkotlinteam.managers.adapterEvent
import kotlinx.android.synthetic.main.activity_main.*

class PlansFragment(context: Context) : Fragment() {
    private var contextA = context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.plans_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val event = ArrayList<ListEvent>()

        event.add(
            ListEvent(R.drawable.mini_circle_red, "Virtual Doctors' Appointment ",
            "Regular virtual catchup with the doctor...", "12:00 - 12:30",
            "Dr. Julian Adams")
        )
        event.add(
            ListEvent(R.drawable.mini_circle_blue, "Guided group meditation",
            "Group meditation session at the office", "13:00 - 13:30",
            "Yoga instructor")
        )
        event.add(
            ListEvent(R.drawable.mini_circle_green, "Sprint planning",
            "Catchup to plan for next week's sprint", "14:00 - 15:00",
            "Dev.Team")
        )
        event.add(
            ListEvent(R.drawable.mini_circle_dark_blue, "Evening. yoga session",
            "Home yoga session for slip.", "19:00 - 19:30","")
        )
        event.add(
            ListEvent(R.drawable.mini_circle_red, "Virtual Doctors' Appointment ",
            "Regular virtual catchup with the doctor...", "12:00 - 12:30",
            "Dr. Julian Adams")
        )
        event.add(
            ListEvent(R.drawable.mini_circle_blue, "Guided group meditation",
            "Group meditation session at the office", "13:00 - 13:30",
            "Yoga instructor")
        )
        event.add(
            ListEvent(R.drawable.mini_circle_green, "Sprint planning",
            "Catchup to plan for next week's sprint", "14:00 - 15:00",
            "Dev.Team")
        )
        event.add(
            ListEvent(R.drawable.mini_circle_dark_blue, "Evening. yoga session",
            "Home yoga session for slip.", "19:00 - 19:30","")
        )

        recyclerEvent.hasFixedSize()
        recyclerEvent.layoutManager = LinearLayoutManager(contextA)
        recyclerEvent.adapter = adapterEvent(event,contextA)
    }

}
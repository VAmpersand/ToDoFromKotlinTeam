package com.example.todofromkotlinteam.ideas

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.Model.ListEvent
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.ideas_fragment.*

class IdeasFragment(context: Context) : Fragment() {
    private val parentContext = context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ideas_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<ListEvent>()
        list.add(
            ListEvent(
                R.drawable.mini_circle_red, "Virtual Doctors' Appointment ",
                "Regular virtual catchup with the doctor...", "12:00 - 12:30",
                "Dr. Julian Adams")
        )
        list.add(
            ListEvent(
                R.drawable.mini_circle_blue, "Guided group meditation",
                "Group meditation session at the office", "13:00 - 13:30",
                "Yoga instructor")
        )
        list.add(
            ListEvent(
                R.drawable.mini_circle_green, "Sprint planning",
                "Catchup to plan for next week's sprint", "14:00 - 15:00",
                "Dev.Team")
        )
        list.add(
            ListEvent(
                R.drawable.mini_circle_dark_blue, "Evening. yoga session",
                "Home yoga session for slip.", "19:00 - 19:30","")
        )
        list.add(
            ListEvent(
                R.drawable.mini_circle_red, "Virtual Doctors' Appointment ",
                "Regular virtual catchup with the doctor...", "12:00 - 12:30",
                "Dr. Julian Adams")
        )
        list.add(
            ListEvent(
                R.drawable.mini_circle_blue, "Guided group meditation",
                "Group meditation session at the office", "13:00 - 13:30",
                "Yoga instructor")
        )
        list.add(
            ListEvent(
                R.drawable.mini_circle_green, "Sprint planning",
                "Catchup to plan for next week's sprint", "14:00 - 15:00",
                "Dev.Team")
        )
        list.add(
            ListEvent(
                R.drawable.mini_circle_dark_blue, "Evening. yoga session",
                "Home yoga session for slip.", "19:00 - 19:30","")
        )
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(parentContext)
        recyclerView.adapter = IdeasListAdapter(list, parentContext)
    }
}
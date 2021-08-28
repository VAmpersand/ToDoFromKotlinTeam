package com.example.todofromkotlinteam.plans

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.model.ListEventType
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.plans_fragment.*


class PlansFragment(context: Context): Fragment() {
    private val parentContext = context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.plans_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val events = ArrayList<ListEvent>()

        events.add(
            ListEvent(
                ListEventType("Doctor", "#39393A"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                false,
                true
            )
        )

        events.add(
            ListEvent(
                ListEventType("Doctor", "#39393A"),
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
                ListEventType("Doctor", "#39393A"),
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
                ListEventType("Doctor", "#39393A"),
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
                ListEventType("Doctor", "#39393A"),
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
                ListEventType("Doctor", "#39393A"),
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
                ListEventType("Doctor", "#39393A"),
                "Virtual Doctors' Appointment",
                "Regular virtual catchup with the doctor...",
                "13:00",
                "14:00",
                "Dr. Julian",
                false,
                false
            )
        )
//        event.add(
//            ListEvent(
//                R.drawable.circle, "Guided group meditation",
//            "Group meditation session at the office", "13:00 - 13:30",
//            "Yoga instructor")
//        )
//        event.add(
//            ListEvent(
//                R.drawable.circle, "Sprint planning",
//            "Catchup to plan for next week's sprint", "14:00 - 15:00",
//            "Dev.Team")
//        )
//        event.add(
//            ListEvent(
//                R.drawable.circle, "Evening. yoga session",
//            "Home yoga session for slip.", "19:00 - 19:30","")
//        )
//        event.add(
//            ListEvent(
//                R.drawable.circle, "Virtual Doctors' Appointment ",
//            "Regular virtual catchup with the doctor...", "12:00 - 12:30",
//            "Dr. Julian")
//        )
//        event.add(
//            ListEvent(
//                R.drawable.circle, "Guided group meditation",
//            "Group meditation session at the office", "13:00 - 13:30",
//            "Yoga instructor")
//        )
//        event.add(
//            ListEvent(
//                R.drawable.circle, "Sprint planning",
//            "Catchup to plan for next week's sprint", "14:00 - 15:00",
//            "Dev.Team")
//        )
//        event.add(
//            ListEvent(
//                R.drawable.circle, "Evening. yoga session",
//            "Home yoga session for slip.", "19:00 - 19:30","")
//        )

        recycleView.hasFixedSize()
        recycleView.layoutManager = LinearLayoutManager(parentContext)
        recycleView.adapter = PlansListAdapter(events, parentContext)
    }
}
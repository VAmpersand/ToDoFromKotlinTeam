package com.example.todofromkotlinteam.plans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.model.ListEventType
import kotlinx.android.synthetic.main.plans_fragment.*
import kotlin.collections.ArrayList

class PlansFragment: Fragment() {
    private var curentOffset = 0
    private var weekViewIsVisible = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.plans_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val events = ArrayList<ListEvent>()

        events.add(
            ListEvent(
                ListEventType("Doctor", "#FF5252"),
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
                ListEventType("Doctor", "#FF5252"),
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
                ListEventType("Doctor", "#5263FF"),
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
                ListEventType("Doctor", "#343D8F"),
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
                ListEventType("Doctor", "#FF8552"),
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
                ListEventType("Doctor", "#55A738"),
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
                ListEventType("Doctor", "#FF5252"),
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
        recycleView?.adapter = PlansListAdapter(events, requireContext())

        plansWeekView?.alpha = 0f

        configureListener()
    }

    override fun onResume() {
        super.onResume()

        plansWeekView?.alpha = if (weekViewIsVisible) 1f else 0f
    }

    private fun configureListener() {
        recycleView?.setOnScrollChangeListener { _, _, _, _, dx ->
            curentOffset -= dx

            if (weekViewIsVisible != (curentOffset > 785)) {
                weekViewIsVisible = (curentOffset > 785)

                plansWeekView?.alpha = if (weekViewIsVisible) 0f else 1f
                plansWeekView?.animate()?.apply {
                    interpolator = android.view.animation.AccelerateInterpolator()
                    duration = if (weekViewIsVisible) 200 else 100
                    alpha(if (weekViewIsVisible) 1f else 0f)
                    startDelay = 0
                    start()
                }
            }
        }
    }

    fun configureFragment() {
        recycleView?.adapter?.notifyDataSetChanged()
        plansWeekView?.configureWeek()
    }
}
package com.example.todofromkotlinteam.plans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.model.ListEvent
import kotlinx.android.synthetic.main.color_theme_dialog.*
import kotlinx.android.synthetic.main.plans_fragment.*

class PlansFragment: Fragment()  {
    private var currentOffset = 0
    private var weekViewIsVisible = false
    private var events: List<ListEvent>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.plans_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllListEvent()

//        val events = ArrayList<ListEvent>()
//
//        events.add(
//            ListEvent(
//                0,
//                ListEventType( 0,"#FF5252","Doctor"),
//                "Virtual Doctors' Appointment",
//                "Regular virtual catchup with the doctor...",
//                "13:00",
//                "14:00",
//                "Dr. Julian",
//                false,
//                true
//            )
//        )
//
//        events.add(
//            ListEvent(
//                1,
//                ListEventType( 1,"#FF5252","Doctor"),
//                "Virtual Doctors' Appointment",
//                "Regular virtual catchup with the doctor...",
//                "13:00",
//                "14:00",
//                "Dr. Julian",
//                true,
//                false
//            )
//        )
//
//        events.add(
//            ListEvent(
//                2,
//                ListEventType( 2,"#FF5252","Doctor"),
//                "Virtual Doctors' Appointment",
//                "Regular virtual catchup with the doctor...",
//                "13:00",
//                "14:00",
//                "Dr. Julian",
//                false,
//                false
//            )
//        )
//
//        events.add(
//            ListEvent(
//                3,
//                ListEventType(3,"#343D8F","Doctor"),
//                "Virtual Doctors' Appointment",
//                "Regular virtual catchup with the doctor...",
//                "13:00",
//                "14:00",
//                "Dr. Julian",
//                false,
//                false
//            )
//        )
//
//        events.add(
//            ListEvent(
//                4,
//                ListEventType( 4,"#FF5252","Doctor"),
//                "Virtual Doctors' Appointment",
//                "Regular virtual catchup with the doctor...",
//                "13:00",
//                "14:00",
//                "Dr. Julian",
//                false,
//                false
//            )
//        )
//
//        events.add(
//            ListEvent(
//                5,
//                ListEventType( 5,"#55A738","Doctor"),
//                "Virtual Doctors' Appointment",
//                "Regular virtual catchup with the doctor...",
//                "13:00",
//                "14:00",
//                "Dr. Julian",
//                false,
//                false
//            )
//        )
//
//        events.add(
//            ListEvent(
//                6,
//                ListEventType(7,"#FF5252","Doctor"),
//                "Virtual Doctors' Appointment",
//                "Regular virtual catchup with the doctor...",
//                "13:00",
//                "14:00",
//                "Dr. Julian",
//                false,
//                false
//            )
//        )

        recycleView?.hasFixedSize()
        recycleView?.layoutManager = LinearLayoutManager(context)
        if (events == null) events = emptyList()
        recycleView?.adapter = PlansListAdapter(events!!, requireContext())

        plansWeekView?.alpha = 0f
        plansWeekView?.setupParent(context as NavigationBarActivity)

        configureListener()
    }

    override fun onResume() {
        super.onResume()

        getAllListEvent()
        plansWeekView?.alpha = if (weekViewIsVisible) 1f else 0f
    }

    private fun configureListener() {
        recycleView?.setOnScrollChangeListener { _, _, _, _, dx ->
            currentOffset -= dx

            if (weekViewIsVisible != (currentOffset > 785)) {
                weekViewIsVisible = (currentOffset > 785)

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

    private fun getAllListEvent() {
        val listEventDao = RoomAppDB.getAppDB(requireContext())?.listEventDao()
        events = listEventDao?.getAllListEvent()
        rcView?.adapter?.notifyDataSetChanged()
    }

}
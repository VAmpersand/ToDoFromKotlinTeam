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
import com.example.todofromkotlinteam.db.model.ListEvent
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
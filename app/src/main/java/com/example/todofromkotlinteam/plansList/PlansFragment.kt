package com.example.todofromkotlinteam.plansList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.views.UpdateDeleteDialogView
import kotlinx.android.synthetic.main.plans_fragment.*

class PlansFragment : Fragment(),
    ClickListener {
    private var currentOffset = 0
    private var weekViewIsVisible = false
    private var events: List<ListEvent>? = null
    private var currentEvent : ListEvent? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.plans_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllListEvent()

        recycleViewPlans?.hasFixedSize()
        recycleViewPlans?.layoutManager = LinearLayoutManager(context)
        if (events == null) events = emptyList()
        recycleViewPlans?.adapter = PlansListAdapter(events!!, requireContext(), this)

        plansWeekView?.alpha = 0f
        plansWeekView?.setupParent(context as NavigationBarActivity)

        configureListener()
    }

    override fun onPause() {
        super.onPause()
        getAllListEvent()
    }

    override fun onResume() {
        super.onResume()

        getAllListEvent()
        plansWeekView?.alpha = if (weekViewIsVisible) 1f else 0f
    }

    private fun configureListener() {
        recycleViewPlans?.setOnScrollChangeListener { _, _, _, _, dx ->
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

//        val listEventDao = RoomAppDB.getAppDB(requireContext())?.listEventDao()
//        if (currentEvent != null) listEventDao?.getPriorityListEvent()

//        recycleViewPlans?.setOnClickListener{
//        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun configureFragment() {
        recycleViewPlans?.adapter?.notifyDataSetChanged()
        plansWeekView?.configureWeek()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getAllListEvent() {
        val listEventDao = RoomAppDB.getAppDB(requireContext())?.listEventDao()
        events = listEventDao?.getPlansListEvent()
        recycleViewPlans?.adapter?.notifyDataSetChanged()
    }

     override fun onItemClick(item: ListEvent) {
         currentEvent = item
     }

    override fun onLongItemClick(item: ListEvent) {
        UpdateDeleteDialogView().show((activity as AppCompatActivity).supportFragmentManager,"UpdateDelete")
    }
}
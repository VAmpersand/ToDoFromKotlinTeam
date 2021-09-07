package com.example.todofromkotlinteam

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.plans_fragment.*
import kotlin.math.log

class NewEventActivity: AppCompatActivity() {
    private var weekViewIsVisible = false
    private var listOffset = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
        configureListener()
    }

    fun onClickBack(view : View) { finish() }

    private fun configureFields() {
        eventNameField?.configureField("Enter event name here", null)
        eventTypeField?.configureField("Select event type", R.drawable.ic_down_arrow)
        eventDateField?.configureField("Set event date", R.drawable.ic_today)
        eventStartTimeField?.configureField("Event start time", R.drawable.ic_watch)
        eventEndTimeField?.configureField("Event end time", R.drawable.ic_watch)
        eventDescriptionField?.configureField("Describe the event", R.drawable.ic_forum)
        eventPartnerField?.configureField("Whois the event with", R.drawable.ic_people)
    }

    private fun configureListener() {
        recycleView?.setOnScrollChangeListener { _, _, _, _, dx ->
            listOffset -= dx

            if (weekViewIsVisible != (listOffset > 2)) {
                weekViewIsVisible = (listOffset > 2)

                newEvent?.alpha = if (weekViewIsVisible) 0f else 1f
            }
        }
    }
}
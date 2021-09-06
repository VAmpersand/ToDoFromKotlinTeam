package com.example.todofromkotlinteam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_event_additing_layout.*

class NewEventActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
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
}
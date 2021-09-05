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

    fun onClickBack(view : View){ finish() }

    private fun configureFields(){
        eventNameField?.configureField("Enter event name here", null)
        eventTypeField?.configureField("Select event type", R.drawable.ic_people)
        eventDateField?.configureField("Enter event n", null)
        eventStartTimeField?.configureField("Enter  here", null)
        eventEndTimeField?.configureField("Enter  name here", null)
        eventDescriptionField?.configureField("Enter event nae here", null)
        eventPartnerField?.configureField("Enter event nae here", null)
    }
}
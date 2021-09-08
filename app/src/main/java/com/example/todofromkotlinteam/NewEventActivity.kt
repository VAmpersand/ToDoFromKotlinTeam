package com.example.todofromkotlinteam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.todofromkotlinteam.views.EventDataFieldType
import com.example.todofromkotlinteam.views.EventsDataField
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.plans_fragment.*

class NewEventActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
    }

    fun onClickBack(view : View) { finish() }
    fun onClickAddEvent(view : View) { finish() }

    fun onClickField(view: View) {
        view as EventsDataField

        when (view.id) {
            R.id.eventTypeField -> println("eventTypeField")
            R.id.eventDateField -> println("eventDateField")
            R.id.eventStartTimeField -> println("eventStartTimeField")
            R.id.eventEndTimeField -> println("eventEndTimeField")
            else -> println("Another field tapped")
        }
    }

    private fun configureFields() {
        eventNameField?.configureField(EventDataFieldType.NAME)
        eventTypeField?.configureField(EventDataFieldType.TYPE)
        eventDateField?.configureField(EventDataFieldType.DATE)
        eventStartTimeField?.configureField(EventDataFieldType.START_TIME)
        eventEndTimeField?.configureField(EventDataFieldType.END_TIME)
        eventDescriptionField?.configureField(EventDataFieldType.DESCRIPTION)
        eventPartnerField?.configureField(EventDataFieldType.PARTNER)
    }
}

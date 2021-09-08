package com.example.todofromkotlinteam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.todofromkotlinteam.views.EventDataFieldType
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.plans_fragment.*

class NewEventActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
    }

    fun onClickBack(view : View) { finish() }

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

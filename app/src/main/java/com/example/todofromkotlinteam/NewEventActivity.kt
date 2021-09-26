package com.example.todofromkotlinteam

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.todofromkotlinteam.model.ListEventType
import com.example.todofromkotlinteam.views.*
import com.example.todofromkotlinteam.views.EventDataFieldType
import kotlinx.android.synthetic.main.event_list_layout.view.*
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

class NewEventActivity : AppCompatActivity(),
    OnTypeDialogButtonClickListener,
    OnDateDialogButtonClickListener,
    OnTimeDialogButtonClickListener,
    OnHexDialogButtonClickListener,
    OnColorDialogButtonClickListener
{

    private var currentType: EventType? = null
    private var currentDate = Date()
    private var currentStartTime: Date? = null
    private var currentEndTime: Date? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
    }

    fun onClickBack(view: View) {
        finish()
    }

    fun onClickAddEvent(view: View) {
        finish()
    }

    private fun configureFields() {
        eventNameField?.configureField(EventDataFieldType.NAME)
        eventDescriptionField?.configureField(EventDataFieldType.DESCRIPTION)
        eventPartnerField?.configureField(EventDataFieldType.PARTNER)

        eventTypeField?.configureField(EventDataFieldType.TYPE)
        eventTypeField?.inputField?.setOnClickListener {
            InputTypeDialogView(currentType, this).show(supportFragmentManager, "TypeDialog")
        }

        eventDateField?.configureField(EventDataFieldType.DATE)
        eventDateField?.inputField?.setOnClickListener {
            InputDateDialogView(currentDate, this).show(supportFragmentManager, "DateDialog")
        }

        eventStartTimeField?.configureField(EventDataFieldType.START_TIME)
        eventStartTimeField?.inputField?.setOnClickListener {
            InputTimeDialogView(currentStartTime, currentEndTime,this).show(supportFragmentManager, "TimeDialog")
        }

        eventEndTimeField?.configureField(EventDataFieldType.END_TIME)
        eventEndTimeField?.inputField?.setOnClickListener {
            InputTimeDialogView(currentStartTime, currentEndTime,this).show(supportFragmentManager, "TimeDialog")
        }

        itemColorField?.configureField(EventDataFieldType.COLOR)
        itemColorField?.inputField?.setOnClickListener {
            InputColorDialogView(this).show(supportFragmentManager, "ColorDialog")
        }
    }

    // MARK: - OnTypeDialogButtonClickListener
    override fun onTypeOkClickListener(type: EventType) {
        currentType = type

        if (type == EventType.PLANS) {
            eventTypeField?.inputField?.setText(R.string.plans)
        } else if (type == EventType.IDEAS) {
            eventTypeField?.inputField?.setText(R.string.ideas)
        }
    }

    // MARK: - OnDateDialogButtonClickListener
    override fun onDateOkClickListener(date: Date) {
        currentDate = date

        val calendar = Calendar.getInstance(Locale.UK)
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.UK)
        calendar.time = date

        eventDateField?.inputField?.setText(dateFormat.format(calendar.time))
    }

    // MARK: - OnTimeDialogButtonClickListener
    override fun onTimeOkClickListener(startTime: Date, endTime: Date) {
        currentStartTime = startTime
        currentEndTime = endTime

        val calendar = Calendar.getInstance(Locale.UK)
        val dateFormat = SimpleDateFormat("HH:mm", Locale.UK)

        calendar.time = startTime
        eventStartTimeField?.inputField?.setText(dateFormat.format(calendar.time))

        calendar.time = endTime
        eventEndTimeField?.inputField?.setText(dateFormat.format(calendar.time))
    }

    // MARK: - OnHexDialogButtonClickListener
    override fun onHexOkClickListener() {
        InputColorDialogView(this).show(supportFragmentManager, "ColorDialog")
    }

    // MARK: - OnColorDialogButtonClickListener
    override fun onColorOkClickListener(type: ListEventType) {
        itemColorField?.inputField?.setText(type.title)
        itemColorField?.colorView?.background?.setTint(Color.parseColor(type.color))
    }

    override fun onAddHexClickListener() {
        HexSelectColorDialogView(this).show(supportFragmentManager, "HexSelectColor")
    }


}













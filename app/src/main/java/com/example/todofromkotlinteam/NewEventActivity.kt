package com.example.todofromkotlinteam

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.db.model.ListEventType
import com.example.todofromkotlinteam.views.*
import com.example.todofromkotlinteam.views.EventDataFieldType
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.plans_fragment.*
import kotlinx.android.synthetic.main.settings_fragment.view.*
import kotlinx.android.synthetic.main.time_input_dialog_layout.*
import java.text.SimpleDateFormat
import java.util.*

class NewEventActivity : AppCompatActivity(),
    OnTypeDialogButtonClickListener,
    OnDateDialogButtonClickListener,
    OnTimeDialogButtonClickListener,
    OnHexDialogButtonClickListener,
    OnColorDialogButtonClickListener {

    private var currentType: EventType? = null
    private var currentDate = Date()
    private var currentStartTime: Date? = null
    private var currentEndTime: Date? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        recycleView?.adapter?.notifyDataSetChanged()
    }

    fun onClickBack(view: View) {
        finish()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onClickAddEvent(view: View) {


        if (currentType == null
                && currentDate == null
                && currentStartTime == null
                && currentEndTime == null
                && eventNameField?.textView?.text?.isEmpty() == true
                && eventDescriptionField?.textView?.text?.isEmpty() == true
                && eventPartnerField?.textView?.text?.isEmpty() == true ){

                    eventNameField?.textView?.error = "Name!!"
                    eventDateField?.textView?.error = "Date!!"
                            eventDescriptionField?.textView?.error = "Describe!!"
                            eventPartnerField?.textView?.error = "Partner!!"
//                            id = 0,
//                            eventTypeId = 0,
//                            title = eventNameField?.textView?.text.toString(),
//                            date = currentDate.toString(),
//                            description = eventDescriptionField?.textView?.text.toString(),
//                            startTime = "12:00",
//                            finishTime = "13:00",
//                            isDone = false,
//                            isPriority = false,
//                            partner = eventPartnerField?.textView?.text.toString(),
//                            colorEvent = currentType.toString()

        }
        else {
            val listEventDao = RoomAppDB.getAppDB(application)?.listEventDao()
            listEventDao?.insertListEvent(
                    ListEvent(
                            id = 0,
                            eventTypeId = 0,
                            title = eventNameField?.textView?.text.toString(),
                            date = currentDate.toString(),
                            description = eventDescriptionField?.textView?.text.toString(),
                            startTime = currentStartTime.toString(),
                            finishTime = currentEndTime.toString(),
                            isDone = false,
                            isPriority = false,
                            partner = eventPartnerField?.textView?.text.toString()))
        }
        finish()
        recycleView?.adapter?.notifyDataSetChanged()

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
        val dateFormat = SimpleDateFormat("dd MM yyyy", Locale.UK)
        calendar.time = date

        eventDateField?.inputField?.setText(dateFormat.format(calendar.time))
    }

    // MARK: - OnTimeDialogButtonClickListener
    override fun onTimeOkClickListener(startTime: Date, endTime: Date) {
        currentStartTime = startTime
        currentEndTime = endTime

        val calendar = Calendar.getInstance(Locale.UK)
        val dateFormat = SimpleDateFormat("HH:mm", Locale.UK)

//        if(startHoursEditText == null || startMinutesEditText == null){
//            startHoursEditText?.error = "Hours!!"
//            startMinutesEditText?.error = "Minutes!!"
//        }
//        else {
//            val startHours = startHoursEditText.text.toString()
//            val startMinutes = startMinutesEditText.text.toString()
//            eventStartTimeField?.inputField?.setText("$startHours:$startMinutes")
//            }

        calendar.time = startTime
        eventStartTimeField?.inputField?.setText(dateFormat.format(startTime))

        calendar.time = endTime
        eventEndTimeField?.inputField?.setText(dateFormat.format(endTime))
    }

    // MARK: - OnHexDialogButtonClickListener
    @SuppressLint("ResourceType")
    override fun onHexOkClickListener() {
        InputColorDialogView(this).show(supportFragmentManager, "ColorDialog")

    }


    // MARK: - OnColorDialogButtonClickListener
    override fun onColorOkClickListener(type: ListEventType) {
        itemColorField?.inputField?.setText(type.title)
        itemColorField?.iconEvent?.background?.setTint(Color.parseColor(type.color.toString()))
    }

    override fun onAddHexClickListener() {
        HexSelectColorDialogView(this).show(supportFragmentManager, "HexSelectColor")
    }


}













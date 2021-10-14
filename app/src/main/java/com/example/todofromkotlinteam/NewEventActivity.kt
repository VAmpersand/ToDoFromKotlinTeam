package com.example.todofromkotlinteam

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.db.model.ListEventType
import com.example.todofromkotlinteam.views.*
import com.example.todofromkotlinteam.views.EventDataFieldType
import kotlinx.android.synthetic.main.ideas_fragment.*
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.plans_fragment.*
import kotlinx.android.synthetic.main.settings_fragment.view.*
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
    private var currentStartTime: String? = null
    private var currentEndTime: String? = null
    private var currentEventType: ListEventType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
//        getColorEventType()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
//        getColorEventType()
        recycleViewPlans?.adapter?.notifyDataSetChanged()
        recycleViewIdeas?.adapter?.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onPause() {
        super.onPause()
//        getColorEventType()
        recycleViewPlans?.adapter?.notifyDataSetChanged()
        recycleViewIdeas?.adapter?.notifyDataSetChanged()
    }

    fun onClickBack(view: View) {
        finish()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onClickAddEvent(view: View) {

        Log.d("currentType", "$currentType")
        Log.d("currentDate", "$currentDate")
        Log.d("currentStartTime", "$currentStartTime")
        Log.d("currentEndTime", "$currentEndTime")
        Log.d("currentEventType", "$currentEventType")
        Log.d("eventNameField", "${eventNameField?.inputField?.text}")
        Log.d("currentEventTypeID", "${currentEventType?.id}")

        if (currentType != null
            && currentDate != null
            && currentStartTime != null
            && currentEndTime != null
            && currentEventType?.id != null
            && eventNameField?.inputField?.text?.isEmpty() == false
        ) {

            val listEventDao = RoomAppDB.getAppDB(application)?.listEventDao()

            listEventDao?.insertListEvent(
                ListEvent(
                    id = 0,
                    eventTypeId = currentEventType?.id!!,
                    title = eventNameField?.inputField?.text?.toString()!!,
                    date = currentDate.toString()!!,
                    description = eventDescriptionField?.textView?.text?.toString(),
                    startTime = currentStartTime.toString()!!,
                    finishTime = currentEndTime.toString()!!,
                    isDone = false,
                    isPriority = false,
                    partner = eventPartnerField?.textView?.text?.toString(),
                    eventTypeName = currentType.toString()!!
                )
            )

        }
        finish()
        recycleViewPlans?.adapter?.notifyDataSetChanged()
        recycleViewIdeas?.adapter?.notifyDataSetChanged()
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun getColorEventType() {
//        val listEventTypeDao = RoomAppDB.getAppDB(application)?.listEventTypeDao()
//        val colorType = listEventTypeDao?.getColorEventType(currentEventType?.id)
//
//    }


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
            InputTimeDialogView(currentStartTime, currentEndTime, this).show(
                supportFragmentManager,
                "TimeDialog"
            )
        }

        eventEndTimeField?.configureField(EventDataFieldType.END_TIME)
        eventEndTimeField?.inputField?.setOnClickListener {
            InputTimeDialogView(currentStartTime, currentEndTime, this).show(
                supportFragmentManager,
                "TimeDialog"
            )
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
    override fun onTimeOkClickListener(startTime: String, endTime: String) {
        currentStartTime = startTime
        currentEndTime = endTime

        eventStartTimeField?.inputField?.setText(startTime)
        eventEndTimeField?.inputField?.setText(endTime)
    }

    // MARK: - OnHexDialogButtonClickListener
    @SuppressLint("ResourceType")
    override fun onHexOkClickListener() {
        InputColorDialogView(this).show(supportFragmentManager, "ColorDialog")

    }

    // MARK: - OnColorDialogButtonClickListener
    override fun onColorOkClickListener(type: ListEventType) {

        currentEventType = type
        itemColorField?.inputField?.setText(type.title)
        itemColorField?.iconEvent?.background?.setTint(Color.parseColor(type.color))
    }

    override fun onAddHexClickListener() {
        HexSelectColorDialogView(this).show(supportFragmentManager, "HexSelectColor")
    }


}













package com.example.todofromkotlinteam.views

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.iconEvent

enum class EventDataFieldType {
    NAME, TYPE, DATE, START_TIME, END_TIME, DESCRIPTION, PARTNER
}

class EventsDataField: LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initializeLayout()
    }

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.new_event_field_layout, this)
    }

    fun configureField(type: EventDataFieldType, title: String? = null) {
        inputField?.setText(title)

        when (type) {
            EventDataFieldType.NAME -> {
                inputField?.hint = "Enter event name here"
            }
            EventDataFieldType.TYPE -> {
                inputField?.hint = "Select event type"
                inputField?.isCursorVisible = false
                inputField?.isFocusable = false
                inputField?.inputType = InputType.TYPE_NULL
                iconEvent?.setImageResource(R.drawable.ic_down_arrow)
            }
            EventDataFieldType.DATE -> {
                inputField?.hint = "Set event date"
                inputField?.isCursorVisible = false
                inputField?.isFocusable = false
                inputField?.inputType = InputType.TYPE_NULL
                iconEvent?.setImageResource(R.drawable.ic_today)
            }
            EventDataFieldType.START_TIME -> {
                inputField?.hint = "Event start time"
                inputField?.isCursorVisible = false
                inputField?.isFocusable = false
                inputField?.inputType = InputType.TYPE_NULL
                iconEvent?.setImageResource(R.drawable.ic_watch)
            }
            EventDataFieldType.END_TIME -> {
                inputField?.hint = "Event end time"
                inputField?.isCursorVisible = false
                inputField?.isFocusable = false
                inputField?.inputType = InputType.TYPE_NULL
                iconEvent?.setImageResource(R.drawable.ic_watch)
            }
            EventDataFieldType.DESCRIPTION -> {
                inputField?.hint = "Describe the event"
                iconEvent?.setImageResource(R.drawable.ic_forum)
            }
            EventDataFieldType.PARTNER -> {
                inputField?.hint = "Whois the event with"
                iconEvent?.setImageResource(R.drawable.ic_people)
            }
        }
    }
}

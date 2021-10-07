package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.time_input_dialog_layout.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.okButton
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

interface OnTimeDialogButtonClickListener {
    fun onTimeOkClickListener(startTime: Date, endTime: Date)
}

class InputTimeDialogView(startTime: Date?, endTime: Date?, listener: OnTimeDialogButtonClickListener): DialogFragment() {
    private val listener = listener
    private var startTime = startTime
    private var endTime = endTime

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.time_input_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()

        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val calendar = Calendar.getInstance(Locale.UK)
        val dateFormat = SimpleDateFormat("HH:mm", Locale.UK)

        if (startTime != null && endTime != null) {
            calendar.time = startTime
            startHoursEditText?.setText(calendar.get(Calendar.HOUR).toString())
            startMinutesEditText?.setText(calendar.get(Calendar.MINUTE).toString())

            calendar.time = endTime
            endHoursEditText?.setText(calendar.get(Calendar.HOUR).toString())
            endMinutesEditText?.setText(calendar.get(Calendar.MINUTE).toString())
        }
    }

    private fun configureListeners() {
        okButton?.setOnClickListener {
            val calendar = Calendar.getInstance(Locale.UK)

            startHoursEditText?.text.toString()
            startMinutesEditText?.text.toString()
//            calendar.get(Calendar.HOUR)
//            calendar.get(Calendar.MINUTE)

            var startTime = calendar.time

            endHoursEditText?.text.toString()
            endMinutesEditText?.text.toString()
//            calendar.get(Calendar.HOUR)
//            calendar.get(Calendar.MINUTE)

            var endTime = calendar.time

            listener.onTimeOkClickListener(startTime, endTime)
            dialog?.hide()
        }

        for (item in arrayOf(startHoursEditText, endHoursEditText,startMinutesEditText, endMinutesEditText)) {
            var maxTime = 23
            if(item ==startMinutesEditText || item == endMinutesEditText)  maxTime=59
            item?.setOnFocusChangeListener { view, isFocused ->
                view as EditText

                if (!view.text.isEmpty()) {
                    val value = view.text.toString().toInt()

                    if (!isFocused && value > maxTime) view.setText("$maxTime")
                    if (!isFocused && (value < 0 || value == null)) view.setText("0")
                }
            }
        }
    }
}
package com.example.todofromkotlinteam.views

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.time_input_dialog_layout.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.okButton
import java.util.*

interface OnTimeDialogButtonClickListener {
    fun onTimeOkClickListener(startTime: Date, endTime: Date)
}

class InputTimeDialogView(startTime: Date?, endTime: Date?, listener: OnTimeDialogButtonClickListener): DialogFragment() {
    private val listener = listener
    private var startTime = startTime
    private var endTime = endTime

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.time_input_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()

        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val calendar = Calendar.getInstance(Locale.ENGLISH)

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
            val calendar = Calendar.getInstance(Locale.ENGLISH)

            val startHours = startHoursEditText?.text
            calendar.set(Calendar.HOUR, 13)
            calendar.set(Calendar.MINUTE, 44)

            var startTime = calendar.time

            calendar.set(Calendar.HOUR, 14)
            calendar.set(Calendar.MINUTE, 14)

            var endTime = calendar.time

            listener.onTimeOkClickListener(startTime, endTime)
            dialog?.hide()
        }

        endHoursEditText?.setOnFocusChangeListener { view, isFocused ->

            Log.d("FOCUS", isFocused.toString())
        }
    }
}
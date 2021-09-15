package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.views.customCalendarView.OnCalendarClickListener
import kotlinx.android.synthetic.main.date_input_dialog_layout.*
import java.util.*


interface OnDateDialogButtonClickListener {
    fun onDateOkClickListener(date: Date)
}

class InputDateDialogView(currentDate: Date?, listener: OnDateDialogButtonClickListener) : DialogFragment(), OnCalendarClickListener {
    private val listener = listener
    private var calendar = Calendar.getInstance()
    private var currentDate: Date? = currentDate

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.date_input_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()

        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        calendar.time = currentDate
        if (currentDate == null) currentDate = Date()
        calendarView?.configureCalendar(calendar, currentDate!!)
        calendarView?.setupParent(this)
    }

    private fun configureListeners() {
        okButton?.setOnClickListener {
            if (currentDate == null) currentDate = Date()
            listener.onDateOkClickListener(currentDate!!)
            dialog?.hide()
        }
    }

    // MARK: - OnCalendarClickListener
    override fun onDateClickListener(date: Date) {
        currentDate = date
        calendarView?.configureCalendar(calendar, date)
    }

    override fun onSetCalendarClickListener(calendar: Calendar) {
        this.calendar = calendar
        if (currentDate == null) currentDate = Date()
        calendarView?.configureCalendar(calendar, currentDate!!)
    }
}


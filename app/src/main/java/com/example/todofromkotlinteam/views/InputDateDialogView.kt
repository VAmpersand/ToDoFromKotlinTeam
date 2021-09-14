package com.example.todofromkotlinteam.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.todofromkotlinteam.R


class InputDateDialogView: LinearLayout {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,attrs,defStyleAttr)

    @SuppressLint("WrongConstant")
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {

        initializeLayout()
        configureField()
//        val calendar = findViewById<CalendarView>(R.id.calendarView)
//        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            Toast.makeText(
//                context,
//                "$dayOfMonth/$month/$year",
//                4000,
//            ).show()}

    }

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(com.example.todofromkotlinteam.R.layout.date_input_dialog_layout, this)
    }

    @SuppressLint("WrongConstant")
    fun configureField() {
//        val calendar = findViewById<CalendarView>(R.id.calendarView)
//        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            Toast.makeText(
//                context,
//                "$dayOfMonth/$month/$year",
//                4000,
//            ).show()
        }

    }






package com.example.todofromkotlinteam

import android.annotation.SuppressLint
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.todofromkotlinteam.views.EventDataFieldType
import kotlinx.android.synthetic.main.date_input_dialog_layout.*
import kotlinx.android.synthetic.main.date_input_dialog_layout.view.*
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.time_input_dialog_layout.view.*
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year
import java.util.*


class NewEventActivity : AppCompatActivity() {


    @SuppressLint("NewApi")
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

        }

        eventDateField?.configureField(EventDataFieldType.DATE)
        eventDateField?.inputField?.setOnClickListener {
            showSetDateDialog()


        }
        eventStartTimeField?.configureField(EventDataFieldType.START_TIME)
        eventStartTimeField?.inputField?.setOnClickListener {
            showSetTimeDialog()
        }

        eventEndTimeField?.configureField(EventDataFieldType.END_TIME)
        eventEndTimeField?.inputField?.setOnClickListener {
            showSetTimeDialog()
        }
    }

    private fun showSetTimeDialog() {
        val view = View.inflate(this, R.layout.time_input_dialog_layout, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        view.okButton?.setOnClickListener {
            dialog.hide()
        }
    }

    private fun showSetDateDialog() {

        val view = View.inflate(this, R.layout.date_input_dialog_layout, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val dialog = builder.create()
//        val calendar = findViewById<CalendarView>(R.id.calendarView)
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            val correctMonth = month + 1
//            inputField?.setText("$year-$correctMonth-$dayOfMonth")
//        }
        view.okButtonDate?.setOnClickListener {


         dialog.hide()
        }

    }

//    private fun showSetDateDialog() {
//
//        val view = View.inflate(this, R.layout.date_input_dialog_layout, null)
//        val builder = AlertDialog.Builder(this)
//        builder.setView(view)
//        val dialog = builder.create()
//        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        val editText = EventDataFieldType.DATE as TextView
//        val calendar = findViewById<CalendarView>(R.id.calendarView)
//        dialog.show()
//        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        calendar.setOnDateChangeListener { view1: CalendarView, year: Int, month: Int, dayOfMonth: Int ->
//            val correctMonth = month + 1
//            editText.text = "$year-$correctMonth-$dayOfMonth"
//
//            view.okButtonDate?.setOnClickListener {
//
//
//                dialog.hide()
//            }
//
//        }
//    }

//     fun onClickOkDate(view: View){
//         val calendar = findViewById<CalendarView>(R.id.calendarView)
//         val editText = EventDataFieldType.DATE as TextView
//         calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
//             val correctMonth = month + 1
//
//             inputField?.setText("$year-$correctMonth-$dayOfMonth")
//             editText.setText("$year-$correctMonth-$dayOfMonth")
//         }
//     }


}













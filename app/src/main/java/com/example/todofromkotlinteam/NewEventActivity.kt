package com.example.todofromkotlinteam

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.todofromkotlinteam.views.EventDataFieldType
import kotlinx.android.synthetic.main.date_input_dialog_layout.*
import kotlinx.android.synthetic.main.date_input_dialog_layout.view.*
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.settings_fragment.*
import kotlinx.android.synthetic.main.settings_fragment.view.*
import kotlinx.android.synthetic.main.time_input_dialog_layout.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class NewEventActivity: AppCompatActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)
        configureFields()


    }

    fun onClickBack(view : View) { finish() }
    fun onClickAddEvent(view : View) { finish() }

    fun onClickOkDate(view: View) {


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
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

//        view.okButtonDate?.setOnClickListener {
//            dialog.hide()
//        }
    }


}

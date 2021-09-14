package com.example.todofromkotlinteam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.todofromkotlinteam.views.EventDataFieldType
import com.example.todofromkotlinteam.views.EventType
import com.example.todofromkotlinteam.views.InputTypeDialogView
import com.example.todofromkotlinteam.views.InputTypeProjectView
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.time_input_dialog_layout.view.okButton
import kotlinx.android.synthetic.main.type_project_dialog_layout.*
import kotlinx.android.synthetic.main.type_project_dialog_layout.view.*

class NewEventActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_additing_layout)

        configureFields()
    }

    fun onClickBack(view : View) { finish() }
    fun onClickAddEvent(view : View) { finish() }

    private fun configureFields() {
        eventNameField?.configureField(EventDataFieldType.NAME)
        eventDescriptionField?.configureField(EventDataFieldType.DESCRIPTION)
        eventPartnerField?.configureField(EventDataFieldType.PARTNER)

        eventTypeField?.configureField(EventDataFieldType.TYPE)
        eventTypeField?.inputField?.setOnClickListener {
            showSetTypeDialog()
        }

        eventDateField?.configureField(EventDataFieldType.DATE)
        eventDateField?.inputField?.setOnClickListener {
            showSetDataDiolog()
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

    private fun showSetTypeDialog() {
//        val view = View.inflate(this, R.layout.type_project_dialog_layout, null)
//        view.checkPlans?.isChecked = currentType == EventType.PLANS
//        view.checkIdeas?.isChecked = currentType == EventType.IDEAS
//
//        val builder = AlertDialog.Builder(this)
//        builder.setView(view)

        val dialog = InputTypeDialogView()
//        dialog.show()
        dialog.show(supportFragmentManager, "MyCustomFragment")

        dialog.okButton?.setOnClickListener {
            if (dialog.currentType == EventType.PLANS) {
                eventTypeField?.inputField?.setText(R.string.plans)
            } else if (dialog.currentType == EventType.IDEAS) {
                eventTypeField?.inputField?.setText(R.string.ideas)
            }
            dialog.hide()
        }
//        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)

//        view.checkPlans?.setOnClickListener {
//            currentType = EventType.PLANS
//            view.checkPlans?.isChecked = true
//            view.checkIdeas?.isChecked = false
//        }
//
//        view.checkIdeas?.setOnClickListener {
//            currentType = EventType.IDEAS
//            view.checkPlans?.isChecked = false
//            view.checkIdeas?.isChecked = true
//        }
//
//        view.okButton?.setOnClickListener {
//            if (currentType == EventType.PLANS) {
//                eventTypeField?.inputField?.setText(R.string.plans)
//            } else if (currentType == EventType.IDEAS) {
//                eventTypeField?.inputField?.setText(R.string.ideas)
//            }
//            dialog.hide()
//        }
    }

    private fun showSetDataDiolog() {
        val view = InputTypeProjectView(this)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        view.okButton?.setOnClickListener {
            dialog.hide()
        }
    }
}

package com.example.todofromkotlinteam.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.new_event_additing_layout.*
import kotlinx.android.synthetic.main.settings_fragment.view.*
import kotlinx.android.synthetic.main.time_input_dialog_layout.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.okButton
import java.util.*

interface OnTimeDialogButtonClickListener {
    fun onTimeOkClickListener(startTime: String, endTime: String)
}

class InputTimeDialogView(startTime: String?, endTime: String?, listener: OnTimeDialogButtonClickListener): DialogFragment() {
    private val listener = listener
    private var startTime = startTime
    private var endTime = endTime
    val calendar = Calendar.getInstance(Locale.ROOT)

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

    override fun onResume() {
        super.onResume()
        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )


        if (startTimeEditText?.text?.isEmpty() == true && endTimeEditText?.text?.isEmpty() == true) {
          val start = startTime?.replace(":".toRegex(),"")
            val end = endTime?.replace(":".toRegex(),"")
            startTimeEditText?.setText(start)
            endTimeEditText?.setText(end)

        }
    }

    private fun configureListeners() {
        okButton?.setOnClickListener {
            if (startTimeEditText.text?.isEmpty() == true) startTimeEditText?.error = "Start event!!!"
            if (endTimeEditText.text?.isEmpty() == true)  endTimeEditText?.error = "End event!!!"
            if(startTimeEditText.text?.toString() == endTimeEditText.text?.toString()){
                startTimeEditText?.error = "Invalid time!!"
                endTimeEditText?.error = "Invalid time!!"
            }
             else
            {
                val startTime = startTimeEditText?.text.toString()
            val endTime = endTimeEditText?.text.toString()

            listener.onTimeOkClickListener(startTime, endTime)
            dialog?.hide()
        }}

        for (item in arrayOf(startTimeEditText, endTimeEditText)) {
            var maxTime = "2359"
            if(item == startTimeEditText || item == endTimeEditText)  maxTime="2359"
            item?.setOnFocusChangeListener { view, isFocused ->
                view as EditText

                if (!view.text.isEmpty()) {
                    val value = view.text.toString()

                    if (!isFocused && value > maxTime) view.setText(maxTime)
                    item.mask
                    if (!isFocused && (value < "0")) view.setText("0")
                }
            }
        }
    }
}
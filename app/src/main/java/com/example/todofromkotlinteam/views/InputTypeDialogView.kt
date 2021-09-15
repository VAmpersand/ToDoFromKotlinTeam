package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.type_input_dialog_layout.*

enum class EventType {
    PLANS, IDEAS
}

interface OnTypeDialogButtonClickListener {
    fun onTypeOkClickListener(type: EventType)
}

class InputTypeDialogView(currentType: EventType?, listener: OnTypeDialogButtonClickListener) : DialogFragment() {
    private val alertClickListener = listener
    private var currentType: EventType? = currentType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.type_input_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()

        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        checkPlans?.isChecked = currentType == EventType.PLANS
        checkIdeas?.isChecked = currentType == EventType.IDEAS
    }

    private fun configureListeners() {
        checkPlans?.setOnClickListener {
            currentType = EventType.PLANS
            checkPlans?.isChecked = true
            checkIdeas?.isChecked = false
        }

        checkIdeas?.setOnClickListener {
            currentType = EventType.IDEAS
            checkPlans?.isChecked = false
            checkIdeas?.isChecked = true
        }

        okButton?.setOnClickListener {
            if (currentType != null) {
                alertClickListener.onTypeOkClickListener(currentType!!)
                dialog?.hide()
            }
        }
    }
}
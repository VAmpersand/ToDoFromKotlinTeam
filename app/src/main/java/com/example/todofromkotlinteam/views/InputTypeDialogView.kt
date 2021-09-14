package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.type_project_dialog_layout.*

class InputTypeDialogView : DialogFragment() {
    var currentType: EventType? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.type_project_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        configureListeners()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
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
    }

    fun hide() {
        dialog?.hide()
    }
}
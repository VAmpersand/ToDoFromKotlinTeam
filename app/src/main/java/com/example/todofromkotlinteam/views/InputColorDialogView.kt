package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEventType
import kotlinx.android.synthetic.main.color_theme_dialog.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.okButton

interface OnColorDialogButtonClickListener {
    fun onColorOkClickListener(type: ListEventType)
    fun onAddHexClickListener()
}

class InputColorDialogView(listener: OnColorDialogButtonClickListener) : DialogFragment(){
    private val listener = listener
    private var currentType : ListEventType? = null
    private var adapter : ColorAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.color_theme_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val events = ArrayList<ListEventType>()

        events.add(ListEventType("#FF5252", "Здоровье"))
        events.add(ListEventType("#343D8F", "Хобби"))
        events.add(ListEventType("#55A738", "Работа"))
        events.add(ListEventType("#FF5232", "Учеба"))

        rcView?.hasFixedSize()
        rcView?.layoutManager = LinearLayoutManager(context)
        adapter = ColorAdapter(events, requireContext())
        rcView?.adapter = ColorAdapter(events, requireContext())
    }

    private fun configureListeners() {
        currentType = ListEventType("#FF5252", "Здоровье")
        okButton?.setOnClickListener {
            if (currentType != null) {
                listener.onColorOkClickListener(currentType!!)
                dialog?.hide()
            }
        }

        newColorTheme?.setOnClickListener {
            listener.onAddHexClickListener()
            dialog?.hide()
        }
    }
}
